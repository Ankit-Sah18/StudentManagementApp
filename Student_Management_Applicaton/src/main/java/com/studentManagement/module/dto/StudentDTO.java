package com.studentManagement.module.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.studentManagement.module.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
 public class StudentDTO {
	 
	private Integer studentId;
	
	@NotNull(message = "name can't be Null")
	@NotBlank(message = "name can't be blank")
	@NotEmpty(message = "name can't be empty")
	private String name;
	
	@NotNull(message = "name of father can't be Null")
	@NotBlank(message = "name of father can't be blank")
	@NotEmpty(message = "name of father can't be empty")
	private String fatherName;
	
	@Email(message = "Please enter valid an emailId")
	private String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private LocalDate dob;
	
	@NotNull(message = "gender cannot be Null")
	private Gender gender;
	
	private List<Address> address= new ArrayList<>();

}
