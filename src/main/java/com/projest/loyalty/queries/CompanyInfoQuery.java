package com.projest.loyalty.queries;

import com.intuit.ipp.data.CompanyInfo;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.QueryResult;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import org.apache.log4j.Logger;

public class CompanyInfoQuery {
    private static final Logger logger = Logger.getLogger(CompanyInfoQuery.class);
    private static final String GET_COMPANY_INFO_QUERY = "select * from companyinfo";

    public CompanyInfo getCompanyInfo() {
        CompanyInfo companyInfo = null;
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_COMPANY_INFO_QUERY);
            if (!queryResult.getEntities().isEmpty() && queryResult.getEntities().size() > 0) {
                companyInfo = (com.intuit.ipp.data.CompanyInfo) queryResult.getEntities().get(0);
            }
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return companyInfo;
    }
}
