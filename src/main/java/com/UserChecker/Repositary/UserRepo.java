package com.UserChecker.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserChecker.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByPhoneAndCell(String phone, String cell);
	
	  // Derived query methods
     User findByCellAndEmail(String cell, String email);
     
     // Fetch users between two user IDs (derived query)
     List<User> findByUserIdBetween(Long fromId, Long toId);
     
     User findByCellAndPhone(String cell, String phone);
}
