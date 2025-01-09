package com.session.KrishnasProject.commonservices;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("JdbcServices")
@Slf4j
public class JdbcServices extends Accountservices {

	@Override
	public void display() {
	log.info("calling from Jdbc sevice account...");	
		
	}

}
