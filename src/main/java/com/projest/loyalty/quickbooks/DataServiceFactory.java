package com.projest.loyalty.quickbooks;

import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;

import javax.servlet.http.HttpSession;

public class DataServiceFactory {


    /**
     * Initializes DataService for a given app/company profile
     *
     * @return
     * @throws FMSException
     */
    public static DataService getDataService(HttpSession session) throws FMSException {
        return new DataService(ContextFactory.getContext(session));
    }
}
