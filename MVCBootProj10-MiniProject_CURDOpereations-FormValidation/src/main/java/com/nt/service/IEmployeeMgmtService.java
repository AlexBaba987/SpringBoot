package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByID(int eno);
	public List<Integer> fetchAllDeptNo();
	public boolean isDesgInRejectedList(String desg);
}
