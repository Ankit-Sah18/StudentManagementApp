package com.studentManagement.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagement.exception.CourseException;
import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Address;
import com.studentManagement.module.Course;
import com.studentManagement.module.Student;
import com.studentManagement.module.dto.StudentDTO;
import com.studentManagement.repo.AddressDAO;
import com.studentManagement.service.StudentService;

@RestController
public class StudentControler {
         
	@Autowired    //(required = false)
	  private StudentService studentService;
	
	@PostMapping("student/register")
	  public ResponseEntity<Student> studentRegisterHandler(@Valid @RequestBody Student student) throws StudentException{
		  
		      Student studentRegister= studentService.registerStudent(student);
		      
		      return new ResponseEntity<Student>(student, HttpStatus.OK);
	  }
	
	@PatchMapping("/students/update/")
	public ResponseEntity<Student> updateEmailAndMobileNumberHandler(@RequestBody  Student student,String key)
			throws StudentException, LoginException {

		Student studentupdate = studentService.updateEmailAndMobile(student,key);

		return new ResponseEntity<Student>(studentupdate, HttpStatus.OK);
	}
	
	@PatchMapping("/students/update/address")
	public ResponseEntity<Address> updateAddressHandler(@Valid @RequestBody Address address,String key)
			throws StudentException, LoginException {

		Address addressUpdated = studentService.updateStudentAddress(address,key);

		return new ResponseEntity<Address>(addressUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/courses")
	  public ResponseEntity<Course> DeleteRegistraion( @RequestBody Course course,@RequestParam String key) throws CourseException, LoginException {
		        
		        Course courseDelete=     studentService.leaveCourse(course,key);
		              
		               
		             return new ResponseEntity<Course>(courseDelete, HttpStatus.OK);
	  }
	
}
