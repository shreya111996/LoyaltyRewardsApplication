package com.loyalyprogram.loyaltyprogram.initializer;

import java.util.List;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;

public class LoginResponse {
    private String message;
    private List<Reward> rewards;

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String object) {
        this.message = object;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
}
