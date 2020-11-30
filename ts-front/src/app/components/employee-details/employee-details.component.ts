import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class employeeDetailsComponent implements OnInit {
  currentemployee = null;
  message = '';

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getemployee(this.route.snapshot.paramMap.get('id'));
  }

  getemployee(id): void {
    this.employeeService.get(id)
      .subscribe(
        data => {
          this.currentemployee = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

 

 
}
