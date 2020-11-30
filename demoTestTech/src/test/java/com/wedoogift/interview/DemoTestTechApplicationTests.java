package com.wedoogift.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wedoogift.interview.model.Employee;
import com.wedoogift.interview.repository.IEmployeeRepository;
import com.wedoogift.interview.service.EmployeeService;

@SpringBootTest
class DemoTestTechApplicationTests {

	@Test
	void contextLoads() {
	}

	EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Test
	public void verifUserMail()
	{
		assertEquals(false, employeeService.employeeExistedMail ("ded"));
	//	employeeRepository.save(new Employee(1,"ded","ded@")) ;
	//	assertEquals(true, employeeService.employeeExistedMail ("ded@"));
		
	}
}
