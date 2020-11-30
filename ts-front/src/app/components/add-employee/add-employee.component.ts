import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddemployeeComponent implements OnInit {
  employee = {
    name: '',
    mail: '' 
    
  };
  submitted = false;

  constructor(private employeeService: EmployeeService ,  private router: Router) { }

  ngOnInit(): void {
  }

  saveemployee(): void {
    const data = {
      name: this.employee.name,
      mail: this.employee.mail
    };

    this.employeeService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
          this.router.navigate(['/employees']);
        },
        error => {
          console.log(error);
          this.router.navigate(['/employees']);
        });
  }

  newemployee(): void {
    this.submitted = false;
    this.employee = {
      name: '',
      mail: '' 
    
    };
  }

}
