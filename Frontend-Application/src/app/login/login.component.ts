import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { User } from '../user';
import { APIserviceService } from '../apiservice.service';
import{Router} from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User= new User();
  msg="";

  userLogin(){
    console.log(this.user)
    this.service.loginUser(this.user).subscribe(data=>{
      sessionStorage.setItem('isLoggedIn','true');
      console.warn(this.user.emailId);
      this.router.navigate([`viewAll/${this.user.emailId}`])
    },error=>{this.msg="Please enter correct credentials"});
  }
  constructor(private service:APIserviceService, private router:Router) { }

  ngOnInit() {
  }

}
