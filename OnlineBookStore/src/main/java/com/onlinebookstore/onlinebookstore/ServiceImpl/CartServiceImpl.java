package com.onlinebookstore.onlinebookstore.ServiceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.onlinebookstore.Entities.Book;
import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Repositories.CartRepository;
import com.onlinebookstore.onlinebookstore.Service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart createCart(Cart cart) {
	return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	@Override
	public String deleteCart(Long cid) {
		Cart p=cartRepository.findById(cid).get();
		cartRepository.deleteById(cid);
		return "cart has been deleted!";
	}

	@Override
	public Cart findbyOrder(Long phone) {
		return cartRepository.findbyOrder(phone);
	}

	
}