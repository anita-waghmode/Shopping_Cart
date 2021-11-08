package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entity.AddProductEntity;
import com.shoppingcart.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity,Integer >{

//	UserEntity findUserNameAdPassword(String userName, String password);
	

}
