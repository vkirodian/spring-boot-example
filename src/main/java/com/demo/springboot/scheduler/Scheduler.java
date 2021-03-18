package com.demo.springboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);

	@Scheduled(cron = "7 * * * * ?")
	public void cronJobSchedule() {
		LOG.info("This is logged by CRON job schedule");
	}

	@Scheduled(fixedRate = 13000)
	public void fixedRateSchedule() {
		LOG.info("This is logged by fixed rate schedule");
	}

	@Scheduled(fixedDelay = 17000, initialDelay = 0)
	public void fixedDelaySchedule() {
		LOG.info("This is logged by fixed delay schedule");
	}
}
