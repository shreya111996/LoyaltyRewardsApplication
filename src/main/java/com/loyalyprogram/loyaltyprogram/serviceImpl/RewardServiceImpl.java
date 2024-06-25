package com.loyalyprogram.loyaltyprogram.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;
import com.loyalyprogram.loyaltyprogram.dao.RewardsDao;
import com.loyalyprogram.loyaltyprogram.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
    
    @Autowired
    private RewardsDao rewardRepository;

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    // public void saveAllRewards(List<Reward> rewards) {
    //     rewardRepository.saveAll(rewards);
    // }
}

