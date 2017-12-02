package com.projest.loyalty.controllers;

import com.intuit.oauth2.config.OAuth2Config;
import com.intuit.oauth2.config.Scope;
import com.intuit.oauth2.exception.InvalidRequestException;
import com.projest.loyalty.quickbooks.OAuth2PlatformClientFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ManagerLogInController {
    @Autowired
    OAuth2PlatformClientFactory factory;
    private static final Logger logger = Logger.getLogger(LogInController.class);


    /**
     * Controller mapping for connectToQuickbooks button
     * @return
     */
    @RequestMapping("/connectToQuickbooks")
    public View connectToQuickbooks(HttpSession session) {
        logger.info("inside connectToQuickbooks ");
        OAuth2Config oauth2Config = factory.getOAuth2Config();

        String redirectUri = factory.getPropertyValue("OAuth2AppRedirectUri");

        String csrf = oauth2Config.generateCSRFToken();
        session.setAttribute("csrfToken", csrf);
        try {
            List<Scope> scopes = new ArrayList<Scope>();
            scopes.add(Scope.All);
            return new RedirectView(oauth2Config.prepareUrl(scopes, redirectUri, csrf), true, true, false);
        } catch (InvalidRequestException e) {
            logger.error("Exception calling connectToQuickbooks ", e);
        }
        return null;
    }

    /**
     * Controller mapping for signInWithIntuit button
     * @return
     */
    @RequestMapping("/signInWithIntuit")
    public View signInWithIntuit(HttpSession session) {
        logger.info("inside signInWithIntuit ");
        OAuth2Config oauth2Config = factory.getOAuth2Config();

        String csrf = oauth2Config.generateCSRFToken();
        session.setAttribute("csrfToken", csrf);

        String redirectUri = factory.getPropertyValue("OAuth2AppRedirectUri");
        try {
            List<Scope> scopes = new ArrayList<Scope>();
            scopes.add(Scope.OpenIdAll);
            return new RedirectView(oauth2Config.prepareUrl(scopes, redirectUri, csrf), true, true, false);
        } catch (InvalidRequestException e) {
            logger.error("Exception calling signInWithIntuit ", e);
        }
        return null;

    }

    /**
     * Controller mapping for getAppNow button
     * @return
     */
    @RequestMapping("/getAppNow")
    public View getAppNow(HttpSession session) {
        logger.info("inside getAppNow "  );
        OAuth2Config oauth2Config = factory.getOAuth2Config();

        String csrf = oauth2Config.generateCSRFToken();
        session.setAttribute("csrfToken", csrf);

        String redirectUri = factory.getPropertyValue("OAuth2AppRedirectUri");
        try {
            List<Scope> scopes = new ArrayList<Scope>();
            scopes.add(Scope.OpenIdAll);
            scopes.add(Scope.Accounting);
            return new RedirectView(oauth2Config.prepareUrl(scopes, redirectUri, csrf), true, true, false);
        } catch (InvalidRequestException e) {
            logger.error("Exception calling getAppNow ", e);
        }
        return null;
    }
}
