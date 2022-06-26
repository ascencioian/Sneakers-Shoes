package com.project.controller;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private UserService userRepo;
	
    @GetMapping("/")
    public String root(Model model) {
    	User user = new User();
	    model.addAttribute("user", user);
	    Sneaker s1 = new Sneaker();
        model.addAttribute("s1", s1);
		model.addAttribute("something", "this is something");
		model.addAttribute( "sneaker", repo.getSneakers());
//System.out.println(user);
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
        //User user = new User();
        //model.addAttribute("user", user);
	  model.addAttribute( "sneaker", repo.getSneakers());
         
        return "gallery";
    }
    
//    @GetMapping("/cart")
//    public String cart(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//         
//         
//        return "cart";
//    }
  
    //-----------------------------posts 
    
    @PostMapping("/product")
	  public String showproductForm(@ModelAttribute("s1") Sneaker s1, Model model) {
		  model.addAttribute("s1", s1);
		  System.out.println(s1);
		  model.addAttribute( "sneaker", repo.getSneakers());
		 
	      return "product";
	  }
    
    @PostMapping("/addToCart")
	  public String addToCart(@ModelAttribute("s1") Sneaker s1, Model model) {
    	
    	//dont know how to pass this 
    	String emailtest = "ian.ascencio.mancia@gmail.com";
    	// Create student object
    	User u1 = userRepo.findByEmail(emailtest);
    	
    	// create course list
    	List<Sneaker> sneakersInCart = u1.getuSneakers();
    	System.out.println(sneakersInCart);
    	
    	//add to relationship table
    	sneakersInCart.add(s1);
    	
    	//add model attributes 
    	model.addAttribute( "sneakersInCart", sneakersInCart);
    	//create the shoe object
    	//Optional<Sneaker> sneaker = repo.getSneaker(sku);
    	
    	
    	
    	
    	//set new attribute for user
    	u1.setuSneakers(sneakersInCart);
		 
	      return "cart";
	  }
    
    
}