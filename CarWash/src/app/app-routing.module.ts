import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdDashboardComponent } from './pages/Admin-Dashboard/ad-dashboard/ad-dashboard.component';
import { AddLeaderboardComponent } from './pages/Admin-Dashboard/add-leaderboard/add-leaderboard.component';
import { AddWashpacksComponent } from './pages/Admin-Dashboard/add-washpacks/add-washpacks.component';
import { AllOrdersComponent } from './pages/Admin-Dashboard/all-orders/all-orders.component';
import { CustomerDetailsComponent } from './pages/Admin-Dashboard/customer-details/customer-details.component';
import { LeaderBoardComponent } from './pages/Admin-Dashboard/leader-board/leader-board.component';
import { UpdateLeaderboardComponent } from './pages/Admin-Dashboard/update-leaderboard/update-leaderboard.component';
import { UpdateWashpackComponent } from './pages/Admin-Dashboard/update-washpack/update-washpack.component';
import { WasherDetailsComponent } from './pages/Admin-Dashboard/washer-details/washer-details.component';
import { WashpacksComponent } from './pages/Admin-Dashboard/washpacks/washpacks.component';
import { WelcomeComponent } from './pages/Admin-Dashboard/welcome/welcome.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CarDetailsComponent } from './pages/User-Dashboard/car-details/car-details.component';
import { GetOrderComponent } from './pages/User-Dashboard/get-order/get-order.component';
import { LeaderboardComponent } from './pages/User-Dashboard/leaderboard/leaderboard.component';
import { OrderComponent } from './pages/User-Dashboard/order/order.component';
import { UsDashboardComponent } from './pages/User-Dashboard/us-dashboard/us-dashboard.component';
import { UsWashpackComponent } from './pages/User-Dashboard/us-washpack/us-washpack.component';
import { UsWelcomeComponent } from './pages/User-Dashboard/us-welcome/us-welcome.component';
import { WasherDashboardComponent } from './pages/Washer/washer-dashboard/washer-dashboard.component';
import { WasherWelcomeComponent } from './pages/Washer/washer-welcome/washer-welcome.component';
import { UsWashpackComponents } from './pages/Washer/us-washpacks/us-washpack.components';
import { AdminGuard } from './services/admin.guard';
import { CustomerGuard } from './services/customer.guard';
import { WasherGuard } from './services/washer.guard';
import { UnassignOrdersComponent } from './pages/order/unassign-orders/unassign-orders.component';
import { PendingOrdersComponent } from './pages/order/pending-orders/pending-orders.component';
import { CompletedOrdersComponent } from './pages/order/completed-orders/completed-orders.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
  {
      path: 'admin',
      component: AdDashboardComponent,
      canActivate: [AdminGuard],
      children: [
        {
          path: '',
          component: WelcomeComponent,
        },
        {
          path: 'profile',
          component: ProfileComponent,
        },
        {
          path: 'washpack',
          component: WashpacksComponent,
        },
        {
          path: 'addWashpack',
          component: AddWashpacksComponent
        },
        {
          path: 'washpack-update/:id',
          component: UpdateWashpackComponent,
        },
        {
          path: 'leaderboard',
          component: LeaderBoardComponent
        },
        {
          path: 'addleader',
          component: AddLeaderboardComponent
        },
        {
          path: 'updateLeaderboard/:rank',
          component: UpdateLeaderboardComponent
        },
        {
          path: 'customer',
          component: CustomerDetailsComponent
        },
        {
          path: 'washer',
          component: WasherDetailsComponent
        },
        {
          path: 'orders',
          component: CompletedOrdersComponent
        }
      ]
    },
    {
      path: 'user',
      component: UsDashboardComponent,
      canActivate: [CustomerGuard],
      children: [
        {
          path: '',
          component: UsWelcomeComponent,
        },
        {
          path: 'washpack',
          component: UsWashpackComponent
        },
        {
          path: 'cardetails',
          component: CarDetailsComponent
        },
        {
          path: 'profile',
          component: ProfileComponent
        },
        {
          path: 'leaderboard',
          component: LeaderboardComponent
        },
        {
          path: 'order/:id',
          component: OrderComponent
        },
        {
          path: 'payment',
          component: PaymentComponent
        },
        {
          path: 'getOrders',
          component: GetOrderComponent
        },
        {
          path: 'leaderboard',
          component: LeaderBoardComponent
        }

      ]
    },
    {
      path: 'washer',
      component: WasherDashboardComponent,
      canActivate: [WasherGuard],
      children: [
        {
          path: '',
          component: WasherWelcomeComponent
        },
        {
          path: 'profile',
          component: ProfileComponent
        },
        {
          path: 'washpack',
          component: UsWashpackComponents
        },
        {
          path: 'Pendingorders',
          component: UnassignOrdersComponent
        },
        {
          path: 'Assignorders',
          component: PendingOrdersComponent
        },
        {
          path: 'WasherLeaderboard',
          component: LeaderboardComponent
        }
      ]

    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
