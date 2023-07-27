import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';
import {loginData} from 'src/app/model/Login';
import { Router } from '@angular/router';
import { FormGroup, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm! : FormGroup;

    // username : String = '';
    // password : String = '';

  logindata : loginData = new loginData();

  constructor(private snack: MatSnackBar,private login:LoginService,private router:Router,private form:FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.form.group({
      username : ['',Validators.required,Validators.minLength(3)],
      password : [''],
    })
  }

  formSubmit(){

    if(this.logindata.username.trim()=='' || this.logindata.username==null)
    {
      this.snack.open("Username is required !!!","",{
        duration:3000,
      });
      return;
    }

    if(this.logindata.password.trim()=='' || this.logindata.password==null)
    {
      this.snack.open("Password is required !!!","",{
        duration:3000,
      });
      return;
    }

    this.login.generateToken(this.logindata).subscribe(
      (data:any)=>{
        console.log("success");
        console.log(data);

        //Login
        this.login.loginUser(data.token);

        //CurrentUser
        this.login.getCurrentUser().subscribe(
          (user:any) => {
            this.login.setUser(user);
            console.log(user);

            //redirect to Admin : Admin-Dashboard 
            //redirect to Cutsomer : User-Dashboard

            if(this.login.getUserRole()=="Admin")
            {
              // window.location.href = '/admin'
              this.router.navigate(['admin'])
            }
            else if(this.login.getUserRole()=="Customer")
            {
              // window.location.href = '/user'
              this.router.navigate(['user'])
              this.login.loginStatusSubject.next(true);
            }
            else if(this.login.getUserRole()=="Washer")
            {
              // window.location.href = '/washer'
              this.router.navigate(['washer'])
              this.login.loginStatusSubject.next(true);
            }
            else{
              this.login.logout();
            }
          } 
        )

      },
      (error)=>{
        console.log("error");
        console.log(error);
        this.snack.open("Invalid Credentials !! Try Again",'',{
          duration: 3000
        })
      }
    )

  }
}
