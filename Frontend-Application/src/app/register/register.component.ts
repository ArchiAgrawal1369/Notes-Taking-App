import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import {NgForm} from '@angular/forms';
import { APIserviceService } from '../apiservice.service';
import{Router} from '@angular/router'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  msg='';
  user:User= new User();

  userRegister(){
    console.log(this.user)
    this.service.registerUser(this.user).subscribe(data=>{
      sessionStorage.setItem('userSession',JSON.stringify(data))
      sessionStorage.setItem('isLoggedIn','true');
      this.router.navigate([`viewAll/${this.user.emailId}`])
    },error=>{this.msg="User already exists"});
  }

  constructor(private service:APIserviceService, private router:Router) { }

  ngOnInit() {
  }

}
