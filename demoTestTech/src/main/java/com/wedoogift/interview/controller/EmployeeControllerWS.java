package com.wedoogift.interview.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedoogift.interview.model.Employee;
import com.wedoogift.interview.repository.IEmployeeRepository;
import com.wedoogift.interview.service.EmployeeService;
 
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeControllerWS {

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String name) {
		try {
			List<Employee> employees = new ArrayList<Employee>();

			if (name == null)
				employeeRepository.findAll().forEach(employees::add);
			else
				employeeRepository.findByNameContaining(name).forEach(employees::add);

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			if(!employeeService.employeeExistedMail(employee.getMail()) )
			{
			Employee _employee = employeeRepository
					.save(new Employee(  employee.getName(), employee.getMail()));
			return new ResponseEntity<>(_employee, HttpStatus.CREATED);
			}
			else
				return new ResponseEntity<>(null, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 

	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteAllEmployee() {
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
 
}
