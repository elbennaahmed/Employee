package com.wedoogift.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedoogift.interview.model.Employee;
import com.wedoogift.interview.repository.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	public boolean employeeExistedMail(String mail) {
		boolean existed = false;
		if (mail != null) {
			List<Employee> employees = employeeRepository.findAll();
			Employee emp = employees
			        .stream()
			        .filter(x -> x.getMail().equals(mail))
			        .findFirst()
			        .orElse(null);
			if (emp!=null) return true;

		}

		return false;
	}
}
