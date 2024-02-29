package com.onlinebookstore.onlinebookstore.Entities;

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
@Table(name="Cart")   //specify the name of table in database

public class Cart {
	@Id //primary key
	 @GeneratedValue(strategy=GenerationType.IDENTITY)  //for auto incrementing 
	private Long id;
	private Long prodid;
	private Long qty;
	private Long total;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JsonIgnoreProperties
	@JsonBackReference
	private Customer orderno;
	
	/*@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JsonIgnoreProperties
	@JsonBackReference
	private UserLogin user_login;
	*/
	@OneToMany(mappedBy="cart")
	@JsonManagedReference
    List<Book> book;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProdid() {
		return prodid;
	}

	public void setProdid(Long prodid) {
		this.prodid = prodid;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Customer getOrderno() {
		return orderno;
	}

	public void setOrderno(Customer orderno) {
		this.orderno = orderno;
	}



	public List<Book> getBook() {
		return book;
	}


	public void setBook(List<Book> book) {
		this.book = book;
	}

	
	
	
}
