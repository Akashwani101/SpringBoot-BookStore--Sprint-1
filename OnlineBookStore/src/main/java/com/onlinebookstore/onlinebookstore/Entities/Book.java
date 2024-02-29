package com.onlinebookstore.onlinebookstore.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity   //for creating table
@Table(name="Book")   //specify the name of table in database
public class Book {
		 
	@Id //primary key
	 @GeneratedValue(strategy=GenerationType.IDENTITY)  //for auto incrementing   
	    private Long Id;
		private String name;
		private Long stk;
		private String publication;
		private String description;
		private Long price;
		private String link;
		
		   
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JsonBackReference
		private Cart cart;
		   

	 public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStk() {
		return stk;
	}

	public void setStk(Long stk) {
		this.stk = stk;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPublication() {

		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDescription() {

		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
