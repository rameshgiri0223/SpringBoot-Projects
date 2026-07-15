package com.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basket.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByEmail(String email);
	public UserEntity findByMobile(String mobile);
	

}
