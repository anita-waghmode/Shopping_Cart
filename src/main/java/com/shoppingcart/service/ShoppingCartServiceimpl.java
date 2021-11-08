package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.entity.AddProductEntity;
import com.shoppingcart.entity.UserEntity;
import com.shoppingcart.model.AddProductBO;
import com.shoppingcart.repository.ProductDAO;
import com.shoppingcart.repository.UserDao;

@Service
public class ShoppingCartServiceimpl implements ShoppingCartService{

	@Autowired
	private ProductDAO dao;
	@Autowired
	private UserDao userDao;
	@Override
	public AddProductBO addProduct(AddProductBO addProductBO) {
		
		AddProductEntity entity = new AddProductEntity();
		try {
		entity.setProductCategory(addProductBO.getProductCategory());
		entity.setProductName(addProductBO.getProductName());
		entity.setProductPrice(addProductBO.getProductPrice());
		entity=dao.save(entity);
		addProductBO.setProductId(entity.getProductId());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Product not added");
		}
		return addProductBO;
	}
	@Override
	public List<AddProductBO> getProductList() {
		List<AddProductBO> bolist = new ArrayList<>();
		try {
		List<AddProductEntity> addProductEntitylist=dao.findAll();
		for(AddProductEntity entity:addProductEntitylist) {
			AddProductBO bo = new AddProductBO();
			bo.setProductId(entity.getProductId());
			bo.setProductName(entity.getProductName());
			bo.setProductCategory(entity.getProductCategory());
			bo.setProductPrice(entity.getProductPrice());
			bolist.add(bo);
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Product not found");
		}
		return bolist;
	}
	@Override
	public AddProductBO updateProduct(AddProductBO addProduct) {
		AddProductEntity entity = new AddProductEntity();
		try {
		entity.setProductId(addProduct.getProductId());
		entity.setProductCategory(addProduct.getProductCategory());
		entity.setProductName(addProduct.getProductName());
		entity.setProductPrice(addProduct.getProductPrice());
		entity=dao.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Product not updated");
		}
		return addProduct;
	}
	@Override
	public String deleteProduct(AddProductBO addProductbo) {
		String status="Success";
		AddProductEntity entity = new AddProductEntity();
		try {
		entity.setProductId(addProductbo.getProductId());
		dao.deleteById(entity.getProductId());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Product not deleted");
		}
		return status;
	}
	@Override
	public AddProductBO getProductById(AddProductBO addProductbo) {
		AddProductEntity entity = new AddProductEntity();
		try {
		entity.setProductId(addProductbo.getProductId());
		entity=dao.getById(entity.getProductId());
		addProductbo.setProductCategory(entity.getProductCategory());
		addProductbo.setProductId(entity.getProductId());
		addProductbo.setProductName(entity.getProductName());
		addProductbo.setProductPrice(entity.getProductPrice());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Product not found");
		}
		return addProductbo;
	}
	@Override
	public UserEntity addUser(UserEntity userEntity) {
		
		UserEntity entity = new UserEntity();
		try {
			entity.setEmail(userEntity.getEmail());
			entity.setFirstName(userEntity.getFirstName());
			entity.setIs_Deleted(userEntity.getIs_Deleted());
			entity.setLastName(userEntity.getLastName());
			entity.setMobileNumber(userEntity.getMobileNumber());
			entity.setPassword(userEntity.getPassword());
			entity.setUserName(userEntity.getUserName());
			entity=userDao.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("getting exception while user registration");
		}
		return userEntity;
		}
	@Override
	public List<UserEntity> getUserList() {
		List<UserEntity> userList = new ArrayList<>();
		try {
		List<UserEntity> addUserEntityList=userDao.findAll();
		for(UserEntity entity:addUserEntityList) {
			UserEntity User = new UserEntity();
			User.setEmail(entity.getEmail());
			User.setFirstName(entity.getFirstName());
			User.setIs_Deleted(entity.getIs_Deleted());
			User.setLastName(entity.getLastName());
			User.setMobileNumber(entity.getMobileNumber());
			User.setPassword(entity.getPassword());
			User.setUserName(entity.getUserName());
			userList.add(User);
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("user not found");
		}
		return userList;
	}
	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		UserEntity entity = new UserEntity();
		try {
		entity.setUserId(userEntity.getUserId());
		entity.setEmail(userEntity.getEmail());
		entity.setFirstName(userEntity.getFirstName());
		entity.setLastName(userEntity.getLastName());
		entity.setMobileNumber(userEntity.getMobileNumber());
		entity.setPassword(userEntity.getPassword());
		entity.setUserName(userEntity.getUserName());
		entity=userDao.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("user not updated");
		}
		return userEntity;
	}
	@Override
	public String deleteUser(UserEntity userEntity) {
		String status="Success";
		UserEntity entity = new UserEntity();
		try {
		entity.setUserId(userEntity.getUserId());
		entity.setIs_Deleted("1");
	//	entity=	userDao.findUserNameAdPassword(userEntity.getUserName(),userEntity.getPassword());
		userDao.deleteById(entity.getUserId());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("user not deleted");
		}
		return status;
	}
	@Override
	public String findUserNameAdPassword(UserEntity userEntity) {
	//	String status="";
		UserEntity entity = new UserEntity();
		try {
		//entity.setUserId(userEntity.getUserId());
	//	entity.setIsDeleted("1");
		//entity=	userDao.findUserNameAdPassword(userEntity.getUserName(),userEntity.getPassword());
		//userDao.deleteById(entity.getUserId());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("user not deleted");
		}
		return "Login successfully";
	}

}
