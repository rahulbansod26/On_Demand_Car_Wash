import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { loginData } from '../model/Login';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<Boolean>();

  constructor(private http: HttpClient) { }

  public getCurrentUser(){
    return this.http.get(`${baseUrl}/customer/current-user`);
  }

  public generateToken(login: loginData){

   return this.http.post(`${baseUrl}/customer/authenticate`,login);
  
  }

  public loginUser(token: any){
    localStorage.setItem("token",token);
    // this.loginStatusSubject.next(true);
    return true;
  }

  public isLoggedIn(){
    let tokenStr = localStorage.getItem('token');
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
      return false;
    }
    else{
      return true;
    }
  }

  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('customer');
    return true;
  }

  public getToken(){
    return localStorage.getItem("token");
  }

  public setUser(customer:any){
    localStorage.setItem('customer',JSON.stringify(customer));
  }

  public getUser(){
    let userStr = localStorage.getItem("customer");
    if(userStr!=null)
    {
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  }

  public getUserRole(){
    let customer = this.getUser()
    return customer.authorities[0].authority;
  }


}
