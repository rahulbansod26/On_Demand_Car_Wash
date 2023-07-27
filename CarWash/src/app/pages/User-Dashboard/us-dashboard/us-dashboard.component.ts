import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-us-dashboard',
  templateUrl: './us-dashboard.component.html',
  styleUrls: ['./us-dashboard.component.css']
})
export class UsDashboardComponent implements OnInit {

  sideBarOpen = true;
  constructor() { }

  ngOnInit(): void {
  }

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

}
