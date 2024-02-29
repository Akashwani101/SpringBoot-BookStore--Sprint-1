package com.online_store2.online_store2.Controller;

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

import com.online_store2.online_store2.Entities.Cart;
import com.online_store2.online_store2.Entities.Customer;
import com.online_store2.online_store2.Entities.Product;
import com.online_store2.online_store2.Service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController   //returns data in json format
@RequestMapping("/api/product")         //used to map web request onto specific controller class or controller method
public class ProductController {

	@Autowired
	ProductService productService;           
	
	@PostMapping("/add")  //adding record in table
	public Product createProduct(@RequestBody Product product)
	{
		return productService.createProduct(product);
	}
	
	@GetMapping("/show")
	public List<Product> getALL()
	{
		return productService.getAll();
	}
	
   @GetMapping("/find/{id}")
   public Product findById(@PathVariable Long id)
   {
	   return productService.findProductById(id);
   }
   
   @PutMapping("/update/{id}")
   public Product updateProduct(@PathVariable Long id, @RequestBody Product product)
   {
	   return productService.updateProduct(id, product);
   }
   
   @DeleteMapping("/delete/{id}")
   public String deleteProduct(@PathVariable Long id)
   {
	   return productService.deleteProduct(id);
   }
   
   @PostMapping("/assign/{sid}/{pid}")
   public String assignStoreToProduct(@PathVariable Long sid, @PathVariable Long pid)
   {
	   return productService.assignStoreToProduct(sid, pid);
   }
   
   @PostMapping("/orderproduct")
   public String orderProduct(@RequestBody Customer customer)
   {
	   return productService.orderProduct(customer);
   }
   
   @GetMapping("/displayorder/{orderno}")
   public List<Cart> orderDetails(@PathVariable Long orderno)
   {
	   return productService.orderDetails(orderno);
   }
}
