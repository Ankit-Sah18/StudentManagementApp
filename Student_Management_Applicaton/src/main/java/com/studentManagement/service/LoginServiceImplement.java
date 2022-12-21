package com.studentManagement.service;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Admin;
import com.studentManagement.module.AdminLoginSession;
import com.studentManagement.module.Login;
import com.studentManagement.module.Student;
import com.studentManagement.module.StudentLogin;
import com.studentManagement.module.StudentLoginSession;
import com.studentManagement.module.dto.StudentDTO;
import com.studentManagement.repo.AdminDAO;
import com.studentManagement.repo.LoginSessionDAO;
import com.studentManagement.repo.StudentDAO;
import com.studentManagement.repo.StudentLoginSessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImplement implements LoginService{

	@Autowired
	private AdminDAO adminDao;
	
	@Autowired
	private LoginSessionDAO loginSessionDao;
	
	@Autowired
	private StudentLoginSessionDAO studentLoginSessionDao;
	
	@Autowired
	private StudentDAO studentDao;
	
	@Override
	public String adminLogin(Login login) throws LoginException {
		     
		      Optional<Admin> admin= adminDao.findById(login.getAdminId());
		      if(admin.isEmpty())
		      {
		    	  throw new LoginException("Admin is not available with this Id..");
		      }
		      
		      Optional<AdminLoginSession> currentLoginsession= loginSessionDao.findById(login.getAdminId());
		      if(currentLoginsession.isPresent())
		      {
		    	  throw new LoginException("Admin already logged in");
		      }
		       if(!admin.get().getPassword().equals(login.getPassword()))
		      {
		    	   throw new LoginException("please enter correct password.");
		    	 
		      }
		     
		    	  AdminLoginSession current= new AdminLoginSession();
		    	  current.setAdminId(admin.get().getAdminId());
		    	   String key = RandomString.make(6);
		    	   current.setUuid(key);
		    	   current.setLocalDateTime(LocalDateTime.now());
		    	   
		    	          loginSessionDao.save(current).toString();
		    	          
		    	          return current.toString();
		    	          
		    	         
	}
	
	@Override
	public String studentValidation(StudentLogin studentLogin) throws StudentException {
		
		 Optional<Student> student= studentDao.findById(studentLogin.getStudentId());
	      if(student.isEmpty())
	      {
	    	  throw new StudentException("student is not available with this Id..");
	      }
	      
	      Optional<StudentLoginSession> currentLoginSession= studentLoginSessionDao.findById(studentLogin.getStudentId());
	      if(currentLoginSession.isPresent())
	      {
	    	  throw new StudentException("Student already logged in");
	      }
	       if(!student.get().getDob().equals(studentLogin.getDob()))
	      {
	    	   throw new StudentException("please enter correct date of birth.");
	    	 
	      }
	     
	    	  StudentLoginSession current= new StudentLoginSession();
	    	     current.setStudentId(student.get().getStudentId());
	    	   String key = RandomString.make(6);
	    	   current.setUuid(key);
	    	   current.setLocalDateTime(LocalDateTime.now());
	    	   
	    	         studentLoginSessionDao.save(current).toString();
	    	          
	    	          return current.toString();
	}

	@Override
	public String adminLogout(String key) {
		
		Optional<AdminLoginSession> currentData= loginSessionDao.findByUuid(key);
		if(currentData.isPresent()) {
			loginSessionDao.delete(currentData.get());
			return "Logout Done";
		}else {
		 return "Login First...";
		}
	}

	@Override
	public String StudentLogout(String key) {
		Optional<StudentLoginSession> currentData= studentLoginSessionDao.findByUuid(key);
		if(currentData.isPresent()) {
			studentLoginSessionDao.delete(currentData.get());
			return "Logout Done";
		}else {
		 return "Login First...";
		}
	}

	

}


