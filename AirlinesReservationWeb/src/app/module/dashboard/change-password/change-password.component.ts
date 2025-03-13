import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  changePasswordForm!:FormGroup

  constructor(private _fb:FormBuilder){}

  ngOnInit() {
    this.changePasswordForm = this._fb.group({
      oldPassword: ['', Validators.required],
      NewPassword: ['', Validators.required],
      ReEnterPassword: ['', Validators.required]
    })
    
  }

  Update(){
    
  }
  

}
