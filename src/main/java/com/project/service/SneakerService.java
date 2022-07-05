package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.entity.Sneaker;

public interface SneakerService {
	// ----------------------------get operation------------

	// read all
	List<Sneaker> getSneakers();

	// get one
	Optional<Sneaker> getSneaker(String sku);

	// get all sorted by release date
	List<Sneaker> getSneakersSorted();

	// ----------------------------post----------------------
	Sneaker createSneaker(Sneaker s1);

	List<Sneaker> createSneakers(List<Sneaker> sneakerList);

	// -------------------------delete-----------------------

	void deleteSneaker(String sku);

	// ----------------------------put-----------------------
}
