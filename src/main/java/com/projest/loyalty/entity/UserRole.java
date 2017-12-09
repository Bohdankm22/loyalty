package com.projest.loyalty.entity;

import com.projest.loyalty.exceptions.UserRoleDoesNotExistException;

public enum UserRole {

    EMPLOYEE("Employee"), ACCOUNTANT("Accountant"), MANAGER("Manager"), ADMIN("Admin"), HR("HR");

    private String role;

    private UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserRole getUserRole(String role) {
        for (UserRole userRole : values()) {
            if (userRole.role.equals(role)) {
                return userRole;
            }
        }
        throw new UserRoleDoesNotExistException(role);
    }
}
