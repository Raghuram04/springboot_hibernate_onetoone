package com.weblearner.springboot;

import org.springframework.data.repository.CrudRepository;

import com.weblearner.springboot.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
