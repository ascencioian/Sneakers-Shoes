package com.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.project.entity.CartItem;
import com.project.entity.Sneaker;
import com.project.entity.User;
import com.project.repository.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testAddOneCartItem() {
		Sneaker sneaker = entityManager.find(Sneaker.class, "GY0850");
		User user = entityManager.find(User.class, 0000000000000000003);
		
		CartItem newItem = new CartItem();
		newItem.setUser(user);
		newItem.setSneaker(sneaker);
		newItem.setQuantity(1);
		
		CartItem savedCartItem = cartRepo.save(newItem);
		
		assert(savedCartItem.getId() > 0 == true);
	}
	
	@Test
	public void testGetCartItemsByUser() {
		User user = new User();
		user.setId(3);
		
		List<CartItem> cartItems = cartRepo.findByUser(user);
		
		assert(1 == cartItems.size());
	}
}
