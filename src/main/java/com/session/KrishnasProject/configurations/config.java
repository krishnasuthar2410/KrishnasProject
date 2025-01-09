package com.session.KrishnasProject.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j

public class config {
//	@Value("${dailyLimit}")
//	private int dailyLimit;
//	
	@Value("#{environment['dailyLimit']}")
	private int dailyLimit;
	
	@Bean
	public Integer chekvalue()
	{
		log.info("value of daily limit is: {}", dailyLimit);
		return dailyLimit;
		
	}

}
