package com.studentManagement.module;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentLogin {
      
	private Integer studentId;
	private LocalDate dob;
}
