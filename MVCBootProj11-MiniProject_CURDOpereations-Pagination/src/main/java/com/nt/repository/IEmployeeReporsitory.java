package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Employee;

public interface IEmployeeReporsitory extends PagingAndSortingRepository<Employee, Integer> {
	
}
