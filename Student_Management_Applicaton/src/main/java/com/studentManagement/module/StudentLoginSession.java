package com.studentManagement.module;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentLoginSession {
      
	@Id
	@Column(unique = true)
	@NotNull(message = "studentId can't be null")
	private Integer studentId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
}
