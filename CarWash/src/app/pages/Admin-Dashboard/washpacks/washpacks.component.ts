import { Component, OnInit } from '@angular/core';
import { WashpackService } from 'src/app/services/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-washpacks',
  templateUrl: './washpacks.component.html',
  styleUrls: ['./washpacks.component.css']
})
export class WashpacksComponent implements OnInit {

  Washpacks = [
    {
      id : '' ,
      packName : '',
      amount : '' ,
      description : '',
    }
  ];


  constructor(private washpack:WashpackService) { }

  ngOnInit(): void {
    this.washpack.washpacks().subscribe(
      (data:any)=>{
        this.Washpacks = data;
        console.log(this.Washpacks);
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error !','Error in loading data!!','error');
      }
    );
  }

  //Delete Washpacks

  deleteWashpack(id:any)
  {

    Swal.fire({
      icon: 'warning',
      title: 'Want to delete?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result)=>{

      if(result.isConfirmed){

        this.washpack.deleteWashpack(id).subscribe(
      
          (data)=>{
            this.Washpacks = this.Washpacks.filter((washpack)=>washpack.id != id);
            Swal.fire('Success','Washpack Deleted','success');
          },
          (error)=>{
            Swal.fire('Error !','Error deleting washpack !!!','error');
          
          });

      }
    })

  }



}
