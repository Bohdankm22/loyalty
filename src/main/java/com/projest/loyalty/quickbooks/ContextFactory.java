package com.projest.loyalty.quickbooks;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.IAuthorizer;
import com.intuit.ipp.security.OAuth2Authorizer;
import com.intuit.ipp.util.Logger;
import com.projest.loyalty.appinfo.ManagerInfo;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class ContextFactory {

    /**
     * Initializes Context for a given app/company profile
     */
    public static Context getContext() throws FMSException {
        IAuthorizer oauth = new OAuth2Authorizer(ManagerInfo.getInstance().getManagerToken());

        return new Context(oauth, ServiceType.QBO, ManagerInfo.getInstance().getRealmId());
    }
}
