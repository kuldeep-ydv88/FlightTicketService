import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-home',
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.scss']
})
export class DashboardHomeComponent implements OnInit{
  opened = false;

  constructor(private router:Router){}

  ngOnInit(){
    // this.router.navigate(['/dashboard/main-page'])

    
  }

  logOut(){
    this.router.navigate(['']);
  }

}
