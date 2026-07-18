import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../model/Book';
import { BookService } from '../service/book.service';
import * as CryptoJS from 'crypto-js';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
})
export class AddBookComponent implements OnInit {
  currentdate: Date = new Date();
  book: Book;
  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.book = new Book(0, '', '', '', this.currentdate);
  }
  showstatus: boolean = true;
  ngOnInit(): void {
    this.route.params.subscribe((parameters) => {
      if (String(parameters['action']).localeCompare('edit') == 0) {
        this.book = JSON.parse(parameters['book']);
        this.showstatus = false;
      }
    });
  }
  errorstatus: boolean = false;
  addstatus: boolean = false;
  onSubmit(book: Book) {
    if (
      book.id == 0 ||
      book.name == null ||
      book.author == null ||
      book.category == null
    ) {
      this.errorstatus = true;
    } else {
      this.bookService.addBook(book).subscribe((data) => {
        this.addstatus = true;
      });
    }
  }

  onEdit(book: Book) {
    if (book.name == null || book.author == null || book.category == null) {
      this.errorstatus = true;
    } else {
      console.log(book.author);
      this.bookService.editBook(book).subscribe((data) => {});
    }
  }
}
