package com.nobel.backwardsClock;

import com.nobel.backwardsClock.Services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Clock;

@SpringBootApplication
public class BackwardsClockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackwardsClockApplication.class, args);
	}

	@Autowired
	private ClockService clockService;

	@Override
	public void run(String...args) throws Exception{
		clockService.runClockApplication();
	}

}
