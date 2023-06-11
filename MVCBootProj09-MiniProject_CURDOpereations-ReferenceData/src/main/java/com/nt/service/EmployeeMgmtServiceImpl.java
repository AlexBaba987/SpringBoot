package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IDepartmentRepository;
import com.nt.repository.IEmployeeReporsitory;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeReporsitory empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "Employee is Register with id value::"+empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(int eno) {
		Employee emp=empRepo.findById(eno).orElseThrow(() -> new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee is updated with having id value::"+empRepo.save(emp).getEmpno();
	}

	@Override
	public String deleteEmployeeByID(int eno) {
		empRepo.deleteById(eno);
		return eno+" employee id employee is deleted";
	}

	@Autowired
	private IDepartmentRepository deptRepo;
	
	@Override
	public List<Integer> fetchAllDeptNo() {
		List<Integer> deptnolist=deptRepo.getAllDeptNo();
		return deptnolist;
	}

}
