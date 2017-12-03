package com.projest.loyalty.quickbooks;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.IAuthorizer;
import com.intuit.ipp.security.OAuth2Authorizer;
import com.intuit.ipp.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.http.HttpSession;


@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class ContextFactory {

    private static final org.slf4j.Logger LOG = Logger.getLogger();

    private static final String companyID = "realmId";
    private static final String bearerToken = "access_token";


    /**
     * Initializes Context for a given app/company profile
     */
    public static Context getContext(HttpSession httpSession) throws FMSException {
        //create oauth object
        IAuthorizer oauth = new OAuth2Authorizer((String) httpSession.getAttribute((bearerToken)));

        return new Context(oauth, ServiceType.QBO, (String) httpSession.getAttribute((companyID)));
    }
}
