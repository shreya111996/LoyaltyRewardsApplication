package com.loyalyprogram.loyaltyprogram.initializer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.loyalyprogram.loyaltyprogram.POJO.Reward;

@Component
public class RewardInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        List<Reward> rewards = new ArrayList<>();
        
        rewards.add(new Reward("Gift Card", "Gourmet Grocer Gift Card", "Enjoy fresh, organic produce and specialty foods from our partner gourmet grocer.", 1500));
        rewards.add(new Reward("Gift Card", "Tech Haven Gift Card", "Upgrade your tech with the latest gadgets and accessories from Tech Haven.", 2000));
        rewards.add(new Reward("Gift Card", "Bookworm Paradise Gift Card", "Dive into a new adventure with books from all genres at Bookworm Paradise.", 1200));
        rewards.add(new Reward("Gift Card", "Adventure Gear Gift Card", "Equip yourself with high-quality outdoor and adventure gear for your next expedition.", 2500));
        rewards.add(new Reward("Gift Card", "Pamper Yourself Gift Card", "Indulge in spa treatments, beauty products, and wellness services with this pampering gift card.", 1800));
        rewards.add(new Reward("Coupon", "10% Off Next Purchase Coupon", "Save 10% on your next purchase at our online store. Valid on all items", 200));
        rewards.add(new Reward("Coupon", "Free Shipping Coupon", "Enjoy free shipping on your next order, no minimum purchase required.", 150));
        rewards.add(new Reward("Coupon", "Buy One Get One Free Coupon", "Buy one item and get another item of equal or lesser value for free", 300));
        rewards.add(new Reward("Coupon", "$10 Off $50 Purchase Coupon", "Get $10 off when you spend $50 or more in a single transaction", 250));
        rewards.add(new Reward("Coupon", "Exclusive Early Access Coupon", "Gain exclusive early access to our new product launches and limited editions.", 350));
        rewards.add(new Reward("Items to Purchase", "Smart Fitness Tracker", "Track your steps, heart rate, and sleep patterns with this stylish smart fitness tracker.", 3500));
        rewards.add(new Reward("Items to Purchase", "Wireless Earbuds", "Enjoy high-quality sound with these sleek, noise-canceling wireless earbuds.", 4000));
        rewards.add(new Reward("Items to Purchase", "Gourmet Coffee Subscription", "Receive a monthly shipment of premium, freshly roasted coffee beans.", 2200));
        rewards.add(new Reward("Items to Purchase", "Customizable Notebook Set", "A set of three customizable notebooks, perfect for journaling, sketching, and notes.", 1000));
        rewards.add(new Reward("Items to Purchase", "Eco-Friendly Water Bottle", "Stay hydrated with this durable, eco-friendly water bottle made from sustainable materials.", 800));

        //rewardService.saveAllRewards(rewards);
    }
}
