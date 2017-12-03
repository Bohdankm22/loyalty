package com.projest.loyalty.controllers;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.OAuth2Authorizer;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;
import com.intuit.ipp.util.Config;
import com.intuit.oauth2.client.OAuth2PlatformClient;
import com.intuit.oauth2.data.BearerTokenResponse;
import com.intuit.oauth2.data.UserInfoResponse;
import com.intuit.oauth2.exception.OAuthException;
import com.intuit.oauth2.exception.OpenIdException;
import com.projest.loyalty.dao.ManagerDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.quickbooks.ContextFactory;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import com.projest.loyalty.quickbooks.OAuth2PlatformClientFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@Controller
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class CallbackController {

    @Autowired
    org.springframework.core.env.Environment env;
    @Autowired
    OAuth2PlatformClientFactory factory;

    private static final Logger logger = Logger.getLogger(CallbackController.class);

    /**
     * This is the redirect handler you configure in your app on developer.intuit.com
     * The Authorization code has a short lifetime.
     * Hence Unless a user action is quick and mandatory, proceed to exchange the Authorization Code for
     * BearerToken
     *
     * @param authCode
     * @param state
     * @param realmId
     * @param session
     * @return
     */

    @RequestMapping("/oauth2redirect")
    public String callBackFromOAuth(@RequestParam("code") String authCode, @RequestParam("state") String state, @RequestParam(value = "realmId", required = false) String realmId, HttpSession session) {
        logger.info("inside oauth2redirect of sample");
        try {
            String csrfToken = (String) session.getAttribute("csrfToken");
            if (csrfToken.equals(state)) {
                session.setAttribute("realmId", realmId);
                session.setAttribute("auth_code", authCode);

                OAuth2PlatformClient client = factory.getOAuth2PlatformClient();
                String redirectUri = factory.getPropertyValue("OAuth2AppRedirectUri");
                logger.info("inside oauth2redirect of sample -- redirectUri " + redirectUri);
                BearerTokenResponse bearerTokenResponse = client.retrieveBearerTokens(authCode, redirectUri);

                session.setAttribute("access_token", bearerTokenResponse.getAccessToken());
                session.setAttribute("refresh_token", bearerTokenResponse.getRefreshToken());

                saveManagerInfo(bearerTokenResponse, realmId, client);
                return "managerview";
            }
            logger.info("csrf token mismatch ");
        } catch (OAuthException e) {
            logger.error("Exception in callback handler ", e);
        }
        return null;
    }

    private void saveManagerInfo(BearerTokenResponse barel, String realmId, OAuth2PlatformClient client) {
        try {

            Config.setProperty(Config.BASE_URL_QBO, env.getProperty("OAuth2AppClientId"));

            // Create OAuth object
            OAuth2Authorizer oauth = new OAuth2Authorizer(barel.getAccessToken()); //set access token obtained from BearerTokenResponse

            // Create context
            Context context = new Context(oauth, ServiceType.QBO, realmId); //set realm id

            // Create dataservice
            DataService service = new DataService(context);


            // Make the API call
            String sql = "select * from companyinfo";
            QueryResult queryResult = service.executeQuery(sql);
        } catch (FMSException e) {

        }

        UserInfoResponse response = null;
        try {
            response = client.getUserInfo(barel.getAccessToken());

            ManagerDAO managerDAO = new ManagerDAO(DBService.getMysqlConnection());
            if (!managerDAO.checkExistsByEmail(response.getEmail())) {
                managerDAO.insertManager(response.getGivenName(), response.getFamilyName(), response.getEmail(),
                        response.getPhoneNumber());
            }
        } catch (SQLException | OpenIdException e) {
            e.printStackTrace();
        }
    }


    private void saveUserInfo(String accessToken, HttpSession session, OAuth2PlatformClient client) {
        //Ideally you would fetch the realmId and the accessToken from the data store based on the user account here.

        try {
            UserInfoResponse response = client.getUserInfo(accessToken);

            session.setAttribute("sub", response.getSub());
            session.setAttribute("givenName", response.getGivenName());
            session.setAttribute("email", response.getEmail());

        } catch (Exception ex) {
            logger.error("Exception while retrieving user info ", ex);
        }
    }
}