package com.springboot.service;

import java.util.List;

import com.springboot.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO addEmployee(EmployeeDTO dto,byte[] photo);
	EmployeeDTO updateEmployee(long empId,EmployeeDTO dto,byte[] photo);
	String deleteEmployee(long empId);
	EmployeeDTO getEmployee(long empId);
	EmployeeDTO findByEmailId(String emailId);
	List<EmployeeDTO> getAllEmployees();
	byte[] getEmployeePhoto(long empId);
}