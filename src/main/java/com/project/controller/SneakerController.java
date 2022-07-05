package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Sneaker;
import com.project.repository.SneakerRepository;
import com.project.service.SneakerService;

@RestController
public class SneakerController {

	@Autowired
	private SneakerService repo;

	// -----------------------------------get

	@GetMapping("/sneakers")
	public List<Sneaker> getSneakers() {
		System.out.println("getSneakers called");

		return repo.getSneakers();
	}

	@GetMapping("/sneaker/{sku}")
	public Optional<Sneaker> getSneaker(@PathVariable("sku") String sku) {

		System.out.println("getSneaker called");
		return repo.getSneaker(sku);

	}

	// -----------------------------------post
	@PostMapping("/sneaker")
	public Sneaker createSneaker(@RequestBody Sneaker s1) {
		System.out.println("createSneaker called");
		return repo.createSneaker(s1);

	}

	@PostMapping(path = "/sneakers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Sneaker> createSneakers(@RequestBody List<Sneaker> sneakerList) {
		System.out.println("createSneakers called");
		return repo.createSneakers(sneakerList);

	}

	// ------------------------------------delete
	@DeleteMapping("/sneaker/{sku}")
	public void deleteSneaker(@PathVariable("sku") String sku) {

		System.out.println("deleteSneaker called");
		repo.deleteSneaker(sku);
	}

	// -------------------------------------put
}
