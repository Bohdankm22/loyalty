package com.projest.loyalty.dao;

import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Customer;
import com.projest.loyalty.entity.Manager;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ManagerDAOTest {

    @Test
    public void getManager() throws SQLException {
        ManagerDAO managerDAO = new ManagerDAO(DBService.getMysqlConnection());
        Manager manager = managerDAO.get(1);
        assertEquals(manager.getId(), 1);
    }
}
