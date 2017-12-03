package com.projest.loyalty.quickbooks;

import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;

public class DataServiceFactory {


    /**
     * Initializes DataService for a given app/company profile
     *
     * @return
     * @throws FMSException
     */
    public static DataService getDataService() throws FMSException {
        return new DataService(ContextFactory.getContext());
    }
}
