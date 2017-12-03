package com.projest.loyalty.dao;

import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Company;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class CompanyDAO {
    private static final Logger logger = Logger.getLogger(CompanyDAO.class);
    private Executor executor;

    public CompanyDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Company get(long id) throws SQLException {
        return executor.execQuery(String.format("select * from Company where company_id=%d", id), result -> {
            result.next();
            return new Company(result.getLong(1), result.getString(2));
        });
    }

    public Company getCompanyByManagerEmail(String email) {
        try {
            return executor.execQuery(String.format("SELECT *\n" +
                    "FROM Company JOIN CompanyManager ON Company.company_id=CompanyManager.cm_company_id\n" +
                    "  JOIN Manager ON CompanyManager.cm_manager_id = Manager.manager_id WHERE manager_email='%s';", email), result -> {
                result.next();
                return new Company(result.getLong(1), result.getString(2));
            });
        } catch (SQLException e) {
            logger.error("Error executing query", e);
        }
        return null;
    }

    public Company getCompanyByManagerId(long id) {
        try {
            return executor.execQuery(String.format("SELECT *\n" +
                    "FROM Company JOIN CompanyManager ON Company.company_id=CompanyManager.cm_company_id" +
                    "  WHERE cm_manager_id=%d;", id), result -> {
                result.next();
                return new Company(result.getLong(1), result.getString(2));
            });
        } catch (SQLException e) {
            logger.error("Error executing query", e);
        }
        return null;
    }
}
