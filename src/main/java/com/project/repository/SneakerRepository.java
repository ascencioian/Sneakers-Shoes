package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Sneaker;

public interface SneakerRepository extends JpaRepository<Sneaker, String> {

}
