package com.leo.test.movieservice.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.test.movieservice.Service.MovieService;
import com.leo.test.movieservice.api.ApiUtil;
import com.leo.test.movieservice.api.MovieApiDelegate;
import com.leo.test.movieservice.model.Movie;

@Service
public class MovieApiDelegateImpl implements MovieApiDelegate {

	@Autowired
	MovieService movieServiceImp;

	@Override
	public ResponseEntity<Movie> addMovie(Movie movie) {
		return ResponseEntity.ok().body(movieServiceImp.addMovie(movie));
	}

	@Override
	public ResponseEntity<Void> deleteMovie(Long movieId) {
		movieServiceImp.deleteMovie(movieId);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok().body(movieServiceImp.getAllMovies());
	}

	@Override
	public ResponseEntity<List<Movie>> findMoviesByDirector(Long directorId) {
		return ResponseEntity.ok().body(movieServiceImp.findMoviesByDirector(directorId));
	}

	@Override
	public ResponseEntity<List<Movie>> findMoviesByRating(Integer rating) {
		return ResponseEntity.ok().body(movieServiceImp.findMoviesByRating(rating));
	}

	@Override
	public ResponseEntity<Movie> getMovieById(Long movieId) {
		return ResponseEntity.ok().body(movieServiceImp.getMovieById(movieId));
	}

	@Override
	public ResponseEntity<Movie> updateMovie(Movie movie) {
		return ResponseEntity.ok().body(movieServiceImp.updateMovie(movie));
	}
	
	@Override
	public ResponseEntity<Movie> getRating(Long movieId) {
		return ResponseEntity.ok().body(movieServiceImp.getRating(movieId));
    }
	
	@Override
	public ResponseEntity<Movie> updateRating(Long movieId, Integer rating) {
		return ResponseEntity.ok().body(movieServiceImp.updateRating(movieId, rating));
	}
	
	@Override
	public ResponseEntity<Movie> deleteRating(Long movieId) {
		return ResponseEntity.ok().body(movieServiceImp.deleteRating(movieId));
    }
	
}
