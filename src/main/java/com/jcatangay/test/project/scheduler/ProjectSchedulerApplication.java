package com.jcatangay.test.project.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jcatangay.test.project.scheduler"})
public class ProjectSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSchedulerApplication.class, args);
	}

}
