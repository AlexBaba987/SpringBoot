package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employee;

public interface IEmployeeReporsitory extends CrudRepository<Employee, Integer> {
	
}
