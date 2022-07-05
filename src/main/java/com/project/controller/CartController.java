package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.CartItem;
import com.project.entity.Sneaker;
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

		List<CartItem> cartItems = cartservice.listCartItems(username);

		model.addAttribute("cartItems", cartItems);

		return "cart";
	}

	@PostMapping("/cart")
	public String addShoppingCart(@ModelAttribute("s1") Sneaker s1, Model model,
			@AuthenticationPrincipal Authentication authentication) {

		User username = userservice.getCurrentlyLoggedInUser(authentication);

		String sku = s1.getSku();

		cartservice.addProduct(username, 1, s1);

		List<CartItem> cartItems = cartservice.listCartItems(username);

		model.addAttribute("cartItems", cartItems);

		return "cart";
	}
}
