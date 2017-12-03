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

    public boolean checkExistsByEmail(String email) {
        Manager manager = null;
        try {
            manager = executor.execQuery(String.format("select * from Manager where manager_email='%s'", email), result -> {
                result.next();
                return new Manager(result.getLong(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5));
            });
        } catch (SQLException e) { //ignore
        }
        return manager != null;
    }

    public boolean insertManager(String givenName, String familyName, String email, String phoneNumber) {
        try {
            executor.execQuery(String.format("INSERT INTO Manager (manager_first_name, manager_last_name, " +
                    "manager_email, manager_phone_numb)" +
                    "VALUES ('%s', '%s', '%s', '%s');", givenName, familyName, email, phoneNumber));
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
