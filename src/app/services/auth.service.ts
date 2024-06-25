import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reward as RewardModel } from '../model/reward.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) {}

  signup(name: string, contactNumber: string, email: string, password: string): Observable<any> {
    const signupData = { name, contactNumber, email, password };
    return this.http.post(`${this.baseUrl}/user/signup`, signupData);
  }

  login(email: string, password: string): Observable<any> {
    const loginData = { email, password };
    return this.http.post(`${this.baseUrl}/user/login`, loginData);
  }

  getRewards(): Observable<Reward[]> {
    return this.http.get<Reward[]>(`${this.baseUrl}/reward`);
  }
}
// Define LoginResponse interface
export interface LoginResponse {
  message: string;
  rewards: Reward[];
}

// Define Reward interface
export interface Reward {
  category: string;
  name: string;
  description: string;
  points: number;
}