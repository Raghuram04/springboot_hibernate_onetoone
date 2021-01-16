package com.weblearner.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.weblearner.springboot.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SudentControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	public void getStudentTest() {
		Student stu = this.restTemplate.getForObject("http://localhost:" + randomServerPort + "/student/1",
				Student.class);
		Assert.assertNotNull(stu);
		Assert.assertEquals("Sam", stu.getName());

	}

	@Test
	public void newStudentTest() {
		Student student = new Student();
		student.setRollNo(100);
		student.setName("Tom");
		student.setDept("CSE");
		Student stu = this.restTemplate.postForEntity("http://localhost:" + randomServerPort + "/student/new", student,
				Student.class).getBody();
		Assert.assertNotNull(stu);
		Assert.assertEquals("Tom", stu.getName());
		Assert.assertEquals("CSE", stu.getDept());

	}
}
