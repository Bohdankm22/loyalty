package com.projest.loyalty.dao;

import com.projest.loyalty.database.DBService;
import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Company;
import com.projest.loyalty.entity.LoyaltyProgram;

import java.sql.Connection;
import java.sql.SQLException;

public class LoyaltyProgramDAO {
    private Executor executor;

    public LoyaltyProgramDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public LoyaltyProgram get(long id) throws SQLException {
        return executor.execQuery(String.format("select * from LoyaltyProgram where loyalty_id=%d", id), result -> {
            result.next();
            return new LoyaltyProgram(result.getLong(1), result.getString(2),
                    new CompanyDAO(DBService.getMysqlConnection()).get(result.getLong(3)));
        });
    }
}
