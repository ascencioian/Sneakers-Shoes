package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartItem;
import com.project.entity.Sneaker;
import com.project.entity.User;
import com.project.repository.CartItemRepository;
import com.project.repository.SneakerRepository;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartRepo;
	
	//add item to cart
	private SneakerRepository sneakerRepo;
	
	public List<CartItem> listCartItems(User user) {
		return cartRepo.findByUser(user);
	}
	
	//add item to shopping cart 
	public Integer addProduct(User user, Integer quanity, Sneaker s1) {
		Integer addedQuantity = 1;
		
		//create sneaker object
		
		//Optional<Sneaker> optionalsneaker = sneakerRepo.findById(sku);
		
		 //Sneaker sneaker = optionalsneaker.get();
		
		//check if product was added to shopping cart 
		CartItem cartItem; 
		
		//create cart item
		cartItem = new CartItem();
		cartItem.setQuantity(addedQuantity);
		cartItem.setUser(user);
		cartItem.setSneaker(s1);
		System.out.println(cartItem);
		cartRepo.save(cartItem);
		
		return 123456789;
	}
	
}
