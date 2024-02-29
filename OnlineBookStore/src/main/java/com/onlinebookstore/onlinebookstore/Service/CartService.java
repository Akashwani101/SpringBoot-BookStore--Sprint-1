package com.onlinebookstore.onlinebookstore.Service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.onlinebookstore.onlinebookstore.Entities.Cart;


public interface CartService {
	
	Cart createCart(Cart cart);
	
	List<Cart> getAll();
	
	String deleteCart(Long cid);
	
	Cart findbyOrder(Long phone);

}