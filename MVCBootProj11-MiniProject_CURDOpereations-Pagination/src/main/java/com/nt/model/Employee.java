package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name="BOOT_EMP")
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='INACTIVE' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'INACTIVE'")
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName ="emp_id_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1")
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	private String status="ACTIVE";
}
