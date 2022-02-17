package com.emp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.main.entity.Employee;
import com.emp.main.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeService;
	
			
	@PostMapping("/createEmployee") 
	public String createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
		
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id) {
		
		return employeeService.updateEmployee(employee,id);
	}
		

}
