import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-washer-details',
  templateUrl: './washer-details.component.html',
  styleUrls: ['./washer-details.component.css']
})
export class WasherDetailsComponent implements OnInit {

  washer = [
    {
      id: '',
      username: '',
      name: '',
      address: '',
      email: '',
      phone: ''
    }
  ]

  constructor(private customer:CustomerService) { }

  ngOnInit(): void {

    this.customer.getAllCustomers1().subscribe(
      (data: any) => {
        this.washer = data;
        console.log(this.washer);

      },
      (error) => {
        console.log("error");
        Swal.fire('Error!', "Error in loading data!", "error");

      }
    )
  }

}


