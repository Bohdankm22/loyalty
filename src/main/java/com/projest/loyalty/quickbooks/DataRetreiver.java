package com.projest.loyalty.quickbooks;

import com.intuit.ipp.exception.FMSException;
import com.projest.loyalty.entity.Company;
import org.apache.log4j.Logger;

public class DataRetreiver {

    private static final Logger logger = Logger.getLogger(DataRetreiver.class);
    public static DataRetreiver instance = new DataRetreiver();

    private static final String GET_COMPANY_INFO_QUERY = "select * from companyinfo";

    private DataRetreiver() {}

    public static DataRetreiver getInstance() {
        return instance;
    }

    public Company getCompany() {
        try {
            DataServiceFactory.getDataService().executeQuery(GET_COMPANY_INFO_QUERY);
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return null;
    }
}
