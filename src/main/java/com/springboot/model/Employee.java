package com.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employee_Project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 10001,name="emp_seq_data",sequenceName = "emp_seq_data")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq_data")
	@Column(name="emp_id")
	private long empId;
	
	@Column(name="emp_first_name",length = 20,nullable = false)
	private String firstName;
	
	@Column(name="emp_last_name",length = 20,nullable = false)
	private String lastName;
	
	@Column(name="emp_gender",length = 10,nullable = false)
	private String gender;
	
	@Column(name="emp_dob")
	private LocalDate dob;
	
	@Column(name="emp_phone",columnDefinition = "number(10)",nullable = false)
	private long phoneNumber;
	
	@Column(name="emp_email",length=35,unique = true,nullable = false)
	private String emailId;
	
	@Column(name="emp_address",length=50)
	private String address;
	
	@Column(name="emp_dept",length=25)
	private String department;
	
	@Column(name="emp_designation",length=25)
	private String designation;
	
	@Column(name="emp_salary",columnDefinition = "number(8,2)")
	private double salary;
	
	@Lob
	@Column(name="emp_photo")
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;
	
}