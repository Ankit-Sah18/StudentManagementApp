package com.studentManagement.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Login;
import com.studentManagement.module.StudentLogin;
import com.studentManagement.service.AdminService;
import com.studentManagement.service.LoginService;
import com.studentManagement.service.StudentService;


@RestController
public class LoginControler {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> adminLoginHandler(@RequestBody Login login) throws LoginException{
		 
		    String loginAdmin= loginService.adminLogin(login);
		    
		    return new ResponseEntity<String>(loginAdmin, HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/logout")
	public ResponseEntity<String> adminLogoutHandler(@RequestParam String key)
	{
		       String logout= loginService.adminLogout(key);
		       
		       return new ResponseEntity<String>(logout, HttpStatus.OK);
	}
	
	@PostMapping("/student/login")
	public ResponseEntity<String> studentLoginHandler(@RequestBody StudentLogin studentLogin) throws StudentException{
		 
		    String loginStudent= loginService.studentValidation(studentLogin);
		    
		    return new ResponseEntity<String>(loginStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/student/logout")
	public ResponseEntity<String> studentLogoutHandler(@RequestParam String key)
	{
		       String logout= loginService.StudentLogout(key);
		       
		       return new ResponseEntity<String>(logout, HttpStatus.OK);
	}
	
	

}
