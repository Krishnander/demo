package com.LongTime.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LongTime.Entity.UserEntity;
import com.LongTime.Service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class UserController {
	
	Gson gson=new GsonBuilder().setPrettyPrinting().create();
	
	@Autowired
	UserService service;
	
	@GetMapping(value = "/allUsers")
	public List<String> allUsers(){
		List<String> userList=new ArrayList<>();
		userList=service.getAllUsers();
		return userList;
	}
	
	@GetMapping(value = "/email/{name}")
	public void emails(@PathVariable String name) {
		String mail=service.getUserEmailId(name);
		System.out.println(mail);
	}
	
	@RequestMapping(value = "/create/newUser", method= {RequestMethod.PUT, RequestMethod.GET})
	public String newUser(){
		UserEntity userEntity=service.createNewUser();
		return userEntity.toString();
	}

	@RequestMapping(value = "/modifyUser/{email}", method= {RequestMethod.POST,RequestMethod.GET})
	public String modifyUser(@PathVariable String email) {
		UserEntity userEntity=service.modifyUserData(email);
		return gson.toJson(userEntity);
	}
	
	@RequestMapping(value = "/deleteUser/{name}", method= {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteUser(@PathVariable String name) {
		List<UserEntity> userList=service.deleteUser(name);
		return gson.toJson(userList);
	}
}
