import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LeaderboardService } from 'src/app/services/leaderboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-leaderboard',
  templateUrl: './update-leaderboard.component.html',
  styleUrls: ['./update-leaderboard.component.css']
})
export class UpdateLeaderboardComponent implements OnInit {

  Rank = 0;
  leader : any; 


  constructor(private _route:ActivatedRoute,private leaderboard:LeaderboardService,private route:Router) { }

  ngOnInit(): void {
    this.Rank = this._route.snapshot.params['rank'];
    // alert(this.Rank);
    this.leaderboard.getWasher(this.Rank).subscribe(
      (data:any)=>
      {
        this.leader = data;
        console.log(this.leader);
      },
      (error)=>
      {
        console.log(error);
      });
  }

  public updateData(){

    this.leaderboard.updateLeader(this.leader).subscribe(
      (data:any)=>{
        Swal.fire('Success','Update Sucessfull!!!','success').then((e)=>{
          this.route.navigate(['/admin/leaderboard'])
        });
      },
      (error:any)=>{
        Swal.fire('Error','Update Unsuccessfull!!!','error');
      }
    )
  }

}
