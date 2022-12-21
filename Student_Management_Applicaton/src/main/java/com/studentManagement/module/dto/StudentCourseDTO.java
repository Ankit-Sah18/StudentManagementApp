package com.studentManagement.module.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCourseDTO {
       
	private Integer StudentId;
	private String name;
	
	private List<CourseDTO> courses = new ArrayList<>();
}
