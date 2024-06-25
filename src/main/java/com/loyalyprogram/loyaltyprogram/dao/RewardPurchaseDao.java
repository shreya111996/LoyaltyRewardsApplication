package com.loyalyprogram.loyaltyprogram.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalyprogram.loyaltyprogram.POJO.RewardPurchase;


public interface RewardPurchaseDao extends JpaRepository<RewardPurchase, Integer>{

    Optional<RewardPurchase> findById(int id);

}
