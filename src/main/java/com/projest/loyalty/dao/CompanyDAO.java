package com.projest.loyalty.dao;

import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Company;

import java.sql.Connection;
import java.sql.SQLException;

public class CompanyDAO {
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
}
