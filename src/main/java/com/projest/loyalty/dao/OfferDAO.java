package com.projest.loyalty.dao;

import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Manager;
import com.projest.loyalty.entity.Offer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferDAO {

    private static final Logger logger = Logger.getLogger(OfferDAO.class);
    private Executor executor;
    private List<Offer> offers;

    public OfferDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Manager get(long id) throws SQLException {
        return executor.execQuery(String.format("select * from Manager where manager_id=%d", id), result -> {
            result.next();
            return new Manager(result.getLong(1), result.getString(2),
                    result.getString(3), result.getString(4), result.getString(5));
        });
    }

    public boolean insertOffer(String name, String desc, String type, Long offerDis, Long points) {
        try {
            executor.execQuery(String.format("INSERT INTO Offer (offer_name, offer_description, " +
                    "offer_type, offer_discount, offer_points)" +
                    "VALUES ('%s', '%s', '%s', %d, %d);", name, desc, type, offerDis, points));
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean insertOffer(Offer offer) {
        return insertOffer(offer.getName(), offer.getDescription(), offer.getType(), offer.getDiscount(), offer.getPoints());
    }

    public List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();
        try {
            return executor.execQuery("select * from Offer", result -> {
                while (result.next()) {
                    offers.add(new Offer(result.getLong(1), result.getString(2),
                            result.getString(3), result.getString(4), result.getLong(5),
                            result.getLong(6)));
                }
                return offers;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offers;
    }
}
