package com.controller;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;


public class Student { 
	
	@Pattern(regexp="[^0-9]*")
	private String studentName;
	
	@Size(min=2, max=30) @IsValidHobby
	private String studentHobby;
	
	@Max(500)
	private Long studentMobile;
	
	@Past
	private Date studentDOB;
	private List<String> studentSkills;
	private Address studentAddress;
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public List<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(List<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

}
