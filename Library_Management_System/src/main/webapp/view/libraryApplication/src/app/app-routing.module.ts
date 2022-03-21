import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OutputBookComponent } from './output-book/output-book.component';
import { LibraryHomeComponent } from './library-home/library-home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
const routes: Routes = [
  {path:'allBooks', component: OutputBookComponent},
  {path:'bookByName', component: OutputBookComponent},
  {path:'bookByAuthor', component: OutputBookComponent},
  {path:'bookByCategory', component: OutputBookComponent},
  {path:'libraryhome', component: LibraryHomeComponent},
  {path:'userRegistration', component: UserRegistrationComponent},
  {path:'userLogin', component: UserLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
