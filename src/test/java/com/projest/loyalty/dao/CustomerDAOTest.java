package com.projest.loyalty.dao;

import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class CustomerDAOTest {

    @Test
    public void getCustomer() throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO(DBService.getMysqlConnection());
        Customer customer = customerDAO.get(1);
        assertEquals(customer.getId(), 1);
    }
}
