package com.loyalyprogram.loyaltyprogram.rest;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loyalyprogram.loyaltyprogram.POJO.User;
import com.loyalyprogram.loyaltyprogram.initializer.LoginResponse;

@RequestMapping(path = "/user")
public interface UserRest {

    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/login")
    ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> requestMap);

    @GetMapping(path = "/{id}")
    ResponseEntity<Optional<User>> getUserById(@PathVariable int id);

}