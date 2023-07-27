import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2'
import { CustomerService } from 'src/app/services/customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private customerService: CustomerService,private _snackBar: MatSnackBar,private fb:FormBuilder) { }

  // registrationForm!: FormGroup;

  public customer = {
    username: '',
    password: '',
    name: '',
    email: '',
    phone: '',
    address: '',
  };

  ngOnInit(): void {
    // this.registrationForm = this.fb.group({
    //   username: ['',Validators.required,Validators.minLength(3)],
    //   password: [''],
    //   name: [''],
    //   email: [''],
    //   phone: [''],
    //   address: [''],
    // })
  }

  formSubmit() {
    console.log(this.customer);
    if(this.customer.username == '' || this.customer.username == null){
      // alert("UserName is required !!");
      this._snackBar.open("Username is required !! ",'',{
        duration:3000
      })
      return;
    }

    this.customerService.addCustomer(this.customer).subscribe(
      (data) => {
        console.log(data);
        Swal.fire('Success','Customer is Registered','success');
      },
      (error) => {
        console.log(error);
        this._snackBar.open("Something went Wrong!!!","",{
          duration:3000,
        }
        );
      }
    )

  }

  // get userNameFunction() { return this.registrationForm.get('userName')?.invalid 
  // && this.registrationForm.get('userName')?.touched; }

}
