package com.weblearner.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblearner.springboot.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping("/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentDao.findById(id).get();

	}

	@RequestMapping("/new")
	public Student newStudent(@RequestBody Student student) {
		return studentDao.save(student);

	}

}
