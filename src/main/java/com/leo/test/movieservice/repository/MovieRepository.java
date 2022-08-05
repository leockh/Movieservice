package com.leo.test.movieservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leo.test.movieservice.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	boolean existsByName(String name);
	
	Optional<List<Movie>> findMoviesByDirectorsId(long directorId);
	
	@Query("SELECT m FROM Movie m WHERE m.rating > ?1")
	Optional<List<Movie>> findByRating(Integer rating);
	
}
