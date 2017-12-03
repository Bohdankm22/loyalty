package com.projest.loyalty.queries;

import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.QueryResult;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import org.apache.log4j.Logger;

public class InvoiceQuery {
    private static final Logger logger = Logger.getLogger(InvoiceQuery.class);
    private static final String GET_INVOICE_QUERY = "select * from invoice";

    public Invoice getInvoiceQuery() {
        Invoice invoice = null;
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_INVOICE_QUERY);
            if (!queryResult.getEntities().isEmpty() && queryResult.getEntities().size() > 0) {
                invoice = (com.intuit.ipp.data.Invoice) queryResult.getEntities().get(0);
            }
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return invoice;
    }
}
