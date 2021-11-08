package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.UserEntity;
import com.shoppingcart.model.AddProductBO;

public interface ShoppingCartService {

	AddProductBO addProduct(AddProductBO addProductBO);
	
	List<AddProductBO> getProductList();
	
	AddProductBO updateProduct(AddProductBO addProduct);
	
	String deleteProduct(AddProductBO addProductbo);

	AddProductBO getProductById(AddProductBO addProductbo);

	UserEntity addUser(UserEntity userEntity);

	List<UserEntity> getUserList();

	UserEntity updateUser(UserEntity userEntity);

	String deleteUser(UserEntity userEntity);

	String findUserNameAdPassword(UserEntity userEntity);

}
