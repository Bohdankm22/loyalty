package com.projest.loyalty.queries;

import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.QueryResult;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class InvoiceQuery {
    private static final Logger logger = Logger.getLogger(InvoiceQuery.class);
    private static final String GET_INVOICE_QUERY = "select * from invoice";
    private static final String GET_INVOICE_BY_ID_QUERY ="select * from invoice where id = '";


    public static List<Invoice> getAllInvoiceQuery() {
        List<Invoice> invoices = new ArrayList<>();
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_INVOICE_QUERY);
            if (!queryResult.getEntities().isEmpty() && queryResult.getEntities().size() > 0) {
                invoices = (List<Invoice>) queryResult.getEntities();
            }
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return invoices;
    }

    public static Invoice getInvoiceById(String id) {
        Invoice invoice = null;
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_INVOICE_BY_ID_QUERY +
                    id + "'");
            invoice = (Invoice) queryResult.getEntities().get(0);
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return invoice;
    }
}
