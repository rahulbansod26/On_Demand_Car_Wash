import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {

  constructor(private http:HttpClient) { }

  //Add
  public addToLeaderboard(leader:any){
    return this.http.post(`http://localhost:9001/admin/leaderboard`,leader);
  }

  //getAll
  public allLeaders(){
    return this.http.get(`http://localhost:9001/admin/get-leaderboard`);
  }

  //getById
  public getWasher(rank:any){
    return this.http.get(`http://localhost:9001/admin/getrank/${rank}`);
}

  //Update
  public updateLeader(leader:any){
    return this.http.put(`http://localhost:9001/admin/update-leaderboard`,leader);
  }

}
