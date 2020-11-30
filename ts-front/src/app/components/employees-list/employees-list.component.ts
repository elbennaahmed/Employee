import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class employeesListComponent implements OnInit {

  employees: any;
  currentemployee = null;
  currentIndex = -1;
  name = '';

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.retrieveemployees();
  }

  retrieveemployees(): void {
    this.employeeService.getAll()
      .subscribe(
        data => {
          this.employees = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrieveemployees();
    this.currentemployee = null;
    this.currentIndex = -1;
  }

  setActiveemployee(employee, index): void {
    this.currentemployee = employee;
    this.currentIndex = index;
  }

 

  searchname(): void {
    this.employeeService.findByName(this.name)
      .subscribe(
        data => {
          this.employees = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
