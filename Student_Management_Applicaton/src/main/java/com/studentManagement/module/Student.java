package com.studentManagement.module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studentManagement.module.dto.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String name;
	private String fatherName;
	private String email;
	private String mobileNumber;
	private LocalDate dob;
	private Gender gender;
	
//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
//	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	List<Course> courses = new ArrayList<>();

	@Override
	public String toString() {
		return "Student [name=" + name + ", fatherName=" + fatherName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", gender=" + gender + ", address=" + address + "]";
	}

}
