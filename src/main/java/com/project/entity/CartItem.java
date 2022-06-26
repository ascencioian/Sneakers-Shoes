package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//class variables
	@Id
	@Column(name = "cart_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "sku")
	private Sneaker sneaker;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	private int quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sneaker getSneaker() {
		return sneaker;
	}

	public void setSneaker(Sneaker sneaker) {
		this.sneaker = sneaker;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", sneaker=" + sneaker + ", user=" + user + ", quantity=" + quantity + "]";
	}
	
	
}
