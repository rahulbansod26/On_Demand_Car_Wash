import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = "http://localhost:9003/order";

  [x: string]: any;

  constructor(private _http:HttpClient) { }

  //For Placing Order Using Post Method
  placeOrder(data:any) : Observable<Object>{
    return this._http.post(`${this.baseUrl}/place-order`,data,{responseType: 'text'});
  }

  //For Getting All the orders from Database
  public getAllOrders(){
    return this._http.get(`${this.baseUrl}/get-all`);
  }

  //For Getting Orders only for a specific Customer
  public getAllOrdersByCustomerName() {
    return this._http.get(`http://localhost:9000/customer/my-orders/`);
  }

  getUnassigned(){
    return this._http.get('http://localhost:9003/order/findUnassigned');
  }
  // AssignWasher(order:any){
  //   return this._http.put(`http://localhost:9003/order/assignWasher/${order.orderId}`,order);
  // }
  AssignWasher(orderId:any){
    return this._http.put(`${this.baseUrl}/assignWasher/` + orderId,{
      headers: this['getHeaders']
    }
     );
  }
  getPendingOrders(){
    return this._http.get(`${this.baseUrl}/findPending`);
  }
  updateStatus(orderId:any){
    return this._http.put(`${this.baseUrl}/updateStatus/completed/` + orderId,{
      headers: this['getHeaders']
    }
     );
  }

  getComletedOrders()
  {
    return this._http.get(`${this.baseUrl}/findCompleted`);
  }
}
