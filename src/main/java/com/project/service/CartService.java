package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CartItem;
import com.project.entity.User;
import com.project.repository.CartItemRepository;

@Service
public class CartService {

	@Autowired
	private CartItemRepository cartRepo;
	
	public List<CartItem> listCartItems(User user) {
		return cartRepo.findByUser(user);
	}
}
