import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { WashpackService } from 'src/app/services/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-washpacks',
  templateUrl: './add-washpacks.component.html',
  styleUrls: ['./add-washpacks.component.css']
})
export class AddWashpacksComponent implements OnInit {

  addWashpack = {
    id : '',
    packName : '',
    amount : '',
    description : '',
  }

  constructor(private snack:MatSnackBar,private washpack:WashpackService) { }

  ngOnInit(): void {
  }

  addWashpacks(){
    if (this.addWashpack.id == '' || this.addWashpack.id == null) {
      this.snack.open("Id is required !!",'',{
        duration: 3000,
      });
      return;
    }

    this.washpack.addWashpack(this.addWashpack).subscribe(
      (data)=>{
        Swal.fire('Success','Washpack Added!!!','success')
        this. addWashpack = {
          id : '',
          packName : '',
          amount : '',
          description : '',
        }    
      },
      (error)=>{
        Swal.fire('Error!!','Error while adding washpack','error')
      })

  }

}
