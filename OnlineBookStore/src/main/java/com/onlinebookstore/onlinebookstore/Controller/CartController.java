package com.onlinebookstore.onlinebookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Service.CartService;

public class CartController {

	@Autowired
	CartService cartService;   
	 @DeleteMapping("/delete/{id}")
	   public String deleteCart(@PathVariable Long id)
	   {
		   return cartService.deleteCart(id);
	   }
	   
	 @GetMapping("/findbyOrder/{phone}")
	 public Cart findbyOrder(@PathVariable Long phone){
		return cartService.findbyOrder(phone);
		 
	 }
}
