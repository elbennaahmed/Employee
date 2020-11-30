import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { employeesListComponent } from './components/employees-list/employees-list.component';
import { employeeDetailsComponent } from './components/employee-details/employee-details.component';
import { AddemployeeComponent } from './components/add-employee/add-employee.component';

const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees', component: employeesListComponent },
  { path: 'employees/:id', component: employeeDetailsComponent },
  { path: 'add', component: AddemployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
