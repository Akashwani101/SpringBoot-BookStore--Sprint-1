/*package com.onlinebookstore.onlinebookstore.ServiceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.onlinebookstore.Entities.PayOrder;
import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
import com.onlinebookstore.onlinebookstore.Repositories.PayOrderRepository;
import com.onlinebookstore.onlinebookstore.Repositories.CustomerRepository;
import com.onlinebookstore.onlinebookstore.Service.PayOrderService;

@Service
public class PayOrderServiceImpl implements PayOrderService{

	@Autowired
	PayOrderRepository payorderRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public PayOrder createPayOrder(PayOrder payorder) {
		return payorderRepository.save(payorder);
	}

	@Override
	public PayOrder payorderDetails(Long orderid) {
		return payorderRepository.getById(orderid);

	}


	
}
*/