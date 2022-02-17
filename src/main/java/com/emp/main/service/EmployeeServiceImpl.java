package com.emp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.main.entity.Employee;
import com.emp.main.repository.CompanyRepository;
import com.emp.main.repository.DepartmentRepository;
import com.emp.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public String createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Optional<Integer> companyId = companyRepository
				.findByName(employee.getDepartment().getCompany().getCompanyName());
		Optional<Integer> departmentId = departmentRepository.findByName(employee.getDepartment().getDepartmentName());

		if (companyId.isPresent()) {
			employee.getDepartment().getCompany().setCompanyId(companyId.get());
		} else {
			companyRepository.save(employee.getDepartment().getCompany());

		}
		
		if (departmentId.isPresent()) {
			employee.getDepartment().setDepartmentId(departmentId.get());
		}

		else {
			departmentRepository.save(employee.getDepartment());
		}

		
		employeeRepository.save(employee);
		return "Success";
	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return "Success";
	}
	
	public List<Employee> getAllEmployee() {
		
		
		
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> employee2=employeeRepository.findById(id);
	
		Employee emp=employee2.get();
		if(employee2.isPresent()) {
			
			emp.getDepartment().setCompany(employee2.get().getDepartment().getCompany());
			emp.setDepartment(employee.getDepartment());
			emp.setSkill(employee.getSkill());
			employeeRepository.save(emp);
		}
		return employee2.get();
	}
	


}
