package com.EmployeeManagementSystem.dto;

import java.util.List;

import com.EmployeeManagementSystem.entity.Address;
import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.entity.Project;

public class EmployeeDto {

	private Integer id;
	private String name;
	private Address address;
	private Department department;
	private List<Project> projects;

	public EmployeeDto() {
	}

	public EmployeeDto(String name, Address address, Department department, List<Project> projects) {
		super();
		this.name = name;
		this.address = address;
		this.department = department;
		this.projects = projects;
	}

	public EmployeeDto(Integer id, String name, Address address, Department department, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", address=" + address + ", department=" + department
				+ ", projects=" + projects + "]";
	}

}
