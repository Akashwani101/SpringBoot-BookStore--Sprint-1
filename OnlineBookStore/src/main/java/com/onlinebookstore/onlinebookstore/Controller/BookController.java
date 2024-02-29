package com.onlinebookstore.onlinebookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Entities.Book;
import com.onlinebookstore.onlinebookstore.Service.BookService;

@CrossOrigin(origins="http://localhost:4200")
@RestController   //returns data in json format
@RequestMapping("/api/book")         //used to map web request onto specific controller class or controller method
public class BookController {

	@Autowired
	BookService bookService;           
	
	@PostMapping("/add")  //adding record in table
	public Book createBook(@RequestBody Book book)
	{
		return bookService.createBook(book);
	}
	
	@GetMapping("/show")
	public List<Book> getALL()
	{
		return bookService.getAll();
	}
	
   @GetMapping("/find/{id}")
   public Book findById(@PathVariable Long id)
   {
	   return bookService.findBookById(id);
   }
   
   @PutMapping("/update/{id}")
   public Book updateBook(@PathVariable Long id, @RequestBody Book book)
   {
	   return bookService.updateBook(id, book);
   }
   
   @DeleteMapping("/delete/{id}")
   public String deleteBook(@PathVariable Long id)
   {
	   return bookService.deleteBook(id);
   }
   
   @PostMapping("/assign/{cid}/{bid}")
   public String assignCartToBook(@PathVariable Long cid, @PathVariable Long bid)
   {
	   return bookService.assignCartToBook(cid, bid);
   }
   
   @PostMapping("/orderproduct")
   public String orderBook(@RequestBody Customer customer)
   {
	   return bookService.orderBook(customer);
   }
   
   @GetMapping("/displayorder/{orderno}")
   public List<Cart> orderDetails(@PathVariable Long orderno)
   {
	   return bookService.orderDetails(orderno);
   }
}
