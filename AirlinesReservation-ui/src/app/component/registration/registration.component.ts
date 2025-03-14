import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit{
  
  hide = true;
  public registerForm!:FormGroup
  states: string[] =['Indian','Aus','others']

  constructor(private formBuilder: FormBuilder,

    ){}
  
  ngOnInit(){
    this.registerForm = this.formBuilder.group({
      username:['',Validators.min(4)],
      firstname:['',Validators.required],
      lastname:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.min(6)],
      age:['',Validators.required],
      mobile:['',Validators.min(11)],
      Address:['',Validators.required],
      dob:['',Validators.required],
      CountryCode:['',Validators.required]




    })

  }

  onformSubmit(){

  }

}
