package com.session.KrishnasProject.healthcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.aot.AotServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.KrishnasProject.commonservices.Accountservices;
import com.session.KrishnasProject.commonservices.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/health/check")
@Slf4j
@RequiredArgsConstructor
public class HealthCheckStatus {
	
	private final Services service;
	@Autowired
	private @Qualifier("JdbcServices") Accountservices accountservices;
	
//	@Autowired
//	public HealthCheckStatus(Services service)
//	{
//		this.service=service;
//	}
	@GetMapping
	public HttpStatus healthcheck()
	{ 
		log.info("reached---->healthcheck");
		service.test();
		accountservices.display();
		return HttpStatus.OK;
	}
	
	

}
