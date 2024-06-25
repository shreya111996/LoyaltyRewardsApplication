import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reward } from '../model/reward.model';
import { RewardPurchase } from '../model/reward-purchase.model';

@Injectable({
  providedIn: 'root'
})
export class RewardService {
  private apiUrl = 'http://localhost:8081/reward';
  private purchaseUrl = 'http://localhost:8081/rewardpurchase';

  constructor(private http: HttpClient) { }

  getRewards(): Observable<Reward[]> {
    return this.http.get<Reward[]>(this.apiUrl);
  }
  // createPurchase(): Observable<any> {
  //   return this.http.post<any>(this.purchaseUrl, rewardPurchase);
  // }

  createPurchase(rewardId: number, userId: number): Observable<any> {
    const payload = { rewardId, userId };
    return this.http.post<any>(this.purchaseUrl, payload);
  }

}