import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { OrderService } from 'src/app/services/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-get-order',
  templateUrl: './get-order.component.html',
  styleUrls: ['./get-order.component.css']
})
export class GetOrderComponent implements OnInit {

  // customer: any = null;

  order = [{
    orderId: '' ,
    washName : '',
    carName : '',
    carNo : '',
    carModel : '',
    amount : '',
    customerName : '',
    date : '',
    email: '',
    status:'',
  }]

  constructor(private orderService:OrderService,private login:LoginService) { }

  ngOnInit(): void {

    // this.customer = this.login.getCurrentUser();
    this.orderService.getAllOrdersByCustomerName().subscribe(
      (data : any) => {
        this.order = data;
        console.log(this.order);
      }, (error : any) => {
        console.log("error");
        Swal.fire('Error!', "Error in loading data!", "error");
      }
    )

  }

}
