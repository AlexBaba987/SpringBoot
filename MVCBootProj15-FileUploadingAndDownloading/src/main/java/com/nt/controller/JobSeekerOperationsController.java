package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOperationsController {
	@Autowired
	private IJobSeekerMgmtService service;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/js_register")
	public String showRegisterFormPage(@ModelAttribute("js") JobSeeker js) {
		return "jobseeker_register";
	}
	
	@Autowired
	private Environment env;
	
	@PostMapping("/js_register")
	public String registerJsDetails(@ModelAttribute("js") JobSeeker js,Map<String,Object> map) throws Exception {
		
		String uploadPath=env.getProperty("upload.path");
		
		File file=new File(uploadPath);
		if(!file.exists())
			file.mkdir();
		
		MultipartFile file1=js.getResume();
		MultipartFile file2=js.getPhoto();
		InputStream is1=file1.getInputStream();
		InputStream is2=file2.getInputStream();
		
		String filename1=file1.getOriginalFilename();
		String filename2=file2.getOriginalFilename();
		System.out.println(filename1+ "_______"+filename2);
		OutputStream os1=new FileOutputStream(uploadPath+"/"+filename1);
		OutputStream os2=new FileOutputStream(uploadPath+"/"+filename2);
		
		//IOUtils.copy(is1, os1);
		//IOUtils.copy(is2, os2);
		
		is1.transferTo(os1);
		is2.transferTo(os2);
		
		//close stream
		is1.close();is2.close();
		os1.close();os2.close();
		
		//create Entity class Object by collecting data from Model class obj
		JobSeekerInfo info=new JobSeekerInfo();
		info.setJsName(js.getJsName());
		info.setJsAddrs(js.getJsAddrs());
		info.setResumePath(uploadPath+"/"+filename1);
		info.setPhotoPath(uploadPath+"/"+filename2);
		
		//service method
		String msg=service.registerJobSeeker(info);
		
		//add the name of the uploaded file to Model Attribute
		map.put("filename1", filename1);
		map.put("filename2", filename2);
		map.put("resultMsg", msg);
		
		return "show_result";
	}
	
	@GetMapping("js_report")
	public String showJsReport(Map<String,Object> map) {
		List<JobSeekerInfo> list=service.getAllJobSeeker();
		map.put("jsInfo", list);
		return "report_jobseekers";
	}
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("js_download")
	public String downloadFile(HttpServletResponse res,@RequestParam("id") Integer id,@RequestParam("type") String type) {
		
		String filePath=null;
		if(type.equalsIgnoreCase("resume"))
			filePath=service.fetchResumePathById(id);
		else if(type.equalsIgnoreCase("photo"))
			filePath=service.fetchPhotoPathById(id);
		
		
		File file=new File(filePath);
		//length of the file
		res.setContentLengthLong(file.length());
		//MINE type of the file
		String mineType=sc.getMimeType(filePath);
		mineType=mineType==null?"application/octet-stream":mineType;
		//make mine type as response type
		res.setContentType(mineType);
		//give instruction to browser to make arived content as downloadable file content
		res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		//InputStream and OutputStream 
		try(InputStream is=new FileInputStream(file);
				OutputStream os=res.getOutputStream()){
			
			IOUtils.copy(is, os);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
