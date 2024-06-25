import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;

  constructor(
    private fb: FormBuilder,
    private AuthService: AuthService,
    private userService: UserService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  ngOnInit(): void { }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.loading = true;
      this.AuthService.login(email, password).subscribe(
        response => {
          this.loading = false;
          this.snackBar.open('Login successful!', 'Close', { duration: 2000 });
          console.log(response);
          this.userService.setCurrentUser(response.message); //response.message contains user_id
          this.router.navigateByUrl('dashboard');
        },
        error => {
          this.loading = false;
          this.snackBar.open('Login failed. Please try again.', 'Close', { duration: 2000 });
        }
      );
    }
  }
}
