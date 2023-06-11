package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {
	public String registerJobSeeker(JobSeekerInfo info);
	public List<JobSeekerInfo> getAllJobSeeker();
	public String fetchResumePathById(Integer id);
	public String fetchPhotoPathById(Integer id);

}
