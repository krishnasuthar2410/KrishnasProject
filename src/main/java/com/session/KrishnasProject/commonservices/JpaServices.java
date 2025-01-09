package com.session.KrishnasProject.commonservices;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("JpaServices")
@Slf4j
public class JpaServices extends Accountservices{

	@Override
	public void display() {
		log.info("calling from Jap account...");
		
	}

}
