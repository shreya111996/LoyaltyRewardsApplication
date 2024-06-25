package com.loyalyprogram.loyaltyprogram.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.loyalyprogram.loyaltyprogram.POJO.User;

public interface UserDao extends JpaRepository <User, Integer>{

    User findByEmailId(@Param("email") String email);
    // User findById(@Param("id") int id);

    Optional<User> findById(int id);
}
