package com.EmployeeManagementSystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_id")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String contactNo;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private Address address;

	// Many-to-Many with Project
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> projects;

	public Employee() {

	}

	public Employee(Integer id, String name, String email, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
