package com.project.repository;

import org.springframework.data.repository.CrudRepository;


import com.project.entity.Sneaker;

public interface SneakerRepository extends CrudRepository<Sneaker,String> {

}
