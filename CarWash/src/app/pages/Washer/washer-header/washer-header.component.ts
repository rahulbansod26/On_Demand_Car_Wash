import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-washer-header',
  templateUrl: './washer-header.component.html',
  styleUrls: ['./washer-header.component.css']
})
export class WasherHeaderComponent implements OnInit {

  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();
  isLoggedIn = false;
  user = null;

  constructor(public login: LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe(data => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
  }

  public logout() {
    this.login.logout();
    // this.isLoggedIn = false;
    // this.user = null;
    window.location.reload();
  }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }


}
