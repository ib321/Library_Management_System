import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../model/Book';
import { BookService } from '../service/book.service';
@Component({
  selector: 'app-library-home',
  templateUrl: './library-home.component.html',
  styleUrls: ['./library-home.component.css'],
})
export class LibraryHomeComponent implements OnInit {
  currentdate: Date = new Date();
  book: Book;

  searchtype: string = '';

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private bookService: BookService
  ) {
    this.book = new Book(0, '', '', '', this.currentdate);
  }

  addNewBook() {
    this.router.navigate(['addBook']);
  }

  showAllBooks() {
    this.searchtype = 'all';
    this.router.navigate([`allBooks/${this.searchtype}`]);
  }
  namestatus: boolean = false;
  booknamestatus() {
    this.namestatus = true;
    this.authorstatus = false;
    this.catstatus = false;
  }

  showBookByName() {
    this.searchtype = 'byname';
    this.router.navigate([`bookByName/${this.book.name}/${this.searchtype}`]);
  }
  authorstatus: boolean = false;
  bookauthorstatus() {
    this.authorstatus = true;
    this.catstatus = false;
    this.namestatus = false;
  }

  showBookByAuthor() {
    this.searchtype = 'byauthor';
    this.router.navigate([
      `bookByAuthor/${this.book.author}/${this.searchtype}`,
    ]);
  }

  catstatus: boolean = false;
  bookcatstatus() {
    this.catstatus = true;
    this.namestatus = false;
    this.authorstatus = false;
  }

  showBookByCategory() {
    this.searchtype = 'bycategory';
    this.router.navigate([
      `bookByCategory/${this.book.category}/${this.searchtype}`,
    ]);
  }
  username: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((parameters) => {
      this.username = String(parameters['userName']);
    });
  }
}
