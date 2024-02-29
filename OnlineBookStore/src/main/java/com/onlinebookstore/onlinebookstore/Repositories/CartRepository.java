package com.onlinebookstore.onlinebookstore.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinebookstore.onlinebookstore.Entities.Cart;
import com.onlinebookstore.onlinebookstore.Entities.Customer;
public interface CartRepository extends JpaRepository<Cart, Long> {
			//fetch all carts which belongs to user=id;
		//	@Query(value="select * from cart ct where ct.custid =: id ")
		//	List<Customer> findBy(@Param("custid") int id);
	
		//@Query(value="select * from Cart ct join user_login where ct.id_id = user_login.id and  =: query", nativeQuery=true)
	@Query(value="select customer.name,group_concat(cart.prodid) as productid,customer.orderno,customer.addrs,customer.total_price from cart join customer where cart.orderno_orderno=customer.orderno and customer.phone=: query ", nativeQuery=true)
	Cart findbyOrder(@Param("query") Long phone);
}
