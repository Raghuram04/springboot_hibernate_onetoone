package com.weblearner.springboot;

import org.springframework.data.repository.CrudRepository;

import com.weblearner.springboot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
