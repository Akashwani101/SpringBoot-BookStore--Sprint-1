package com.online_store2.online_store2.Service;

import java.util.List;

import com.online_store2.online_store2.Entities.Cart;
import com.online_store2.online_store2.Entities.Customer;
import com.online_store2.online_store2.Entities.Product;

public interface ProductService {
Product createProduct(Product product);
List<Product> getAll();
Product findProductById(Long id);
Product updateProduct(Long id,Product product);
String deleteProduct(Long id);
String assignStoreToProduct(Long storeid, Long prodid);
String orderProduct(Customer customer);
List<Cart> orderDetails(Long orderno);
}
