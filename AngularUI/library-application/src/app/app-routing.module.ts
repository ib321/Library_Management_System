import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { OutputBookComponent } from './output-book/output-book.component';
import { LibraryHomeComponent } from './library-home/library-home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AddBookComponent } from './add-book/add-book.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'userLogin' },
  { path: 'allBooks/:searchtype', component: OutputBookComponent },
  { path: 'bookByName/:bookname/:searchtype', component: OutputBookComponent },
  { path: 'bookByAuthor/:author/:searchtype', component: OutputBookComponent },
  {
    path: 'bookByCategory/:category/:searchtype',
    component: OutputBookComponent,
  },

  { path: 'libraryhome/:userName', component: LibraryHomeComponent },
  { path: 'libraryhome', component: LibraryHomeComponent },
  { path: 'userRegistration', component: UserRegistrationComponent },
  { path: 'userLogin', component: UserLoginComponent },
  { path: 'userLogin/:confirm/:name/:status', component: UserLoginComponent },
  { path: 'editBook/:book/:action', component: AddBookComponent },
  { path: 'addBook', component: AddBookComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
