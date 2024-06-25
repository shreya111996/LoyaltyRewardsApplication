import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  loading = false;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private AuthService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      name: ['', Validators.required],
      contactNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.signupForm.valid) {
      this.loading = true;
      const { name, contactNumber, email, password } = this.signupForm.value;
      this.AuthService.signup(name, contactNumber, email, password).subscribe(
        response => {
          this.loading = false;
          // Handle successful signup
          console.log('Signup successful', response);
          // Navigate to a different page or show a success message
          this.router.navigate(['/login']);
        },
        error => {
          this.loading = false;
          this.errorMessage = 'Signup failed. Please try again.';
          console.error('Signup error', error);
          // Handle signup error
        }
      );
    }
  }
}
