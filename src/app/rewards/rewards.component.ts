import { Component, OnInit } from '@angular/core';
import { RewardService } from '../services/reward.service';
import { Reward } from '../model/reward.model';
import { RewardPurchase } from '../model/reward-purchase.model';
import { UserService } from '../user.service';
import { User } from 'src/user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-rewards',
  templateUrl: './rewards.component.html',
  styleUrls: ['./rewards.component.css']
})
export class RewardsComponent implements OnInit {

  id: number;
  user: User;
  rewards: Reward[] = [];

  constructor(private route: ActivatedRoute,
    private rewardService: RewardService,
    private userService : UserService
  ) { }

  ngOnInit(): void {
    this.fetchRewards();
  }
  
  fetchRewards(): void {
    this.rewardService.getRewards().subscribe(
      (data) => {
        console.log('Rewards data received:', data);
        this.rewards = data;
      },
      (error) => {
        console.error('Error fetching rewards', error);
      }
    );
  }

  purchaseReward(reward: Reward): void {

    const userId = localStorage.getItem('userId');
    if (userId) {
      this.rewardService.createPurchase(reward.id, parseInt(userId)).subscribe(
        (data) => {
          console.log(userId);
          console.log('Purchase successful', data);
          alert('Reward purchased successfully!');
          // Optionally, you might want to refresh the user points or reward list
        },
        (error) => {
          //console.error('Error purchasing reward', error);
          alert('Failed to purchase reward as User doesnot have enough Points!');
        }
      );
    } else {
      console.error('User ID not found in localStorage');
      alert('User ID not found. Please log in again.');
    }
  }
}
