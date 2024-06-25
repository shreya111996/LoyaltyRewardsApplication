package com.loyalyprogram.loyaltyprogram.POJO;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "points_earned")
    private int pointsEarned;
}
