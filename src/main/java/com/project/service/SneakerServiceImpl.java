package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.entity.Sneaker;
import com.project.repository.SneakerRepository;

@Service
public class SneakerServiceImpl implements SneakerService{

	@Autowired
	private SneakerRepository repo;
	

	//------------------------------get
	@Override
	public List<Sneaker> getSneakers() {
		// TODO Auto-generated method stub
		 return (List<Sneaker>) repo.findAll();
	}

	//get one
	@Override
	public Optional<Sneaker> getSneaker(String sku) {
		// TODO Auto-generated method stub
		
		return repo.findById(sku);
		
	}
	
	//get all sorted
	@Override
	public List<Sneaker> getSneakersSorted() {
		// TODO Auto-generated method stub
		 return (List<Sneaker>) repo.findAll(Sort.by(Sort.Direction.ASC, "releasedate"));
	}

	//-------------------------------post
	@Override
	public Sneaker createSneaker(Sneaker s1) {
		// TODO Auto-generated method stub
		repo.save(s1);
		
		return s1;
	}
	
	@Override
	public List<Sneaker> createSneakers(List<Sneaker> sneakerList) {
		// TODO Auto-generated method stub
		
		repo.saveAll(sneakerList);
		
		return sneakerList;
	}

	
	//--------------------------------update
	
	
	
	
	//--------------------------------delete
	
	@Override
	public void deleteSneaker(String sku) {
		// TODO Auto-generated method stub
		repo.deleteById(sku);
	}



	

	

}
