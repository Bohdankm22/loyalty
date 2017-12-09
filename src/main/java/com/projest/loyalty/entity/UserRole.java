package com.projest.loyalty.entity;

import com.projest.loyalty.exceptions.UserRoleDoesNotExistException;

public enum UserRole {

    EMPLOYEE("Employee"), ACCOUNTANT("Accountant"), MANAGER("Manager"), ADMIN("Admin"), HR("HR");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public static UserRole getUserRole(String role) {
        for (UserRole userRole : values()) {
            if (userRole.role.toUpperCase().equals(role.toUpperCase())) {
                return userRole;
            }
        }
        throw new UserRoleDoesNotExistException(role);
    }

    public String getRole() {
        return role;
    }
}
