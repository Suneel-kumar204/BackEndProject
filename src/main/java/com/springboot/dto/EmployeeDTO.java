package com.springboot.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	private long empId;
	
	@NotBlank(message="First Name is required")
	private String firstName;
	
	@NotBlank(message="Last Name is required")
	private String lastName;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "DOB is requried")
	private LocalDate dob;
	
	@NotNull(message = "Phone Number is required")
	private long phoneNumber;
	
	@NotBlank(message = "Email Id is required")
	private String emailId;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Department is required")
	private String department;
	
	@NotBlank(message = "Designation is required")
	private String designation;
	
	@NotNull(message = "Salary is required")
	private double salary;
}