package com.onlinebookstore.onlinebookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Service.CustomerService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
@Autowired 
CustomerService customerService;

@PostMapping("/create")
public Customer createCustomer(@RequestBody Customer customer)
{
	return customerService.createCustomer(customer);
}
}