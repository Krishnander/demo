package com.LongTime.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LongTime.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	@Query(value = "select * from LongTime" , nativeQuery = true)
	public List<String> displayAllUsers();

	@Query(value = "select l.EmailId from LongTime l where l.Uname=?" , nativeQuery = true)
	public String getEmailId(String name);
	
	@Query(value="select * from LongTime l where l.EmailId=?", nativeQuery = true)
	public UserEntity getUserEntityByEmail(String email);
	
}
