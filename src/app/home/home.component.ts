
import { Component, OnInit } from '@angular/core';
import { User } from 'src/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser: User | undefined;
  userProfilePicUrl = 'https://example.com/path-to-your-image.jpg'; // Update with a real URL or local asset path

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.fetchUserDetails();
  }

  fetchUserDetails(): void {
    const userId = this.userService.getCurrentUserId();  // Get the current user ID from UserService
    this.userService.getUserDetails(userId).subscribe({
      next: (user: User) => {
        this.currentUser = user;  // Store user details for display
        // this.currentUser = JSON.parse(JSON.stringify(data));
        console.log('User details fetched successfully:', user);
        console.log(user.current_points);
      },
      error: (error) => {
        console.error('Error fetching user details:', error);
      }
    });
  }
  redirectToCatalog(): void {
    this.router.navigate(['/rewards']);
  }
}
