package com.loyalyprogram.loyaltyprogram.rest;

import com.loyalyprogram.loyaltyprogram.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRest {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/create")
    public ResponseEntity<String> createPurchase(@RequestBody Map<String, Object> purchaseData) {
        if (purchaseData.containsKey("userId") && purchaseData.containsKey("pointsEarned")) {
            int userId = (int) purchaseData.get("userId");
            int pointsEarned = (int) purchaseData.get("pointsEarned");

            try {
                purchaseService.createPurchase(userId, pointsEarned);
                return ResponseEntity.ok("Purchase created successfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create purchase: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: One or more required fields are missing in the request body");
        }
    }
}
