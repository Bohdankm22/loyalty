package com.projest.loyalty.repository;

import com.projest.loyalty.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("from User where login=:login and password=:password")
    User findByLoginPassword(@Param("login") String login, @Param("password") String password);

    @Query("from User where user_role=:role")
    Iterable<User> findByRole(@Param("role") int role);
}