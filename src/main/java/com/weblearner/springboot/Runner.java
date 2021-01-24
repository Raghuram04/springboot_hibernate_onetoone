package com.weblearner.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weblearner.springboot.model.Department;
import com.weblearner.springboot.model.Employee;

@SpringBootApplication
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private DepartmentRepository departmentRepo;

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Department dept = new Department();
		dept.setDeptname("CIVIL");

		Employee emp = new Employee("Sam","MALE",dept);
		
		employeeRepo.save(emp);

	}

}
