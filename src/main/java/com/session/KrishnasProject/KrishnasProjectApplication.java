package com.session.KrishnasProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
//@ComponentScan({"com.session.KrishnasProject","com.session.KrishnasProject.healthcontroller","com.session.KrishnasProject.commonservices"})
@EnableAsync
public class KrishnasProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrishnasProjectApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		log.info("Application is Initialized......");
	}
	@PreDestroy
	public void destroy()
	{
		log.info("Destrying the Application......");
	}
}
