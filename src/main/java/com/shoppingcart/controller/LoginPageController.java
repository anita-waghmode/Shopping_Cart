package com.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entity.UserEntity;
import com.shoppingcart.model.AddProductBO;
import com.shoppingcart.service.ShoppingCartService;

import javax.validation.Valid;

@RestController
public class LoginPageController {

	@Autowired 
	private ShoppingCartService shoppingCartService;
	
	@PostMapping(value="/adduser")
	public String adduser(@Valid @RequestBody UserEntity userEntity) {
		try {
		UserEntity userEntity1 = shoppingCartService.addUser(userEntity);
		
			} catch (Exception e) {
				return "user not register sucessfully";
			}
		return "user register sucessfully";
	
		}

	
	@GetMapping(value="/get-user")
	public List<UserEntity> getUser(){
		
		List<UserEntity> userEntityList = new ArrayList<>();
		try {
			userEntityList=shoppingCartService.getUserList();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("user not found");
		}
		return userEntityList;
		
	}
	
	@PutMapping(value="/update-user")
	public String updateUser(@RequestBody UserEntity userEntity) {
		UserEntity Response = new UserEntity();
		try {
			Response = shoppingCartService.updateUser(userEntity);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("user not updated");
		}
		return "user updated successfully";
		
	}
	
	@DeleteMapping(value="/delete-user/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(userId);
		try {
		String status=shoppingCartService.deleteUser(userEntity);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("user not deleted");
		}
		return "user deleted successfully";
		
	}
	@PostMapping(value="/user-check/{userName}/{password}")
	public String checkUser(@PathVariable("userName") String userName,@PathVariable("password") String password) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserName(userName);
		userEntity.setPassword(password);
		try {
		String status=shoppingCartService.findUserNameAdPassword(userEntity);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("user not deleted");
		}
		return "user deleted successfully";
		
	}
	
}
