package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Sneaker;
import com.project.entity.User;
import com.project.service.SneakerService;
import com.project.service.UserService;

@Controller
public class MainController {

	@Autowired
	private SneakerService repo;

	@GetMapping("/")
	public String root(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		Sneaker s1 = new Sneaker();
		model.addAttribute("s1", s1);
		model.addAttribute("sneaker", repo.getSneakersSorted());

		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}

	@GetMapping("/productX")
	public String showProductX(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "productX";
	}

	@GetMapping("/gallery")
	public String gallery(Model model) {

		model.addAttribute("sneakerSorted", repo.getSneakersSorted());
		model.addAttribute("sneaker", repo.getSneakers());

		return "gallery";
	}

	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}

	// -----------------------------posts

	@PostMapping("/product")
	public String showproductForm(@ModelAttribute("s1") Sneaker s1, Model model) {
		model.addAttribute("s1", s1);
		model.addAttribute("sneaker", repo.getSneakers());
		model.addAttribute("sneakerSorted", repo.getSneakersSorted());
		return "product";
	}

}