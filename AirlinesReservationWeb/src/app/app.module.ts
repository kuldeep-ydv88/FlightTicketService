import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './component/home/home.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { AboutComponent } from './component/about/about.component';
import { SearchFlightComponent } from './component/search-flight/search-flight.component';
import { RegistrationComponent } from './component/registration/registration.component';
import { FeedbackComponent } from './component/feedback/feedback.component';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { NavbarComponent } from './component/navbar/navbar.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatRadioModule} from '@angular/material/radio';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {CustomerLoginComponent } from './component/customer-login/customer-login.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { LoaderComponent } from './shared/loader/loader.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    SearchFlightComponent,
    RegistrationComponent,
    FeedbackComponent,
    NavbarComponent,
    CustomerLoginComponent,
    LoaderComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDividerModule,
    MatRadioModule,
    MatAutocompleteModule,
    MatSidenavModule,
    MatListModule,
    MatMenuModule,
    FormsModule,
    ReactiveFormsModule,
    NgxSpinnerModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
