package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="DEPT")
@Entity
public class Department {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
}
