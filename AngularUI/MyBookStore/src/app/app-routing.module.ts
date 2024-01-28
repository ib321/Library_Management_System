import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OutputBookComponent } from './output-book/output-book.component';
import { LibraryHomeComponent } from './library-home/library-home.component';
import { AddBookComponent } from './add-book/add-book.component';

const routes: Routes = [
  { path: 'bookByName/:bookname/:searchtype', component: OutputBookComponent },
  { path: 'bookByAuthor/:author/:searchtype', component: OutputBookComponent },
  { path: 'bookByCategory/:category/:searchtype', component: OutputBookComponent },

  { path: '', pathMatch: 'full', redirectTo: '/libraryhome' },
  { path: 'allBooks/:searchtype', component: OutputBookComponent },
  { path: 'libraryhome', component: LibraryHomeComponent },
  { path: 'editBook/:book/:action', component: AddBookComponent },
  { path: 'addBook', component: AddBookComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
