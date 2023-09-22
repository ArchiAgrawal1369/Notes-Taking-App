package com.MiniAssignment.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.MiniAssignment.service.NotesService;

@Configuration
@EnableScheduling
public class AppScheduler {
	
	@Autowired 
	private NotesService service;
	
	@Scheduled(cron="0 0 * * * *")
	public void deleteEveryHour() {
		service.scheduledDeleteNote();
	}
}
