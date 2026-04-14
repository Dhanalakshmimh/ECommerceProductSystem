package com.EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.EmployeeManagementSystem.entity.Address;
import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.entity.Project;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Department
		Department department = new Department();
		department.setName("IT");

		// Employees
		Employee e1 = new Employee();
		e1.setName("Dhanu");
		e1.setDepartment(department);

		Employee e2 = new Employee();
		e2.setName("Divya");
		e2.setDepartment(department);

		department.setEmployee(Arrays.asList(e1, e2));

		// Address
		Address a1 = new Address();
		a1.setCity("Mysore");
		a1.setEmployee(e1);

		Address a2 = new Address();
		a2.setCity("Bangalore");
		a2.setEmployee(e2);

		e1.setAddress(a1);
		e2.setAddress(a2);

		// Projects
		Project p1 = new Project();
		p1.setName("Project A");

		Project p2 = new Project();
		p2.setName("Project B");

		e1.setProjects(Arrays.asList(p1, p2));
		e2.setProjects(Arrays.asList(p1, p2));

		// Save
		session.persist(department);

		transaction.commit();
		session.close();

		System.out.println("Data stored successfully ");
	}
}