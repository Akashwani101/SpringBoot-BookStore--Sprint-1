package com.onlinebookstore.onlinebookstore.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Entities.Book;
import com.onlinebookstore.onlinebookstore.Entities.BookException;
import com.onlinebookstore.onlinebookstore.Repositories.CartRepository;
import com.onlinebookstore.onlinebookstore.Repositories.CustomerRepository;
import com.onlinebookstore.onlinebookstore.Repositories.BookRepository;
import com.onlinebookstore.onlinebookstore.Service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	CustomerRepository customerRepository;

	@Override
	public Book createBook(Book book) {   //adding recording into our table
	
		return	bookRepository.save(book);
	
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Book p=bookRepository.findById(id).get();
		p.setName(book.getName());
		p.setStk(book.getStk());
		p.setPrice(book.getPrice());
		return bookRepository.save(p);
	}

	@Override
	public String deleteBook(Long id) {
		
		Book p=bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		return "Your record has been deleted!";
		
	
		}

	@Override
	public String assignCartToBook(Long id, Long prodid) {
	
		Cart cart=cartRepository.findById(id).get();
		Book p=bookRepository.findById(prodid).get();
		p.setCart(cart);
		bookRepository.save(p);
		
		
		/*List<Book> products=new ArrayList<>();
		products.add(p);
		store.setBook(products);
		*/
		
		return "Cart is assigned";
		
	}

	@Override
	public String orderBook(Customer customer) {
		List<Cart> cart=customer.getCart();
		Double sum=0.00;
		
		for(Cart i:cart)
		{
			Book p=bookRepository.findById(i.getProdid()).get();
		
			try
			{
				if(i.getQty()>p.getStk())
					throw new BookException("Out of stock");
			}
			catch(BookException e)
			{
				return p.getName()+" is "+e.getMessage();
			}
			i.setTotal(i.getQty()*p.getPrice());
			i.setOrderno(customer);
		
			cartRepository.save(i);
			sum=sum+i.getTotal();  
			p.setStk(p.getStk()-i.getQty());
			bookRepository.save(p);
		
		}

		
		customer.setTotalPrice(sum);
		customerRepository.save(customer);
	
		return "your order has been placed successfully";
		
	}
	
	@Override
	public List<Cart> orderDetails(Long orderno)
	{
		Customer customer=customerRepository.findById(orderno).get();
	List<Cart> cart=customer.getCart();		
		return cart;
	}

}
