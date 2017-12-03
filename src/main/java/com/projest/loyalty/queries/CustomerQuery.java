package com.projest.loyalty.queries;

import com.intuit.ipp.data.Customer;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.QueryResult;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import org.apache.log4j.Logger;

public class CustomerQuery {
    private static final Logger logger = Logger.getLogger(CustomerQuery.class);
    private static final String GET_CUSTOMER_QUERY = "select * from customer";

    public Customer getCustomerQuery() {
        Customer customer = null;
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_CUSTOMER_QUERY);
            if (!queryResult.getEntities().isEmpty() && queryResult.getEntities().size() > 0) {
                customer = (com.intuit.ipp.data.Customer) queryResult.getEntities().get(0);
            }
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return customer;
    }
}
