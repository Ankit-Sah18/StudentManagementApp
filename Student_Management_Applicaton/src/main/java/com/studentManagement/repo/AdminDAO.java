package com.studentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagement.module.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

}
