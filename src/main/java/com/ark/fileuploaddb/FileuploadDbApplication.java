package com.ark.fileuploaddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileuploadDbApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(FileuploadDbApplication.class, args);
	}

}
