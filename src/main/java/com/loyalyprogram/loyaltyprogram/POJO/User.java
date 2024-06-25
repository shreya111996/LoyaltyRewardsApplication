package com.loyalyprogram.loyaltyprogram.POJO;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@NamedQuery(name="User.findByEmailId", query = "select u from User u where u.email=:email")
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "current_points")
    private int current_points;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchases;

    public void addPoints(int points) {
        this.current_points += points;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
        purchase.setUser(this);
    }
}
