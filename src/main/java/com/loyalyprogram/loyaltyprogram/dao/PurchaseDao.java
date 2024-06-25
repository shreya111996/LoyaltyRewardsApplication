package com.loyalyprogram.loyaltyprogram.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.loyalyprogram.loyaltyprogram.POJO.Purchase;

public interface PurchaseDao extends CrudRepository<Purchase, Integer> {
    @Query("SELECT SUM(p.pointsEarned) FROM Purchase p WHERE p.user.id = :userId")
    Integer findTotalPointsByUserId(int userId);
}
