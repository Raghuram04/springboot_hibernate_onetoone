package com.weblearner.springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "mysequence", sequenceName = "mysequence", allocationSize = 1)
	@GeneratedValue(generator = "mysequence")
	@Column(name = "id")
	private int empId;

	@Column(name = "name")
	private String empName;

	@Column(name = "gender")
	private String gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deptid", referencedColumnName = "deptid")
	private Department deptartment;

	public Employee() {

	}

	public Employee(String empName, String gender, Department deptartment) {
		super();
		this.empName = empName;
		this.gender = gender;
		this.deptartment = deptartment;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDeptartment() {
		return deptartment;
	}

	public void setDeptartment(Department deptartment) {
		this.deptartment = deptartment;
	}

}
