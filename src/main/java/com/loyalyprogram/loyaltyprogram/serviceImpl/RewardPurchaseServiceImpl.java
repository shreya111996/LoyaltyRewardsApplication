package com.loyalyprogram.loyaltyprogram.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;
import com.loyalyprogram.loyaltyprogram.POJO.RewardPurchase;
import com.loyalyprogram.loyaltyprogram.POJO.User;
import com.loyalyprogram.loyaltyprogram.dao.RewardPurchaseDao;
import com.loyalyprogram.loyaltyprogram.dao.RewardsDao;
import com.loyalyprogram.loyaltyprogram.dao.UserDao;
import com.loyalyprogram.loyaltyprogram.service.RewardPurchaseService;

@Service
public class RewardPurchaseServiceImpl implements RewardPurchaseService {

    @Autowired
    private RewardPurchaseDao rewardPurchaseDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RewardsDao rewardsDao;

    @Override
    public void createPurchase(int rewardId, int userId) {
        System.out.println(userId);
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Reward reward = rewardsDao.findById(rewardId).orElseThrow(() -> new RuntimeException("Reward not found"));

        
        if (user.getCurrent_points() >= reward.getPointValue()) {
            user.setCurrent_points(user.getCurrent_points() - reward.getPointValue());
            userDao.save(user);

            RewardPurchase purchase = new RewardPurchase();
            purchase.setUser(user);
            purchase.setReward(reward);
            purchase.setPointsEarned(reward.getPointValue());
            rewardPurchaseDao.save(purchase);
        } else {
            throw new RuntimeException("Not enough points to redeem this reward");
        }
    }
}
