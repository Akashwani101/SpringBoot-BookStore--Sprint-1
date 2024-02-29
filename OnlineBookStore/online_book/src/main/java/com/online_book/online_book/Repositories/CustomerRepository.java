package com.online_store2.online_store2.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.online_store2.online_store2.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("SELECT c FROM Customer c WHERE c.name = :name")
    Optional<Customer> findByName(@Param("name") String name);
}
