import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../model/Book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-output-book',
  templateUrl: './output-book.component.html',
  styleUrls: ['./output-book.component.css']
})
export class OutputBookComponent implements OnInit {
  	
  constructor(private bookService:BookService,private route: ActivatedRoute) { }
   Books:Book[]=[];
 
  ngOnInit(): void {
	console.log("in the output");
	this.Books=[];
	this.route.params.subscribe( (parameters)=>{
		
		if (String(parameters['searchtype']).localeCompare('byname') == 0) {
			this.bookService.findByName(String(parameters['bookname'])).subscribe(allbook=>this.Books=allbook);
		
		} else if(String(parameters['searchtype']).localeCompare('byauthor') == 0){
			this.bookService.findByAuthor(parameters['author']).subscribe(allbook=>this.Books=allbook);
		
		} else if(String(parameters['searchtype']).localeCompare('bycategory') == 0){
			this.bookService.findByCategory(parameters['category']).subscribe(allbook=>this.Books=allbook);
		}
  });
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
}
