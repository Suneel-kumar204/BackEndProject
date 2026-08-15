package com.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.EmployeeDTO;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO dto, byte[] photo) {
		Employee e=mapToEntity(dto);
		if(photo !=null) {
			e.setPhoto(photo);			
		}
		Employee saved=repo.save(e);
		return mapToDTO(saved);
	}

	@Override
	public EmployeeDTO updateEmployee(long empId, EmployeeDTO dto, byte[] photo) {
		Employee existing=repo.findById(empId).orElseThrow(()->new RuntimeException("Employee Not Found with ID :"+empId));
		existing.setEmpId(dto.getEmpId());
		existing.setFirstName(dto.getFirstName());
		existing.setLastName(dto.getLastName());
		existing.setGender(dto.getGender());
		existing.setDob(dto.getDob());
		existing.setPhoneNumber(dto.getPhoneNumber());
		existing.setEmailId(dto.getEmailId());
		existing.setAddress(dto.getAddress());
		existing.setDepartment(dto.getDepartment());
		existing.setDesignation(dto.getDesignation());
		existing.setSalary(dto.getSalary());
		if(photo !=null) {
			existing.setPhoto(photo);
		}
		
		Employee updated=repo.save(existing);
		return mapToDTO(updated);
	}

	@Override
	public String deleteEmployee(long empId) {
		repo.deleteById(empId);
		return "Employee Deleted Successfully..........";
	}

	@Override
	public EmployeeDTO getEmployee(long empId) {
		Employee e=repo.findById(empId).orElseThrow(()->new RuntimeException("Employee Not Found with ID :"+empId));
		return mapToDTO(e);
	}

	@Override
	public EmployeeDTO findByEmailId(String emailId) {
		Employee e=repo.findByEmailId(emailId).orElseThrow(()->new RuntimeException("Employee Not Found with Email ID :"+emailId));
		return mapToDTO(e);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> list=repo.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public byte[] getEmployeePhoto(long empId) {
		Employee e=repo.findById(empId).orElseThrow(()-> new RuntimeException("Employee Not Found with ID :"+empId));
		return e.getPhoto();
	}
	
	public Employee mapToEntity(EmployeeDTO dto) {
		return Employee.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.gender(dto.getGender())
				.dob(dto.getDob())
				.phoneNumber(dto.getPhoneNumber())
				.emailId(dto.getEmailId())
				.address(dto.getAddress())
				.department(dto.getDepartment())
				.designation(dto.getDesignation())
				.salary(dto.getSalary())
				.build();
	}

	public EmployeeDTO mapToDTO(Employee e) {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmpId(e.getEmpId());
		dto.setFirstName(e.getFirstName());
		dto.setLastName(e.getLastName());
		dto.setGender(e.getGender());
		dto.setDob(e.getDob());
		dto.setPhoneNumber(e.getPhoneNumber());
		dto.setEmailId(e.getEmailId());
		dto.setAddress(e.getAddress());
		dto.setDepartment(e.getDepartment());
		dto.setDesignation(e.getDesignation());
		dto.setSalary(e.getSalary());
		
		return dto;
	}
}