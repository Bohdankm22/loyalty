package com.projest.loyalty.controllers;

import com.intuit.ipp.util.Config;
import com.intuit.oauth2.client.OAuth2PlatformClient;
import com.intuit.oauth2.data.BearerTokenResponse;
import com.intuit.oauth2.data.UserInfoResponse;
import com.intuit.oauth2.exception.OAuthException;
import com.intuit.oauth2.exception.OpenIdException;
import com.projest.loyalty.appinfo.ManagerInfo;
import com.projest.loyalty.dao.ManagerDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.quickbooks.OAuth2PlatformClientFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


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

                Config.setProperty(Config.BASE_URL_QBO, env.getProperty("intuit.url"));

                saveManagerInfo(bearerTokenResponse, client, realmId, session);

                return "managerview";
            }
            logger.info("csrf token mismatch ");
        } catch (OAuthException e) {
            logger.error("Exception in callback handler ", e);
        }
        return null;
    }

    private void saveManagerInfo(BearerTokenResponse barel, OAuth2PlatformClient client, String relmId, HttpSession session) {
        ManagerInfo.getInstance().setManagerToken(barel.getAccessToken());
        ManagerInfo.getInstance().setRealmId(relmId);
        UserInfoResponse response = null;
        try {
            response = client.getUserInfo(barel.getAccessToken());

            ManagerDAO managerDAO = new ManagerDAO(DBService.getMysqlConnection());
            if (!managerDAO.checkExistsByEmail(response.getEmail())) {
                managerDAO.insertManager(response.getGivenName(), response.getFamilyName(), response.getEmail(),
                        response.getPhoneNumber());
            }
            session.setAttribute(env.getProperty("manager.id"), managerDAO.getByEmail(response.getEmail()).getId());
        } catch (OpenIdException e) {
            e.printStackTrace();
        }
    }
}