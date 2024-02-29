package com.onlinebookstore.onlinebookstore.Service;

import java.util.List;

import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Entities.Book;

public interface BookService {
	Book createBook(Book book);
	
	List<Book> getAll();
	
	Book findBookById(Long id);
	
	Book updateBook(Long id,Book book);
	
	String deleteBook(Long id);
	
	String assignCartToBook(Long id, Long prodid);
	
	String orderBook(Customer customer);
	
	List<Cart> orderDetails(Long orderno);
}
