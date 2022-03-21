import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-library-home',
  templateUrl: './library-home.component.html',
  styleUrls: ['./library-home.component.css']
})
export class LibraryHomeComponent implements OnInit {

  constructor(private router: Router)
 {

 }
 showAllBooks(){
    this.router.navigate(['allBooks']);
 }
 showBookByName(){
  this.router.navigate(['bookByName']);
}
 showBookByAuthor(){
  this.router.navigate(['bookByAuthor']);
}
showBookByCategory(){
  this.router.navigate(['bookByCategory']);
}

  ngOnInit(): void {
   
  }
  // ngOnInit(): void 
  // {
  //   this.stockService.getStocks().subscribe((x)=>{ this.stocks=x });
  // } 
// delStock(event: any, index: any) 
//   {  
//     let id=this.stocks[index].stockId;
    
//     this.stockService.delStock(id)  
//       .subscribe((data: any) => 
//       {  
//         console.log(data);  
//         this.ngOnInit();
//       });

//   }
}
