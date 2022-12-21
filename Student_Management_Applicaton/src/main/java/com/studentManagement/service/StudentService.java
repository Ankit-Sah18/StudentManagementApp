package com.studentManagement.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.studentManagement.exception.CourseException;
import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Address;
import com.studentManagement.module.Course;
import com.studentManagement.module.Student;
import com.studentManagement.module.dto.StudentAddressDTO;
import com.studentManagement.module.dto.StudentCourseDTO;
import com.studentManagement.module.dto.StudentDTO;

public interface StudentService {
	
	public Student registerStudent(Student student) throws StudentException;
   public Student updateEmailAndMobile(Student student ,String key) throws StudentException, LoginException;
	
	public Address updateStudentAddress(Address address , String key) throws StudentException, LoginException;
	
	public Course getStudentCourses(Integer courseId,String key) throws LoginException, CourseException;
	
	public Course leaveCourse(Course course, String key ) throws  CourseException, LoginException;

	

}
