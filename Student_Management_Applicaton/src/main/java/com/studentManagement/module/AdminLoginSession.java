package com.studentManagement.module;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AdminLoginSession {
	
	@Id
	@Column(unique = true)
	@NotNull(message = "adminId can't be null")
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

}
