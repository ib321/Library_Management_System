import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/Book';
@Injectable({
  providedIn: 'root',
})
export class BookService {
  private baseUrl = 'http://localhost:8098/';
  private endpoints = {
    bookByName: `${this.baseUrl}name/`,
    bookByAuthor: `${this.baseUrl}author/`,
    bookByCategory: `${this.baseUrl}category/`,
    allBooks: `${this.baseUrl}booksList`,
    addBook: `${this.baseUrl}addBook`,
    editBook: `${this.baseUrl}editBook`,
  };

  constructor(private http: HttpClient) {}

  public findByName(name: string): Observable<Book[]> {
    return this.http.get<Book[]>(this.endpoints.bookByName + name);
  }

  public findByAuthor(author: string): Observable<Book[]> {
    return this.http.get<Book[]>(this.endpoints.bookByAuthor + author);
  }

  public findByCategory(category: string): Observable<Book[]> {
    return this.http.get<Book[]>(this.endpoints.bookByCategory + category);
  }

  public findAllBook(): Observable<Book[]> {
    return this.http.get<Book[]>(this.endpoints.allBooks);
  }

  public addBook(book: Book): Observable<string> {
    return this.http.post<string>(this.endpoints.addBook, book);
  }

  public editBook(book: Book): Observable<string> {
    return this.http.post<string>(this.endpoints.editBook, book);
  }
}
