import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { DashboardHomeComponent } from './dashboard-home/dashboard-home.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { MyBookingComponent } from './my-booking/my-booking.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  {path:'',component:DashboardHomeComponent,children:[
    {path:'profile',component:ProfileComponent},
    {path:'change-password',component:ChangePasswordComponent},
    {path:'myBooking',component:MyBookingComponent},
    {path:'main-page',component:MainComponent}

  ]},
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
