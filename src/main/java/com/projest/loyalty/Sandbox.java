package com.projest.loyalty;

import com.projest.loyalty.dao.CustomerDAO;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;

import java.sql.SQLException;

public class Sandbox {

    public static void main(String[] args) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO(DBService.getMysqlConnection());
        Customer customer = customerDAO.get(1);
        System.out.println(customer);
    }
}
