import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  current_points: number ;
  totalPointsRedeemed: number ;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.fetchReport();
  }

  fetchReport(): void {
    const userId = this.userService.getCurrentUserId();
    this.userService.getUserReport(userId).subscribe({
      next: (data) => {
        this.current_points = data.current_points;
        this.totalPointsRedeemed = data.totalPointsRedeemed;
      },
      error: (error) => {
        console.error('Error fetching report:', error);
      }
    });
  }
}
