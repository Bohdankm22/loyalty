package com.projest.loyalty.dao;

import com.projest.loyalty.database.DBService;
import com.projest.loyalty.entity.Company;
import com.projest.loyalty.entity.Customer;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class CompanyDAOTest {

    @Test
    public void getCompany() throws SQLException {
        CompanyDAO companyDAO = new CompanyDAO(DBService.getMysqlConnection());
        Company company = companyDAO.get(1);
        assertEquals(company.getId(), 1);
    }
}
