import { Component, HostListener, OnInit } from '@angular/core';
import { WashpackService } from 'src/app/services/washpack.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-us-washpacks',
  templateUrl: './us-washpack.components.html',
  styleUrls: ['./us-washpack.components.css']
})
export class UsWashpackComponents implements OnInit {

  Washpacks = [
    {
      id : 1 ,
      packName : "h",
      amount : 23 ,
      description : "hh",
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





}
