package com.session.KrishnasProject.commonservices;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsychService {
	@Async
	public CompletableFuture<Void> samplewait(int num) throws InterruptedException
	{
		log.info("execution started...");
		for(int i=0;i<num;i++)
		{
			Thread.sleep(1000);
		}
		log.info("execution completed...");
		return CompletableFuture.completedFuture(null);
	}
	

}
