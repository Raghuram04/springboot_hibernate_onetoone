package com.weblearner.springboot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.weblearner.springboot.model.Student;



@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentDaoTest {
	
	@Autowired
	StudentDao studentDaoTest;
	
	@Test
	public void testFindByName() {
		Student stu = studentDaoTest.findByName("Sam");
		Assert.assertNotNull(stu);		
	}
	
	@Test
	public void testFindAll() {
		List<Student> stu = studentDaoTest.findAll();
		Assert.assertNotNull(stu);
		Assert.assertTrue(stu.size() > 0);
		Assert.assertTrue(stu.size() == 3);
	}

}
