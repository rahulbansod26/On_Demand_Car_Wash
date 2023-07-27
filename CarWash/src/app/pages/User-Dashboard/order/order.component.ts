import { Component, HostListener, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { OrderService } from 'src/app/services/order.service';
import { WashpackService } from 'src/app/services/washpack.service';
import Swal from 'sweetalert2';

declare var Razorpay: any;

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orderDetails = {
    washName : '',
    carName : '',
    carNo : '',
    carModel : '',
    amount : '',
    customerName : '',
    address : '',
    email: '',
  };

  Id = 0;
  wash : any;

  constructor(private snack:MatSnackBar,private order:OrderService,private _route:ActivatedRoute
    ,private route:Router,private washpack:WashpackService,private login:LoginService) { }

    user : any = null;
    
  ngOnInit(): void {

    // this.user = this.login.getUser;

    this.login.getCurrentUser().subscribe(
        (user:any)=>{
          this.user = user;
        },
        (error)=>{
          alert("error");
        }
      )

    this.Id = this._route.snapshot.params['id'];
    // alert(this.Id);
    this.washpack.getWashpack(this.Id).subscribe(
      (data:any)=>
      {
        this.wash = data;
        console.log(this.wash);
        this.orderDetails.washName = this.wash.packName;
        this.orderDetails.amount = this.wash.amount;
        this.orderDetails.customerName = this.user.username;
        this.orderDetails.address=this.user.address;
      },
      (error)=>
      {
        console.log(error);
      });
  }

  placeOrder(){
    if (this.orderDetails.washName == '' || this.orderDetails.washName == null) {
      this.snack.open("WashName is required !!",'',{
        duration: 3000,
      });
      return;
    }

    this.order.placeOrder(this.orderDetails).subscribe(
      (data)=>{
        Swal.fire('Success','Order Placed!!!','success').then((e)=>{
          this.route.navigate(['/admin/order'])
        })
        this. orderDetails = {
          washName : '',
          carName : '',
          carNo : '',
          carModel : '',
          amount : '',
          customerName : '',
          address : '',
          email: '',
        }    
      },
      (error)=>{
        Swal.fire('Error!!','Error while adding washpack','error')
      })

  }

  message:any = "Not yet stared";
  paymentId = "";
  error = "";
  title = 'angular-razorpay-intergration';
  options = {
    "key": "rzp_test_zku9AxbKVNYDUM",
    "amount": "100",
    "name": "Rahul bansod",
    "description": "Payment Gateway",
    "order_id": "",
    "handler": function (response: any) {
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      window.dispatchEvent(event);
    },
    "prefill": {
      "name": "",
      "email": "",
      "contact": ""
    },
    "notes": {
      "address": ""
    },
    "theme": {
      "color": "#3399cc"
    }
  };

  paynow() {
    this.paymentId = '';
    this.error = '';
    this.options.amount = "100"; 
    this.options.prefill.name = "Rahul";
    this.options.prefill.email = "bansod_rahul.cs@ghrce.raisoni.net";
    this.options.prefill.contact = "8805015925";
    var rzp1 = new Razorpay(this.options);
    rzp1.open();
    rzp1.on('payment.failed', function (response: any) {
      //this.message = "Payment Failed";
      // Todo - store this information in the server
      console.log(response.error.code);
      console.log(response.error.description);
      console.log(response.error.source);
      console.log(response.error.step);
      console.log(response.error.reason);
      console.log(response.error.metadata.order_id);
      console.log(response.error.metadata.payment_id);
      //this.error = response.error.reason;
    }
    );
  }
  @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: any): void {
    this.message = "Success Payment";
  }

}
