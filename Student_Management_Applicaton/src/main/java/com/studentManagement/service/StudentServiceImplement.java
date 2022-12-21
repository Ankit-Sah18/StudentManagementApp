package com.studentManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.exception.CourseException;
import com.studentManagement.exception.LoginException;
import com.studentManagement.exception.StudentException;
import com.studentManagement.module.Address;
import com.studentManagement.module.AdminLoginSession;
import com.studentManagement.module.Course;
import com.studentManagement.module.Student;
import com.studentManagement.module.StudentLoginSession;
import com.studentManagement.module.dto.StudentAddressDTO;
import com.studentManagement.module.dto.StudentDTO;
import com.studentManagement.repo.AddressDAO;
import com.studentManagement.repo.CourseDAO;
import com.studentManagement.repo.LoginSessionDAO;
import com.studentManagement.repo.StudentDAO;
import com.studentManagement.repo.StudentLoginSessionDAO;


@Service
public class StudentServiceImplement implements StudentService{

	   @Autowired
       private StudentDAO  studentDao;
	   
	   @Autowired
	   private CourseDAO courseDao;
	   
	   @Autowired
	   private AddressDAO addressDao;
	   
	   @Autowired
	   private LoginSessionDAO loginSessionDao;
	   
	   @Autowired
	   private StudentLoginSessionDAO studentLoginSessionDao;
	   
	 
//	@Autowired (required = true)
//		private ModelMapper modelMapper;
	   
	   
	@Override
	public Student registerStudent(Student student) throws StudentException {
		   
		
		Student studentSave= studentDao.save(student);
		return studentSave;
		    
		          
	}


	@Override
	public Student updateEmailAndMobile(Student student,String key) throws StudentException, LoginException {
		   
		Optional<StudentLoginSession> studentLoginSession= studentLoginSessionDao.findByUuid(key);
        if(studentLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
        
        Student  studentUpdate= studentDao.getById(student.getStudentId());
		
		if(studentUpdate  == null) 
			throw new StudentException("Invalid StudentId Or DOB!") ;
		
		student.setMobileNumber(student.getMobileNumber());
		student.setEmail(student.getEmail());
		
		student = studentDao.save(student) ;
		
		return  student;
	}





	@Override
	public Address updateStudentAddress(Address address, String key) throws StudentException, LoginException {
    
		Optional<StudentLoginSession> studentLoginSession= studentLoginSessionDao.findByUuid(key);
        if(studentLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
		
		Address addressUpdate = addressDao.getById(address.getAddressId());
		addressUpdate.setArea(address.getArea());
		addressUpdate.setCity(address.getCity());
		addressUpdate.setDistrict(address.getDistrict());
		
		return addressUpdate;
		   
	}


	@Override
	public Course getStudentCourses(Integer courseId, String key) throws CourseException, LoginException {
		   
		Optional<StudentLoginSession> studentLoginSession= studentLoginSessionDao.findByUuid(key);
        if(studentLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
        
           Course course= courseDao.getById(courseId);
           
           if(course==null)
           {
        	    throw new CourseException("Course not found..");
           }
		        return course;
	}


	@Override
	public Course leaveCourse(Course course, String key) throws  CourseException, LoginException {
		
		Optional<StudentLoginSession> studentLoginSession= studentLoginSessionDao.findByUuid(key);
        if(studentLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
        
        Optional<Course> deleteCourse= courseDao.findById(course.getCourseId());
	    
	    if(!deleteCourse.isPresent())
	    {
	    	   throw new CourseException("course not deleted..");
	    }
	    
	    courseDao.delete(course);
	    
	    return  course;
          
          
	}


	


	
	


}
