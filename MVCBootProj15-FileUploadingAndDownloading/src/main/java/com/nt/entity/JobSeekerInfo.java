package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="BOOT_JS_INFO")
public class JobSeekerInfo {
	
	@Id
	@Column(name="JS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsId;
	
	@Column(name="JS_NAME",length = 30)
	private String jsName;
	
	@Column(name="JS_ADDRS",length = 30)
	private String jsAddrs;
	
	@Column(name="JS_RESUME_PATH",length = 100)
	private String resumePath;
	
	@Column(name="JS_PHOTO_PATH",length = 100)
	private String photoPath;
}
