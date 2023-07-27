import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CardetailsService } from 'src/app/services/cardetails.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  addCarDetails = {
    carName : '',
    carNo : '',
    carModel : '',
    ownerName : '',
  };

  constructor(private snack:MatSnackBar,private cardetails:CardetailsService) { }

  ngOnInit(): void {
  }

  addDetails(){
    if(this.addCarDetails.carName.trim() == '' || this.addCarDetails.carName == null){
      this.snack.open("Name is required !!",'',{
        duration: 3000,
      });
      return;
    }

    this.cardetails.addCarDetails(this.addCarDetails).subscribe(
      (data)=>{
        Swal.fire('Success','Car-Details Added!!','success');
        this.addCarDetails = {
          carName : '',
          carNo : '',
          carModel : '',
          ownerName : '',
        }
      },
      (error)=>{
        Swal.fire('Error!!','Error while adding washpack','error')
      });
  }
}
