import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

//'routes' is a type of 'Routes modelfrom angular/router package 
const routes: Routes = [

  {path: 'students', component:StudentListComponent},
  {path: 'create-student', component:CreateStudentComponent},
  {path: 'update-student/:id', component:UpdateStudentComponent},
  {path:'', redirectTo:'students', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }












/* Fist we create AppRoutingModule{}
It is annotaed with @NgModule decorator
Then within imports we specify RouterModule from angular/router package
RoutherModule has a method called forRoot, that method takes routes as an array
We have defined a constant routes array, inside Routes[] array, we configure each route   */