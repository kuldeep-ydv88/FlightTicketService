import { Component,  OnInit } from '@angular/core';
import { FormBuilder, FormGroup,ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.scss']
})
export class CustomerLoginComponent implements OnInit{
  hide=true;
  loginForm!:FormGroup;
  inputText: string | undefined;

  constructor(
    private formBuilder:FormBuilder
  ){}

  ngOnInit() {
    this.loginForm =this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  onLogin(){
      
  }

  clearInput(){
    this.loginForm.reset();
  }

}
