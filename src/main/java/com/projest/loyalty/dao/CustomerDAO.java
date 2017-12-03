package com.projest.loyalty.dao;

import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDAO {

    private Executor executor;

    public CustomerDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Customer get(long id) throws SQLException {
        return executor.execQuery(String.format("select * from customer where customer_id=%d", id), result -> {
            result.next();
            return new Customer(result.getLong(1), result.getString(2),
                    result.getString(3), result.getString(4), result.getString(5),
                    result.getString(6));
        });
    }

    public Customer getCustomerByLogin(String login) {
        try {
            return executor.execQuery(String.format("select * from customer where customer_login='%s'", login), result -> {
                result.next();
                return new Customer(result.getLong(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
