package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerInfoRepository extends JpaRepository<JobSeekerInfo, Integer> {

	@Query("select resumePath from JobSeekerInfo where jsId=:id")
	public String getResumePathById(Integer id);
	
	@Query("Select photoPath from JobSeekerInfo where jsId=:id")
	public String getPhotoPathById(Integer id);
}
