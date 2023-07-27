import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { authInterceptorProviders } from './services/auth.interceptor';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { AdDashboardComponent } from './pages/Admin-Dashboard/ad-dashboard/ad-dashboard.component';
import { SidebarComponent } from './pages/Admin-Dashboard/sidebar/sidebar.component';
import { UsDashboardComponent } from './pages/User-Dashboard/us-dashboard/us-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { WelcomeComponent } from './pages/Admin-Dashboard/welcome/welcome.component';
import { WashpacksComponent } from './pages/Admin-Dashboard/washpacks/washpacks.component';
import { AddWashpacksComponent } from './pages/Admin-Dashboard/add-washpacks/add-washpacks.component';
import { UpdateWashpackComponent } from './pages/Admin-Dashboard/update-washpack/update-washpack.component';
import { UsSidebarComponent } from './pages/User-Dashboard/us-sidebar/us-sidebar.component';
import { UsWelcomeComponent } from './pages/User-Dashboard/us-welcome/us-welcome.component';
import { UsWashpackComponent } from './pages/User-Dashboard/us-washpack/us-washpack.component';
import { CarDetailsComponent } from './pages/User-Dashboard/car-details/car-details.component';
import { WasherDashboardComponent } from './pages/Washer/washer-dashboard/washer-dashboard.component';
import { WasherSidebarComponent } from './pages/Washer/washer-sidebar/washer-sidebar.component';
import { WasherWelcomeComponent } from './pages/Washer/washer-welcome/washer-welcome.component';
import { HeaderComponent } from './pages/Admin-Dashboard/header/header.component';
import { UsHeaderComponent } from './pages/User-Dashboard/us-header/us-header.component';
import { LeaderBoardComponent } from './pages/Admin-Dashboard/leader-board/leader-board.component';
import { AddLeaderboardComponent } from './pages/Admin-Dashboard/add-leaderboard/add-leaderboard.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import { UpdateLeaderboardComponent } from './pages/Admin-Dashboard/update-leaderboard/update-leaderboard.component';
import { CustomerDetailsComponent } from './pages/Admin-Dashboard/customer-details/customer-details.component';
import { WasherDetailsComponent } from './pages/Admin-Dashboard/washer-details/washer-details.component';
import { WasherHeaderComponent } from './pages/Washer/washer-header/washer-header.component';
import { LeaderboardComponent } from './pages/User-Dashboard/leaderboard/leaderboard.component';
import { OrderComponent } from './pages/User-Dashboard/order/order.component';
import { GetOrderComponent } from './pages/User-Dashboard/get-order/get-order.component';
import { AllOrdersComponent } from './pages/Admin-Dashboard/all-orders/all-orders.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { UsWashpackComponents } from './pages/Washer/us-washpacks/us-washpack.components';
import { UnassignOrdersComponent } from './pages/order/unassign-orders/unassign-orders.component';
import { PendingOrdersComponent } from './pages/order/pending-orders/pending-orders.component';
import { CompletedOrdersComponent } from './pages/order/completed-orders/completed-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    AdDashboardComponent,
    SidebarComponent,
    UsDashboardComponent,
    ProfileComponent,
    WelcomeComponent,
    WashpacksComponent,
    AddWashpacksComponent,
    UpdateWashpackComponent,
    UsSidebarComponent,
    UsWelcomeComponent,
    UsWashpackComponent,
    CarDetailsComponent,
    WasherDashboardComponent,
    WasherSidebarComponent,
    WasherWelcomeComponent,
    HeaderComponent,
    UsHeaderComponent,
    LeaderBoardComponent,
    AddLeaderboardComponent,
    UpdateLeaderboardComponent,
    CustomerDetailsComponent,
    WasherDetailsComponent,
    WasherHeaderComponent,
    LeaderboardComponent,
    OrderComponent,
    GetOrderComponent,
    AllOrdersComponent,
    PaymentComponent,
    UsWashpackComponents,
    UnassignOrdersComponent,
    PendingOrdersComponent,
    CompletedOrdersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    ReactiveFormsModule,
    MatTableModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
