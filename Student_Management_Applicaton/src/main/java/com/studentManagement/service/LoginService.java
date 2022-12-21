package com.studentManagement.service;

import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Login;
import com.studentManagement.module.StudentLogin;

public interface LoginService {
	
	 public String adminLogin(Login login) throws LoginException;
	 public String studentValidation(StudentLogin studentLogin) throws StudentException;
	 public String StudentLogout(String key);
	 public String adminLogout(String key);
	
	

}
