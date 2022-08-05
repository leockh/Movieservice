package com.leo.test.movieservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.test.movieservice.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
	
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
	
}
