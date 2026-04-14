package com.EmployeeManagementSystem.service;

import java.util.List;

import com.EmployeeManagementSystem.dto.EmployeeDto;

public interface EmployeeService {
	
	public void addEmployee(EmployeeDto dto);

	public String updateEmployeeById(EmployeeDto dto);

	public void deleteEmployeeById(Integer id);

	public EmployeeDto getEmployeeById(Integer id);

	public List<EmployeeDto> getAllEmployees();


}
