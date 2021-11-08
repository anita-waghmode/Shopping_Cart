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

import com.shoppingcart.model.AddProductBO;
import com.shoppingcart.service.ShoppingCartService;

import javax.validation.Valid;

@RestController
public class ShopCartController {

	@Autowired 
	private ShoppingCartService shoppingCartService;
	
	@PostMapping(value="/addProduct")
	public String addProduct(@Valid @RequestBody AddProductBO addProductBO) {
		
		AddProductBO addProductbo = shoppingCartService.addProduct(addProductBO);
		try {
		if(0!=addProductbo.getProductId()) {
		System.out.println("hi");
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Product Not added");
		}
		return "Product added sucessfully";
		}
		
		
	
	
	@GetMapping(value="/get-product")
	public List<AddProductBO> getProduct(){
		
		List<AddProductBO> addProductBOList = new ArrayList<>();
		try {
		addProductBOList=shoppingCartService.getProductList();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Products not found");
		}
		return addProductBOList;
		
	}
	
	@GetMapping(value="/get-product/{productId}")
	public AddProductBO getProductbyId(@PathVariable("productId") int productId){
		
		AddProductBO addProduct = new AddProductBO();
		try {
		addProduct.setProductId(productId);
		addProduct=shoppingCartService.getProductById(addProduct);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return addProduct;
		
	}
	
	@PutMapping(value="/update-product")
	public String updateProduct(@RequestBody AddProductBO addProduct) {
		AddProductBO addProductbo = new AddProductBO();
		try {
		 addProductbo = shoppingCartService.updateProduct(addProduct);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Product not updated");
		}
		return "Product updated successfully";
		
	}
	
	@DeleteMapping(value="/delete-product/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		AddProductBO addProductbo=new AddProductBO();
		addProductbo.setProductId(productId);
		try {
		String status=shoppingCartService.deleteProduct(addProductbo);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Product not deleted");
		}
		return "Product deleted successfully";
		
	}
}
