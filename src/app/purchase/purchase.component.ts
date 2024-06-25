import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PurchaseService } from '../services/purchase.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {
  items = [
    {
      name: 'Wireless Headphones',
      description: 'High-quality wireless headphones with noise-cancellation and long battery life.',
      image: 'assets/images/wireless-headphones.jpg',
      price: '$99.99',
      pointsEarned: 150
    },
    {
      name: 'Smartwatch',
      description: 'Stylish smartwatch with fitness tracking and heart rate monitoring.',
      image: 'assets/images/smartwatch.jpg',
      price: '$149.99',
      pointsEarned: 200
    },
    {
      name: 'Portable Bluetooth Speaker',
      description: 'Compact and powerful Bluetooth speaker with excellent sound quality.',
      image: 'assets/images/bluetooth-speaker.jpg',
      price: '$79.99',
      pointsEarned: 80
    },
    {
      name: 'E-Reader',
      description: 'Lightweight e-reader with a high-resolution display and adjustable lighting.',
      image: 'assets/images/ereader.jpg',
      price: '$129.99',
      pointsEarned: 140
    },
    {
      name: 'Fitness Tracker',
      description: 'Advanced fitness tracker with multiple sports modes and sleep tracking.',
      image: 'assets/images/fitness-tracker.jpg',
      price: '$59.99',
      pointsEarned: 50
    },
    {
      name: 'Smart Home Assistant',
      description: 'Voice-controlled smart home assistant with AI capabilities.',
      image: 'assets/images/home-assistant.jpg',
      price: '$89.99',
      pointsEarned: 60
    },
    {
      name: 'Laptop Backpack',
      description: 'Durable and spacious laptop backpack with multiple compartments.',
      image: 'assets/images/laptop-backpack.jpg',
      price: '$69.99',
      pointsEarned: 70
    },
    {
      name: 'Wireless Charger',
      description: 'Fast and convenient wireless charger compatible with various devices.',
      image: 'assets/images/wireless-charger.jpg',
      price: '$29.99',
      pointsEarned: 15
    },
    {
      name: 'Noise-Canceling Earbuds',
      description: 'Compact noise-canceling earbuds with high-quality sound and long battery life.',
      image: 'assets/images/earbuds.jpg',
      price: '$49.99',
      pointsEarned: 30
    },
    {
      name: 'Action Camera',
      description: 'Waterproof action camera with 4K video recording and image stabilization.',
      image: 'assets/images/action-camera.jpg',
      price: '$199.99',
      pointsEarned: 250
    },
    {
      name: 'Digital Photo Frame',
      description: 'Wi-Fi enabled digital photo frame with a high-resolution display.',
      image: 'assets/images/photo-frame.jpg',
      price: '$79.99',
      pointsEarned: 60
    },
    {
      name: 'Electric Toothbrush',
      description: 'Smart electric toothbrush with multiple brushing modes and a long-lasting battery.',
      image: 'assets/images/toothbrush.jpg',
      price: '$39.99',
      pointsEarned: 30
    },
    {
      name: 'Portable Power Bank',
      description: 'High-capacity portable power bank with fast charging capabilities.',
      image: 'assets/images/power-bank.jpg',
      price: '$24.99',
      pointsEarned: 25
    },
    {
      name: 'Smart Thermostat',
      description: 'Energy-saving smart thermostat with remote control via mobile app.',
      image: 'assets/images/thermostat.jpg',
      price: '$129.99',
      pointsEarned: 150
    },
    {
      name: 'Gaming Mouse',
      description: 'Ergonomic gaming mouse with customizable buttons and RGB lighting.',
      image: 'assets/images/gaming-mouse.jpg',
      price: '$49.99',
      pointsEarned: 40
    }
  ];

  constructor(
    private purchaseService: PurchaseService,
    private userService: UserService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  buyItem(item: any): void {
    const userId = this.userService.getCurrentUserId();
    const purchaseData = { userId: userId, pointsEarned: item.pointsEarned };

    this.purchaseService.createPurchase(purchaseData).subscribe(
      response => {
        alert(`Purchase successful! You earned ${item.pointsEarned} points.\nPlease visit the Rewards Catalog to redeem it.`);
      },
      error => {
        console.error('Purchase failed:', error);
        alert('Purchase failed: ' + error.error.message);
      }
    );
  }
}