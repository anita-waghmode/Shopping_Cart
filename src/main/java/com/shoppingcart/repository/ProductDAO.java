package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entity.AddProductEntity;

public interface ProductDAO extends JpaRepository<AddProductEntity,Integer >{

}
