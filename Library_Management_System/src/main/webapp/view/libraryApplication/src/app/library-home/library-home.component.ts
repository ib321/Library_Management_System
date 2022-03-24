import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {Book} from '../model/Book';

@Component({
  selector: 'app-library-home',
  templateUrl: './library-home.component.html',
  styleUrls: ['./library-home.component.css']
})
export class LibraryHomeComponent implements OnInit {

  currentdate: Date = new Date(); 
  book: Book;

  searchtype:string = '';

  constructor(private router: Router) {
    this.book = new Book(0,'','','',this.currentdate);
  }
  public formData: any = {};

  showAllBooks() {
    let all: string = "all";
    this.router.navigate([`allBooks/${all}`]);
    this.router.navigate(['allBooks']);
  }
  namestatus: boolean = false;
  booknamestatus() {
    this.namestatus = true;
    this.authorstatus=false;
    this.catstatus=false;
  }

  showBookByName(formdata: NgForm) {
    this.formData = formdata.value;
    console.log(this.formData.name);
    this.searchtype = 'byname';
    this.router.navigate([`bookByName/${this.book.name}/${this.searchtype}`]);
  }
  authorstatus: boolean = false;
  bookauthorstatus() {
    this.authorstatus = true; 
     this.catstatus=false; 
       this.namestatus = false;
  }
  public formData2: any = {};

  showBookByAuthor(formData2: NgForm) {
    this.formData = formData2.value;
    console.log(this.formData.author);
    this.searchtype = 'byauthor';
    this.router.navigate([`bookByAuthor/${this.book.author}/${this.searchtype}`]);

  }

  catstatus: boolean = false;
  bookcatstatus() {
    this.catstatus = true;
    this.namestatus = false;
    this.authorstatus=false;
  }

  public formData3: any = {};

  showBookByCategory(formData3: NgForm) {
    this.formData = formData3.value;
    console.log(this.formData.category);
    this.searchtype = 'bycategory';
    this.router.navigate([`bookByCategory/${this.book.category}/${this.searchtype}`]);
  }
  ngOnInit(): void {

  }

}
