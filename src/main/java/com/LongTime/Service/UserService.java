package com.LongTime.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LongTime.Entity.UserEntity;
import com.LongTime.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<String> getAllUsers() {
		List<String> userList = new ArrayList<>();
		userList = repository.displayAllUsers();
		return userList;
	}

	public String getUserEmailId(String name) {
		String email = repository.getEmailId(name);
		return email;
	}

	public UserEntity createNewUser() {
		UserEntity userEntity = new UserEntity("jj", 4, 789435, "j@jThre");
		repository.save(userEntity);
		return userEntity;
	}

	public UserEntity modifyUserData(String email) {
		UserEntity userEntity = repository.getUserEntityByEmail(email);
		userEntity.setName("Modified User");
		repository.save(userEntity);
		return userEntity;
	}

	public List<UserEntity> deleteUser(String name) {
		System.out.println("Deletion of " + name);
		List<UserEntity> userList = repository.findAll();

		UserEntity userEntity=userList.stream().filter(a->name.equalsIgnoreCase(a.getName())).findAny().orElse(null);

		repository.delete(userEntity);
		/*
		 * for(int i=0;i<=userList.size();i++) {
		 * if(userList.get(i).getName().equalsIgnoreCase(name)) {
		 * repository.delete(userList.get(i)); } }
		 */
		return userList;
	}
}
