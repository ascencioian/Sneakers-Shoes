package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.entity.CartItem;
import com.project.entity.User;
import com.project.service.CartService;
import com.project.service.UserService;

@Controller
public class CartController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/cart")
	public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication) {
		
		User username = userservice.getCurrentlyLoggedInUser(authentication);
		
		System.out.println("from cart controller" + username);
		
		// User u = userservice.findByEmail(username);
		
		List <CartItem> cartItems =cartservice.listCartItems(username);
		
		System.out.println("from cart controller" + cartItems);
		
		 model.addAttribute( "cartItems", cartItems);
		
		
		return "cart";
	}
}
