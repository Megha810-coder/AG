import { Component,OnInit,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import {ModalDirective} from 'ngx-bootstrap/modal';
import {HttpClient} from '@angular/common/http';
import { AuthenticationService } from '../../service/authentication.service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-dashboard',
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {
  username = ''
  password = ''
  invalidLogin = false

  constructor(private router:Router, private loginservice: AuthenticationService){}

  checkLogin(){
    // alert("Successfully Login";
    // this.router.navigate(['dashboard']);
    if (this.loginservice.authenticate(this.username, this.password))
     {
      this.router.navigate(['dashboard'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }
  
  
  ngOnInit()
  {

  }

  @ViewChild('infoModal') public infoModal: ModalDirective;
 }
