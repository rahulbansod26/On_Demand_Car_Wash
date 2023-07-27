import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css']
})
export class AllOrdersComponent implements OnInit {

  allOrders = [{
    washName: '',
    carName: '',
    carNo: '',
    carModel: '',
    amount: '',
    customerName: '',
    email: '',

  }]

  constructor(private order: OrderService) { }

  ngOnInit(): void {

    this.order.getAllOrders().subscribe(
      (data: any) => {
        this.allOrders = data;
        console.log(this.allOrders);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !', 'Error in loading data!!', 'error');
      }
    );
  }

}


