package com.online_store2.online_store2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_store2.online_store2.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
