import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CardetailsService {

  constructor(private http:HttpClient) { }

   //Add
   public addCarDetails(carDetails:any){
    return this.http.post(`${baseUrl}/customer/car-details`,carDetails);
  }
}
