import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from './model/User';
import { BookService } from './service/book.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  status:boolean=false;
  users:User[]=[];
  name:string | undefined;
  public formData:any ={};

  constructor(private bookService:BookService,private router: Router){

  }
  
  ngOnInit():void{
    this.bookService.getAllUser().subscribe(alluser=>this.users=alluser);
  }

  userLogin(formdata:NgForm)
  {
    this.formData=formdata.value;
    this.users.forEach(user => {
    if(user.userid==this.formData.username&&user.password==this.formData.password)
    {
    this.status=true;
    this.name=user.first+" "+user.last;
    }
  });
    
    if(this.status==true)
    {
      this.router.navigate(['libraryhome']);
    }
  }

}
