import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/User';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user : User;
  constructor(private route:ActivatedRoute,private router: Router,private bookService:BookService) {
    this.user= new User();
   }
   onSubmit() {
    this.bookService.registerUser(this.user).subscribe(data => {this.gotoLogInPage()});
  }
gotoLogInPage(){
  this.router.navigate(['/userLogin']);
}
  ngOnInit(): void {
  }

}
