package com.leo.test.movieservice.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.leo.test.movieservice.model.Movie;

public interface MovieService {
	
	Movie addMovie(Movie movie);
	
	void deleteMovie(Long movieId);
	
	List<Movie> findMoviesByDirector(Long directorId);
	
	List<Movie> findMoviesByRating(Integer rating);
	
	Movie getMovieById(Long movieId);
	
	List<Movie> getAllMovies();
	 
	Movie updateMovie(Movie movie);
	
	Movie getRating(Long movieId);
	
	Movie updateRating(Long movieId, Integer rating);
	
	Movie deleteRating(Long movieId);
	
}
