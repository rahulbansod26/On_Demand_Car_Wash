import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  

  constructor(private http: HttpClient) { }

  // Add Customer

  // public addCustomer(customer: any){
  //     return this.http.post(`${baseUrl}/customer/addCustomer`,customer)
  // }

  addCustomer(customer:any){
    return this.http.post<any>(`${baseUrl}/customer/addCustomer`,customer).pipe(map((res:any)=>{
      return res;
    }))
  }

  // get all customers
  public getAllCustomers() {
    return this.http.get(`${baseUrl}/customer/get-customer-role/Customer`);
  }

  public getAllCustomers1() {
    return this.http.get(`${baseUrl}/customer/get-customer-role/Washer`);
  }
}
