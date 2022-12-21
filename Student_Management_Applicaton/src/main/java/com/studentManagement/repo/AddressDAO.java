package com.studentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagement.module.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{

}
