package com.weblearner.springboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weblearner.springboot.model.Enrollment;

@Repository
public interface EnrollmentRepositry extends CrudRepository<Enrollment, Integer> {

}
