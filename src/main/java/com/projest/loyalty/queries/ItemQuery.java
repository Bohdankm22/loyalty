package com.projest.loyalty.queries;

import com.intuit.ipp.data.Item;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.QueryResult;
import com.projest.loyalty.quickbooks.DataServiceFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ItemQuery {
    private static final Logger logger = Logger.getLogger(InvoiceQuery.class);
    private static final String GET_ITEM_QUERY = "select * from item";
    private static final String GET_ITEM_BY_ID_QUERY = "select * from item where id = '";

    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_ITEM_QUERY);
            if (!queryResult.getEntities().isEmpty() && queryResult.getEntities().size() > 0) {
                items = (List<Item>) queryResult.getEntities();
            }
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return items;
    }

    public static Item getItemById(String id) {
        Item item = null;
        try {
            QueryResult queryResult = DataServiceFactory.getDataService().executeQuery(GET_ITEM_BY_ID_QUERY +
                    id + "'");
            item = (Item) queryResult.getEntities().get(0);
        } catch (FMSException e) {
            // TODO handle.
            logger.error("Could not execute query.");
        }
        return item;
    }
}
