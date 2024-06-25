package com.loyalyprogram.loyaltyprogram.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;

@RequestMapping(path = "/reward")
public interface RewardRest {

    @GetMapping
    public ResponseEntity<List<Reward>> showRewards();
}
