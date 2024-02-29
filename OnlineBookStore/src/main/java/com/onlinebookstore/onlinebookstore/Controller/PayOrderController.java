/*package com.onlinebookstore.onlinebookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlinebookstore.onlinebookstore.Entities.Book;
import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Entities.PayOrder;
import com.onlinebookstore.onlinebookstore.Service.PayOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController   //returns data in json format
@RequestMapping("/api/payorder")         //used to map web request onto specific controller class or controller method
public class PayOrderController {

	@Autowired
	PayOrderService payorderService;           
	
	   @PostMapping("/makeorder")
	   public PayOrder payorderBook(@RequestBody PayOrder payorder)
	   {
		   return payorderService.createPayOrder(payorder);
				  
	   }
	   
	   @GetMapping("/displayorder/{orderno}")
	   public PayOrder payorderDetails(Long orderno) 
	   {
		   return payorderService.payorderDetails(orderno);
	   }
	
}
*/