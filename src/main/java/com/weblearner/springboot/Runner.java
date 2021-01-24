package com.weblearner.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weblearner.springboot.model.Enrollment;
import com.weblearner.springboot.model.Course;
import com.weblearner.springboot.EnrollmentRepositry;
import com.weblearner.springboot.CourseRepository;

@SpringBootApplication
public class Runner implements CommandLineRunner {

	@Autowired
	private EnrollmentRepositry enrollRepo;

	@Autowired
	private CourseRepository courseRepo;


	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Enrollment enr = new Enrollment();
		enr.setName("First Enrollment");

		Course course1 = new Course();
		course1.setCoursename("CSE");
		course1.setEnrollment(enr);

		Course course2 = new Course();
		course2.setCoursename("ECE");
		course2.setEnrollment(enr);

		List<Course> courseLst = new ArrayList<Course>();
		courseLst.add(course2);
		courseLst.add(course1);
		enr.setCourse(courseLst);

		enrollRepo.save(enr);

		System.out.println("FROM Course Repo");
		courseRepo.findAll().forEach(s -> {
			System.out.println(s.getEnrollment().getName());
		});

		System.out.println("FROM Enrollment Repo");
		enrollRepo.findAll().forEach(s -> {
			System.out.println(s.getCourse().size());
		});

		
	}

}
