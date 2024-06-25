package com.loyalyprogram.loyaltyprogram.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/rewardpurchase")
public interface RewardPurchaseRest {

    @PostMapping
    public ResponseEntity<?> purchaseReward(@RequestBody Map<String, Integer> payload);
}
