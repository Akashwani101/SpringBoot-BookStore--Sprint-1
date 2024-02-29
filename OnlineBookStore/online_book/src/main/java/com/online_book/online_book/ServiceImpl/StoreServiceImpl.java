package com.online_store2.online_store2.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_store2.online_store2.Entities.Store;
import com.online_store2.online_store2.Repositories.StoreRepository;
import com.online_store2.online_store2.Service.Storeservice;

@Service
public class StoreServiceImpl implements Storeservice{

	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public Store createStore(Store store) {
	return storeRepository.save(store);
	}

	@Override
	public List<Store> getAll() {
		return storeRepository.findAll();
	}

}
