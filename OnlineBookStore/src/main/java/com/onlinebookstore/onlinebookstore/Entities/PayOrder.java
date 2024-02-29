/*package com.onlinebookstore.onlinebookstore.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity   //for creating table
@Table(name="pay_order")   //specify the name of table in database

public class PayOrder {
	//cols- orderid,cartid,cust_id,paymentmode
	@Id //primary key
	 @GeneratedValue(strategy=GenerationType.IDENTITY)  //for auto incrementing 
	private Long orderid;
	private String paymode;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JsonIgnoreProperties
	@JsonBackReference
	private Customer orderno;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonBackReference
	private Cart cart;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public Customer getCustomer() {
		return orderno;
	}

	public void setCustomer(Customer orderno) {
		this.orderno = orderno;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
}
*/