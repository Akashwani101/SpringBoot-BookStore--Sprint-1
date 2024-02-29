package com.online_store2.online_store2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_store2.online_store2.Entities.Store;
import com.online_store2.online_store2.Service.Storeservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/store")
public class StoreController {

	@Autowired
	Storeservice storeservice;
	
	@GetMapping("/show")
	public List<Store> getAll()
	{
		return storeservice.getAll();
	}
	
	@PostMapping("/create")
	public Store createStore(@RequestBody Store store)
	{
		return storeservice.createStore(store);
	}
}
