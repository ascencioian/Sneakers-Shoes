package com.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartItem;
import com.project.entity.Sneaker;
import com.project.entity.User;
import com.project.repository.CartItemRepository;
import com.project.repository.SneakerRepository;

@Service
public class CartService {

	private static final Logger log = LoggerFactory.getLogger(CartService.class);

	@Autowired
	private CartItemRepository cartRepo;

	public List<CartItem> listCartItems(User user) {
		return cartRepo.findByUser(user);
	}

	// add item to shopping cart
	public void addProduct(User user, Integer quanity, Sneaker s1) {

		Integer addedQuantity = 1;

		CartItem cartItem;

		// create cart item
		cartItem = new CartItem();
		cartItem.setQuantity(addedQuantity);
		cartItem.setUser(user);
		cartItem.setSneaker(s1);
		System.out.println(cartItem);
		cartRepo.save(cartItem);

		// logged saved item
		log.info("addProduct() saved: " + cartItem);

	}

}
