package com.loyalyprogram.loyaltyprogram.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.loyalyprogram.loyaltyprogram.POJO.User;

public interface UserService {

    ResponseEntity<String> signUp(Map<String, String> requestMap);
    ResponseEntity<String> login(Map<String, String> requestMap);
    
    User getUserByEmail(String email);
    void updateUserPoints(int userId, int points);
    User getUserById(int id);

}
