import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WashpackService {

  url = "http://localhost:9001";

  constructor(private http:HttpClient) { }

  //getAll
  public washpacks(){
    return this.http.get(`http://localhost:9001/admin/get-all`);
  }

  //Add
  public addWashpack(pack:any){
    return this.http.post(`http://localhost:9001/admin/add-pack`,pack);
  }

  //Delete
  public deleteWashpack(id:any){
    return this.http.delete(`http://localhost:9001/admin/${id}`);
  }

  //getById
  public getWashpack(id:any){
      return this.http.get(`http://localhost:9001/admin/${id}`);
  }

  //Update
  public updateWashpack(wash:any){
    return this.http.put(`http://localhost:9001/admin/update-pack`,wash);
  }

}
