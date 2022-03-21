import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs-compat/Observable';
import { Book } from '../model/Book';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private AllBooksUrl: string;
  private BookByNameUrl: string;
  private BookByAuthorUrl: string;
  private BookByCategUrl: string;
  AllUserList: string;
  validateUserUrl: string;

  constructor(private http: HttpClient) { 
    this.AllUserList='http://localhost:8098/allUserList';
    this.validateUserUrl='http://localhost:8098/validateUser';
    this.AllBooksUrl = 'http://localhost:8098/list';
    this.BookByNameUrl='http://localhost:8098/name/';
    this.BookByAuthorUrl='http://localhost:8098/author/';
    this.BookByCategUrl='http://localhost:8098/list/category/';
    
  }
  public getAllUser(): Observable<User[]>{
    return this.http.get<User[]>(this.AllUserList);
  }
  public findAllBook(): Observable<Book[]>{
    return this.http.get<Book[]>(this.AllBooksUrl);
  }
  
  public findByName( name:string): Observable<Book[]>{
    return this.http.get<Book[]>(this.BookByNameUrl+name);
  }
  public findByAuthor( author:string): Observable<Book[]>{
    return this.http.get<Book[]>(this.BookByAuthorUrl+author);
  }
   public findByCategory( category:string): Observable<Book[]>{
    return this.http.get<Book[]>(this.BookByCategUrl+category);
  }
 // public validateUser(userName:string,password:string):Observable{
  //return this.http.get<User[]>(this.AllUserList); }
}
