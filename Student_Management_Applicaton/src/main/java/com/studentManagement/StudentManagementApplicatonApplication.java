package com.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentManagementApplicatonApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplicatonApplication.class, args);
	}

}
