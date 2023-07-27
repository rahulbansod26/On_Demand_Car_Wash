import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { Location } from '@angular/common';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-unassign-orders',
  templateUrl: './unassign-orders.component.html',
  styleUrls: ['./unassign-orders.component.css']
})
export class UnassignOrdersComponent implements OnInit{
 OrderList:any;
  constructor(private service:OrderService, private  location:Location, private login:LoginService){}
  user : any;
  ngOnInit(): void {
    this.unAssignedOrders();
    this.login.getCurrentUser().subscribe(
      (user:any)=>{
        console.log(this.user);
        this.user = user;
      },
      (error)=>{
        alert("error");
      }
    )
  }
  unAssignedOrders()
    {
 this.service.getUnassigned().subscribe((data)=>{
  this.OrderList=data
 })
    }
    back(){
      this.location.back();
    }
    updateStatus(orderId:any)
  {
    this.service.AssignWasher(orderId).subscribe((data)=>{
      Swal.fire('Assign Order Successfully');
      this.unAssignedOrders();
    });
  }

  }

// }
// export class OrderComponent {
//   constructor(private http: HttpClient) {}

//   updateStatus(orderId: string) {
//     const apiUrl = `http://localhost:9003/order/assignwasher/${orderId}`;
//     const updatedStatus = 'assign';

//     this.http.put(apiUrl, { status: updatedStatus }).subscribe(
//       response => {
//         console.log('Status updated successfully:', response);
//         // Perform any additional actions if needed
//       },
//       error => {
//         console.error('Error updating status:', error);
//       }
//     );
//   }
// }
// export class UnassignOrdersComponent implements OnInit {
//   OrderList: any;

//   constructor(private service: OrderService, private location: Location) {}

//   ngOnInit(): void {
//     this.unAssignedOrders();
//   }

//   unAssignedOrders() {
//     this.service.getUnassigned().subscribe((data: any) => {
//       this.OrderList = data;
//     });
//   }

//   updateStatus(orderId: any) {
//     // const updatedStatus = 'assign';
//     // status = updatedStatus;
//     this.service.AssignWasher(orderId).subscribe(
//       (data) => {
//         console.log('Status updated successfully:');
//         // Perform any additional actions if needed
//       },
//       error => {
//         console.error('Error updating status:', error);
//       }

//     );
//   }
  // updateStatus(orderId:any)
  // {
  //   this.service.updateOrderStatus(orderId).subscribe((data)=>{
  //     window.alert('Updated Successfully');
  //   });
  // }
//   back() {
//     this.location.back();
//   }
// }
