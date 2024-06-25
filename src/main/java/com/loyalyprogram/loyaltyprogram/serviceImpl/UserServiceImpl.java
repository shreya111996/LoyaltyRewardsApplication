package com.loyalyprogram.loyaltyprogram.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loyalyprogram.loyaltyprogram.POJO.User;
import com.loyalyprogram.loyaltyprogram.constants.LoyaltyConstants;
import com.loyalyprogram.loyaltyprogram.dao.UserDao;
import com.loyalyprogram.loyaltyprogram.service.UserService;
import com.loyalyprogram.loyaltyprogram.utils.LoyaltyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return LoyaltyUtils.getResponseEntity("User uccessfully Registered", HttpStatus.OK);
                } else {
                    return LoyaltyUtils.getResponseEntity("Email Already Exist", HttpStatus.BAD_REQUEST);
                }
            } else {
                return LoyaltyUtils.getResponseEntity(LoyaltyConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return LoyaltyUtils.getResponseEntity(LoyaltyConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Inside login {}", requestMap);
        try {
            if (requestMap.containsKey("email") && requestMap.containsKey("password")) {
                User user = userDao.findByEmailId(requestMap.get("email"));
                if (!Objects.isNull(user) && user.getPassword().equals(requestMap.get("password"))) {
                    Map<String, Object> response = new HashMap<>();
                    response.put("message", "Login successful");
                    response.put("userId", user.getId()); // Assuming `getId()` returns the user ID
                    return new ResponseEntity<>(user.getId().toString(), HttpStatus.OK);
                    // return LoyaltyUtils.getResponseEntity("Login successful", HttpStatus.OK);
                } else {
                    return LoyaltyUtils.getResponseEntity("Invalid email or password", HttpStatus.UNAUTHORIZED);
                }
            } else {
                return LoyaltyUtils.getResponseEntity(LoyaltyConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Error in login: ", e);
            return LoyaltyUtils.getResponseEntity(LoyaltyConstants.SOMETHING_WENT_WRONG,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {

        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password")) {
            return true;
        }
        return false;
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setCurrent_points(0);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmailId(email);
    }

    @Override
    public void updateUserPoints(int userId, int points) {
        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setCurrent_points(user.getCurrent_points() + points);
            userDao.save(user);
        }
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser = userDao.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
    }

}