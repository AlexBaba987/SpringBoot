package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class MvcBootProj15FileUploadingAndDownloadingApplication {
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(50*1024*1024);
		resolver.setMaxUploadSize(-1);
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcBootProj15FileUploadingAndDownloadingApplication.class, args);
	}

}
