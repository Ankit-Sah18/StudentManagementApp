package com.studentManagement.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.studentManagement.module.dto.TypeOfAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
     
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer addressId;
	
	@NotNull(message = "area can't be Null")
	@NotBlank(message = "area can't be blank")
	@NotEmpty(message = "area can't be empty")
	 private String area;
	
	@NotNull(message = "city can't be Null")
	@NotBlank(message = "city can't be blank")
	@NotEmpty(message = "city can't be empty")
	 private String city;
	
	@NotNull(message = "district can't be Null")
	@NotBlank(message = "district can't be blank")
	@NotEmpty(message = "district can't be empty")
	 private String district;
	
	@NotNull(message = "state can't be Null")
	@NotBlank(message = "state can't be blank")
	@NotEmpty(message = "state can't be empty")
	 private String state;
	
	@NotNull(message = "pincode can't be Null")
	@NotBlank(message = "pincode can't be blank")
	@NotEmpty(message = "pincode can't be empty")
	 private String pincode;
	
	
	 private TypeOfAddress typeOfAddress;
	 
}
