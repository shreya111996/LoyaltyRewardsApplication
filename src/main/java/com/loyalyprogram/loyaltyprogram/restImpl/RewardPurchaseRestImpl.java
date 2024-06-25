package com.loyalyprogram.loyaltyprogram.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loyalyprogram.loyaltyprogram.rest.RewardPurchaseRest;
import com.loyalyprogram.loyaltyprogram.service.RewardPurchaseService;


@RestController
public class RewardPurchaseRestImpl implements RewardPurchaseRest{

    @Autowired
    private RewardPurchaseService rewardPurchaseService;

    @Override
    public ResponseEntity<?> purchaseReward(@RequestBody Map<String, Integer> payload) {
        int rewardId = payload.get("rewardId");
        int userId = payload.get("userId");
        
        try {
            rewardPurchaseService.createPurchase(rewardId, userId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    

}
