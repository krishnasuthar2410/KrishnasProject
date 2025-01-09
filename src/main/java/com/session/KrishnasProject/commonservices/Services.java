package com.session.KrishnasProject.commonservices;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@MyTestAnnotation
public class Services {
	@MyTestAnnotation
	private String name;
	public Services()
	{
		this.name="Hello,krishna";
	}
	
	public void test()
	{
		log.info("test method called from services...");
		log.info("Field name is:-{}",name);
	}

}
