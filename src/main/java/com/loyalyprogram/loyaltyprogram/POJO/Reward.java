package com.loyalyprogram.loyaltyprogram.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "reward")
public class Reward {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id; 
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "pointval")
    private int pointValue;

    public Reward() {
    }
    
    public Reward(String category, String name, String description, int pointValue) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.pointValue = pointValue;
    }
    
}
