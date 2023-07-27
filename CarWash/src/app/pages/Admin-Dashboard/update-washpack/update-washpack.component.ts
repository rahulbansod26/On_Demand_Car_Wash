import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WashpackService } from 'src/app/services/washpack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-washpack',
  templateUrl: './update-washpack.component.html',
  styleUrls: ['./update-washpack.component.css']
})
export class UpdateWashpackComponent implements OnInit {

  constructor(private _route:ActivatedRoute,private washpack:WashpackService,private route:Router) { }

  Id = 0;
  wash:any;

  ngOnInit(): void {

    this.Id = this._route.snapshot.params['id'];
    // alert(this.Id);
    this.washpack.getWashpack(this.Id).subscribe(
      (data:any)=>
      {
        this.wash = data;
        console.log(this.wash);
      },
      (error)=>
      {
        console.log(error);
      });
  }

  //Update Form Submit

  public updateData(){

    this.washpack.updateWashpack(this.wash).subscribe(
      (data:any)=>{
        Swal.fire('Success','Update Sucessfull!!!','success').then((e)=>{
          this.route.navigate(['/admin/washpack'])
        });
      },
      (error)=>{
        Swal.fire('Error','Update Unsuccessfull!!!','error');
      }
    )
  }

}
