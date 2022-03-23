import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/Book';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private BookByNameUrl: string;
  private BookByAuthorUrl: string;
  private BookByCategUrl: string;
  private AllUserList: string;
  private registerUserUrl:string;

  private AllBooksUrl: string;
  private validateUserUrl: string;

  constructor(private http: HttpClient) { 

    this.AllUserList='http://localhost:8098/allUserList';
    this.registerUserUrl='http://localhost:8098/registerUser';

    this.BookByNameUrl='http://localhost:8098/name/';
    this.BookByAuthorUrl='http://localhost:8098/author/';
    this.BookByCategUrl='http://localhost:8098/category/';

    this.AllBooksUrl = 'http://localhost:8098/list';
    this.validateUserUrl='http://localhost:8098/validateUser';
  }

  public getAllUser(): Observable<User[]>{
    return this.http.get<User[]>(this.AllUserList);
  }
 public registerUser(user: User) {
  return this.http.post<User>(this.registerUserUrl, user);
  }
  public findByName( name:string): Observable<Book[]>{
    console.log("intheservice");
    return this.http.get<Book[]>(this.BookByNameUrl+name);
  }
  public findByAuthor( author:string): Observable<Book[]>{
    return this.http.get<Book[]>(this.BookByAuthorUrl+author);
  }
   public findByCategory( category:string): Observable<Book[]>{
    return this.http.get<Book[]>(this.BookByCategUrl+category);
  }
   // public findAllBook(): Observable<Book[]>{
  //   return this.http.get<Book[]>(this.AllBooksUrl);
  // }
 // public validateUser(userName:string,password:string):Observable{
  //return this.http.get<User[]>(this.AllUserList); }
}
