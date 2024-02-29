package com.onlinebookstore.onlinebookstore.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Repositories.CustomerRepository;
import com.onlinebookstore.onlinebookstore.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCusto(String name){
		return customerRepository.findByName(name);
	}
}