package com.emp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.main.entity.Employee;
import com.emp.main.repository.EmployeeRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	

	
	@Override
	public String createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		/*
		 * Company
		 * company=companyRepository.findById(employee.getCompany().getCompanyId()).
		 * orElse(null); Department dept =
		 * departmentRepository.findById(employee.getDepartment().getDepartmentId()).
		 * orElse(null);
		 * 
		 * if(company==null) {
		 * 
		 * company=new Company();
		 * company.setCompanyId(employee.getCompany().getCompanyId());
		 * company.setCompanyName(employee.getCompany().getCompanyName());
		 * companyRepository.save(company); } if(dept==null) {
		 * 
		 * dept=new Department();
		 * dept.setDepartmentId(employee.getDepartment().getDepartmentId());
		 * dept.setDepartmentName(employee.getDepartment().getDepartmentName());
		 * departmentRepository.save(dept);
		 * 
		 * }
		 * 
		 * employee.setCompany(company); employee.setDepartment(dept);
		 */
	
		employeeRepository.save(employee);
		
		return "Success";
	}


	

}
