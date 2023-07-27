import { Component, OnInit } from '@angular/core';
import { LeaderboardService } from 'src/app/services/leaderboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  leader = [
    {
      rank : '',
      washerName : '',
      waterSavedInLiters : '',
      workingHrs : '',
    }
  ]

  constructor(private leaderboard:LeaderboardService) { }

  ngOnInit(): void {
    this.leaderboard.allLeaders().subscribe(
      (data:any)=>
      {
        this.leader = data;
        console.log(this.leader);
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error','Error loading Data!!!','error');
      });
  }

}
