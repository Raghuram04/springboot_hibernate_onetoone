package com.weblearner.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weblearner.springboot.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
