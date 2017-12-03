package com.projest.loyalty.dao;

import com.projest.loyalty.controllers.LoyaltyProgramsController;
import com.projest.loyalty.database.DBService;
import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Company;
import com.projest.loyalty.entity.LoyaltyProgram;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class LoyaltyProgramDAO {
    private static final Logger logger = Logger.getLogger(LoyaltyProgramsController.class);
    private Executor executor;

    public LoyaltyProgramDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public LoyaltyProgram get(long id) {
        try {
            return executor.execQuery(String.format("select * from LoyaltyProgram where loyalty_id=%d", id), result -> {
                result.next();
                return new LoyaltyProgram(result.getLong(1), result.getString(2),
                        new CompanyDAO(DBService.getMysqlConnection()).get(result.getLong(3)));
            });
        } catch (SQLException e) {
            logger.error("Could not execute query", e);
        }
        return null;
    }

    public LoyaltyProgram getLoyaltyByCompany(Company company) {
        try {
            return executor.execQuery(String.format("SELECT *" +
                    "FROM LoyaltyProgram " +
                    "WHERE loyalty_company_id=%d;", company.getId()), result -> {
                result.next();
                return new LoyaltyProgram(result.getLong(1), result.getString(2),
                        new CompanyDAO(DBService.getMysqlConnection()).get(result.getLong(3)));
            });
        } catch (SQLException e) {
            logger.error("Could not execute query", e);
        }
        return null;
    }
}
