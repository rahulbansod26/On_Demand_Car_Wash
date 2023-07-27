import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-us-header',
  templateUrl: './us-header.component.html',
  styleUrls: ['./us-header.component.css']
})
export class UsHeaderComponent implements OnInit {

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
