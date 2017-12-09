package com.projest.loyalty.exceptions;

public class UserRoleDoesNotExistException extends RuntimeException {
    public UserRoleDoesNotExistException(String role) {
        super(String.format("The role %s does not exists!", role));
    }
}
