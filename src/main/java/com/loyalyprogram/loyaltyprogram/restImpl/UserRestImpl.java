package com.loyalyprogram.loyaltyprogram.restImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;
import com.loyalyprogram.loyaltyprogram.POJO.User;
import com.loyalyprogram.loyaltyprogram.constants.LoyaltyConstants;
import com.loyalyprogram.loyaltyprogram.dao.UserDao;
import com.loyalyprogram.loyaltyprogram.initializer.LoginResponse;
import com.loyalyprogram.loyaltyprogram.rest.UserRest;
import com.loyalyprogram.loyaltyprogram.service.RewardService;
import com.loyalyprogram.loyaltyprogram.service.UserService;
import com.loyalyprogram.loyaltyprogram.utils.LoyaltyUtils;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class UserRestImpl implements UserRest{

    @Autowired
    UserService userService;

    @Autowired
    private RewardService rewardService;

    @Autowired
    private UserDao userDao;
    
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        
        // throw new UnsupportedOperationException("Unimplemented method 'signUp'");

        try {
            return userService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoyaltyUtils.getResponseEntity(LoyaltyConstants.SOMETHING_WENT_WRONG ,HttpStatus.INTERNAL_SERVER_ERROR);
    } 

    @Override
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> requestMap) {
        log.info("Inside login {}", requestMap);
        try {
            String email = requestMap.get("email");
            String password = requestMap.get("password");
            
            if (email != null && password != null) {
                //return userService.login(requestMap);
                ResponseEntity<String> loginResponse = userService.login(requestMap);
                if (loginResponse.getStatusCode() == HttpStatus.OK) {
                    List<Reward> rewards = rewardService.getAllRewards();
                    LoginResponse response = new LoginResponse();
                    response.setMessage(loginResponse.getBody());
                    response.setRewards(rewards);
                    return ResponseEntity.ok(response);
                } 
                else {
                    new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }}
            else {
                return new ResponseEntity<>(new LoginResponse(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new LoginResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
        Optional<User> user = userDao.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}