import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8081'; // Adjust based on your backend URL

  constructor(private http: HttpClient) { }

  login(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, data);
  }

  signup(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, data);
  }

  getUserById(id: number): Observable<User>{
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }
  
  getUserDetails(userId: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/user/${userId}`); 
  }

  setCurrentUser(userId: number): void {
    if (userId !== undefined && userId !== null) {
      localStorage.setItem('userId', userId.toString());
    }
  }

  getCurrentUserId(): number {
    const userId = localStorage.getItem('userId');
    if (userId) {
      return +userId;
    } else {
      throw new Error('User ID not found in local storage');
    }
  }

  getUserReport(userId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/report/${userId}`);
  }
  
}