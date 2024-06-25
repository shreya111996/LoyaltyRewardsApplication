package com.loyalyprogram.loyaltyprogram.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;

public interface RewardsDao extends JpaRepository<Reward, Integer>{

    Optional<Reward> findById(int id);
}
