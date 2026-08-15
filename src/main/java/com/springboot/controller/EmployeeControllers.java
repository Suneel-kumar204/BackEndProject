package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.EmployeeDTO;
import com.springboot.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/employee")
public class EmployeeControllers {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/AddEmployee") 
	public EmployeeDTO addEmployee(@Valid @ModelAttribute EmployeeDTO dto,
			@RequestParam(value="photo",required = false) MultipartFile file) throws Exception{
		byte[] photo=null;
		if(file!=null && !file.isEmpty()) {
			photo=file.getBytes();
		}
		return service.addEmployee(dto, photo);
	}
	
	@PutMapping("/UpdateEmployee/{empId}")
	public EmployeeDTO updateEmployee(@PathVariable long empId, @Valid @ModelAttribute EmployeeDTO dto, 
			@RequestParam(value="photo",required = false)MultipartFile file)throws Exception{
		byte[] photo=null;
		if(file!=null && !file.isEmpty()) {
			photo=file.getBytes();
		}
		return service.updateEmployee(empId, dto, photo);
	}
	
	@DeleteMapping("/DeleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable long empId) {
		service.deleteEmployee(empId);
	}
	
	@GetMapping("/ViewEmployee/{empId}")
	public EmployeeDTO getEmployee(@PathVariable long empId) {
		return service.getEmployee(empId);
	}
	
	@GetMapping("/ViewByEmail/{emailId}")
	public EmployeeDTO findByEmailId(@PathVariable String emailId) {
		return service.findByEmailId(emailId);
	}
	
	@GetMapping({"/","AllEmployee"})
	public List<EmployeeDTO> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/photo/{empId}")
	public ResponseEntity<byte[]> getEmployeePhoto(@PathVariable long empId) {
		byte[] image=service.getEmployeePhoto(empId);
		return ResponseEntity.ok().header("Cache-Control", "no-store")
				.contentType(MediaType.IMAGE_JPEG).body(image);
	}
}