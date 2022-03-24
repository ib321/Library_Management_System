import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/User';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  title = "Library"
  status: boolean = false;
  error: boolean = false;
  users: User[] = [];
  name: string | undefined;

  public formData: any = {};

  constructor(private bookService: BookService, private router: Router, private route:ActivatedRoute) {

   }
   registrationStatus:boolean=false;
   regname:string='';
  ngOnInit(): void {
    this.bookService.getAllUser().subscribe(alluser => this.users = alluser);
    this.route.params.subscribe( (parameters)=>{
		
      if (String(parameters['confirm']).localeCompare('fromRegistration') == 0) {
        this.regname=String(parameters['name']);
        this.registrationStatus=true;
      }});
  }

  userLogin(formdata: NgForm) {
    this.formData = formdata.value;

    this.users.forEach(user => {
      if (user.userid == this.formData.username && user.password == this.formData.password) {
        this.status = true;
        this.name = user.first + " " + user.last;
      }

    });

    if (this.status == true) {
      this.router.navigate(['libraryhome']);
    }
    else {
      this.error = true;
    }
  }

}
