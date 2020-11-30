package com.wedoogift.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wedoogift.interview.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
	 

	  List<Employee> findEmployeeByMail(String mail);
	  List<Employee> findByNameContaining(String name);
	}
