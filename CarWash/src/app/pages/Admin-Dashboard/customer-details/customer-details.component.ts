import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  customer = [
    {
      id: '',
      username: '',
      name: '',
      address: '',
      email: '',
      phone: ''
    }
  ]

  constructor(private _customer: CustomerService) { }

  ngOnInit(): void {

    this._customer.getAllCustomers().subscribe(
      (data: any) => {
        this.customer = data;
        console.log(this.customer);

      },
      (error) => {
        console.log("error");
        Swal.fire('Error!', "Error in loading data!", "error");

      }
    )
  }

}

