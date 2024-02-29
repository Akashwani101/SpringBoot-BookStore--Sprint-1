package com.online_store2.online_store2.Service;

import java.util.List;

import com.online_store2.online_store2.Entities.Store;

public interface Storeservice {
Store createStore(Store store);
List<Store> getAll();
}
