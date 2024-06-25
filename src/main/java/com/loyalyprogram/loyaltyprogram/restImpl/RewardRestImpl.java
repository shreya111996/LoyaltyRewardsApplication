package com.loyalyprogram.loyaltyprogram.restImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;
import com.loyalyprogram.loyaltyprogram.rest.RewardRest;
import com.loyalyprogram.loyaltyprogram.service.RewardService;


@RestController
public class RewardRestImpl implements RewardRest {

    @Autowired
    private RewardService rewardService;

    @Override
    public ResponseEntity<List<Reward>> showRewards() {
        List<Reward> rewards = rewardService.getAllRewards();
        return ResponseEntity.ok(rewards);
    }
}
