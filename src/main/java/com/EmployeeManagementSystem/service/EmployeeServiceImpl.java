package com.EmployeeManagementSystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.EmployeeManagementSystem.Exception.EmployeeException;
import com.EmployeeManagementSystem.dto.EmployeeDto;
import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeServiceImpl employeeServiceImple = new EmployeeServiceImpl();

	private EmployeeServiceImpl() {

	}

	public static EmployeeServiceImpl getInstance() {
		return employeeServiceImple;
	}

	SessionFactory sessionFactory = HibernateUtil.getSession();

	@Override
	public void addEmployee(EmployeeDto dto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			if (dto.getId() != null) {
				throw new EmployeeException("Id not needed to add/create");
			}
			Employee employee = new Employee();
			employee.setName(dto.getName());
			session.persist(employee);
			transaction.commit();
			System.out.println("Employee created successfully");
		} catch (EmployeeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public String updateEmployeeById(EmployeeDto dto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			if (dto.getId() == null) {
				throw new EmployeeException("Id needed to update");
			}
			Employee employee = session.get(Employee.class, dto.getId());
			if (employee == null) {
				throw new EmployeeException("Employee not found");
			}
			employee.setName(dto.getName());
			session.merge(employee);
			transaction.commit();
		} catch (EmployeeException e) {
			throw e;
		} finally {
			session.close();
		}
		return "Employee updated successfully";
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee employee = session.get(Employee.class, id);
			if (employee == null) {
				throw new EmployeeException("Employee not found");
			}
			session.remove(employee);
			transaction.commit();
			System.out.println("Employee deleted successfully");
		} catch (EmployeeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			Employee employee = session.get(Employee.class, id);
			if (employee == null) {
				throw new EmployeeException("Employee not found");
			}
			EmployeeDto dto = new EmployeeDto();
			dto.setId(employee.getId());
			dto.setName(employee.getName());
			return dto;
		} catch (EmployeeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		Session session = sessionFactory.openSession();
		try {
			List<Employee> employees = session.createQuery("From Employee", Employee.class).list();
			return employees.stream().map(emp -> {
				EmployeeDto dto = new EmployeeDto();
				dto.setId(emp.getId());
				dto.setName(emp.getName());
				return dto;
			}).toList();
		} finally {
			session.close();
		}
	}

}


