import { Component, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-output-book',
  templateUrl: './output-book.component.html',
  styleUrls: ['./output-book.component.css']
})
export class OutputBookComponent implements OnInit {
  Books: Book[]=[];
  constructor(private bookService:BookService) { }
  
 
  ngOnInit(): void {
    this.bookService.findAllBook().subscribe(allbook=>this.Books=allbook);
  }
  
  public  checkAvailability( returnD:Date):String {
		 let d = new Date();
		 let returnDate=new Date(returnD);
		if (d < returnDate)
			return "Unavailable";
		else if (d > returnDate)
			return "Available";
		else if (d == returnDate)
			return "Unavailable";
		else
			return "Unavailable";
	
	}
};
