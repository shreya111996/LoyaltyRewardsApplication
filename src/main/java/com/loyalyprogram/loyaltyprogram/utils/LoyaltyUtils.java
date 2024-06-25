package com.loyalyprogram.loyaltyprogram.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoyaltyUtils {
 
    
    private LoyaltyUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
    
}