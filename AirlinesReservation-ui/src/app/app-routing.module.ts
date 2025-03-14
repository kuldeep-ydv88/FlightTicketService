import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { SearchFlightComponent } from './component/search-flight/search-flight.component';
import { RegistrationComponent } from './component/registration/registration.component';
import { AboutComponent } from './component/about/about.component';
import { CustomerLoginComponent } from './component/customer-login/customer-login.component'
import { FeedbackComponent } from './component/feedback/feedback.component';
import { ContactUsPageComponent } from './component/contact-us-page/contact-us-page.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'search-flight',component:SearchFlightComponent},
  {path:'Registration',component:RegistrationComponent},
  {path:'about',component:AboutComponent},
  {path:'cutomer-login',component:CustomerLoginComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'contact-us',component:ContactUsPageComponent},
  {
    path: 'dashboard',
    loadChildren: () => import('./module/dashboard/dashboard.module')
      .then(m => m.DashboardModule )
  },
  {
    path: 'payment',
    loadChildren: () => import('./module/payment/payment.module')
      .then(m => m.PaymentModule )
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
