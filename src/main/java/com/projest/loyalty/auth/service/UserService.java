package com.projest.loyalty.auth.service;

import com.projest.loyalty.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
