package com.projest.loyalty.dao;

import com.projest.loyalty.database.Executor;
import com.projest.loyalty.entity.Manager;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerDAO {

    private Executor executor;

    public ManagerDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Manager get(long id) throws SQLException {
        return executor.execQuery(String.format("select * from Manager where manager_id=%d", id), result -> {
            result.next();
            return new Manager(result.getLong(1), result.getString(2),
                    result.getString(3), result.getString(4), result.getString(5));
        });
    }
}
