import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { OutputBookComponent } from './output-book/output-book.component';
import { BookService } from './service/book.service';
import { LibraryHomeComponent } from './library-home/library-home.component';
import { AddBookComponent } from './add-book/add-book.component';
@NgModule({
  declarations: [
    AppComponent,
    OutputBookComponent,
    LibraryHomeComponent,
    AddBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
