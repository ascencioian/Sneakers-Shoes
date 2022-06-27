package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.project.entity.Sneaker;

public interface SneakerRepository extends JpaRepository<Sneaker,String> {


}
