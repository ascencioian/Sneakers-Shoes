package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CartItem;
import com.project.entity.User;

@Repository
public interface CartItemRepository extends JpaRepository <CartItem, Integer> {

	//custom methods
	public List<CartItem> findByUser(User user);
}
