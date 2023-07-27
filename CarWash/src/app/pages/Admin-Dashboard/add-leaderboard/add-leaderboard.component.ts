import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaderboardService } from 'src/app/services/leaderboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-leaderboard',
  templateUrl: './add-leaderboard.component.html',
  styleUrls: ['./add-leaderboard.component.css']
})
export class AddLeaderboardComponent implements OnInit {

  addLeader = {
    rank: '',
    washerName: '',
    waterSavedInLiters: '',
    workingHrs: '',
  }

  constructor(private snack: MatSnackBar, private leader: LeaderboardService) { }

  ngOnInit(): void {
  }

  addToLeaderboard() {
    if (this.addLeader.washerName.trim() == '' || this.addLeader.washerName == null) {
      this.snack.open("WasherName is required !!", '', {
        duration: 3000,
      });
      return;
    }

    this.leader.addToLeaderboard(this.addLeader).subscribe(
      (data) => {
        Swal.fire('Success', 'Added to Leaderboard!!!', 'success')
        this.addLeader = {
          rank: '',
          washerName: '',
          waterSavedInLiters: '',
          workingHrs: '',
        }
      },
      (error) => {
        Swal.fire('Error!!', 'Error while adding washpack', 'error')
      })

  }
}
