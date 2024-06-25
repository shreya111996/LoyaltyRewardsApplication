package com.loyalyprogram.loyaltyprogram.serviceImpl;

import com.loyalyprogram.loyaltyprogram.dao.UserDao;
import com.loyalyprogram.loyaltyprogram.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createPurchase(int userId, int pointsEarned) {
        var user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.addPoints(pointsEarned);
        userDao.save(user);
    }
}
