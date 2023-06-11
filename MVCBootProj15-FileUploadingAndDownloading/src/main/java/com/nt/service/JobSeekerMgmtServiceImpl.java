package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerInfoRepository;

@Service("ServiceImpl")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private IJobSeekerInfoRepository repo;

	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job Seeker is saved with id value::"+repo.save(info).getJsId();
	}

	@Override
	public List<JobSeekerInfo> getAllJobSeeker() {
		return repo.findAll();
	}

	@Override
	public String fetchResumePathById(Integer id) {
		return repo.getResumePathById(id);
	}

	@Override
	public String fetchPhotoPathById(Integer id) {
		return repo.getPhotoPathById(id);
	}

}
