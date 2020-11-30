import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddemployeeComponent } from './components/add-employee/add-employee.component';
import { employeeDetailsComponent } from './components/employee-details/employee-details.component';
import { employeesListComponent } from './components/employees-list/employees-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddemployeeComponent,
    employeeDetailsComponent,
    employeesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
