import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {
  private apiUrl = 'http://localhost:8081/api/purchase';

  constructor(private http: HttpClient) { }

  createPurchase(purchaseData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/create`, purchaseData, { responseType: 'text' }); 
  }
}
