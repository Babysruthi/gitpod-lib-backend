package com.revature.librarymanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
//comment edited check edited..
//main class-edit
//fghj
//dfgh
//abc
//
//
//
@SpringBootApplication
public class RevatureApplication {
	private static final Logger logger = LogManager.getLogger(RevatureApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Library Management Application");
		SpringApplication.run(RevatureApplication.class, args);

	}

}
