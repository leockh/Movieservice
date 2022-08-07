package com.leo.test.movieservice.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.Service.MovieService;
import com.leo.test.movieservice.api.ApiUtil;
import com.leo.test.movieservice.api.MovieApi;
import com.leo.test.movieservice.exception.AlreadyExistsException;
import com.leo.test.movieservice.exception.NotExistsException;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;
import com.leo.test.movieservice.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
	
	@Autowired
    private MovieRepository movieRepository;
	
	@Autowired
    private DirectorService directorService;
	
	String notExistsExceptionMessage = "Movie with id=%s don't exists";
	
	@Override
	public Movie addMovie(Movie movie) {
		log.debug("Creating {}", movie);
        if (movieRepository.existsByName(movie.getName())) {
            throw new AlreadyExistsException (
                    String.format("Movie with name=%s already exists", movie.getName()));
        }
		
        return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long movieId) {
		log.debug("Deleting movie with id {}", movieId);
        if (!movieRepository.existsById(movieId)) {
            throw new NotExistsException (
                    String.format(notExistsExceptionMessage, movieId));
        }
        movieRepository.deleteById(movieId);
	}

	@Override
	public List<Movie> findMoviesByDirector(Long directorId) {
		return movieRepository.findMoviesByDirectorsId(directorId).orElse(new ArrayList<Movie>());
	}

	@Override
	public List<Movie> findMoviesByRating(Integer rating) {
		return movieRepository.findByRating(rating).orElse(new ArrayList<Movie>());
	}

	@Override
	public Movie getMovieById(Long movieId) {
		return movieRepository.findById(movieId).orElseThrow(
				() -> new NotExistsException (
	                    String.format(notExistsExceptionMessage, movieId)));
	}
	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		Movie updateMovie = movieRepository.findById(movie.getId()).orElseThrow(
				() -> new NotExistsException (
	                    String.format(notExistsExceptionMessage, movie.getId())));
		updateMovie.getDirectors().clear();
		updateMovie.getDirectors()
                .addAll(movie.getDirectors()
                        .stream()
                        .map(d -> {
                            Director newdirector = directorService.getDirectorById(d.getId());
                            newdirector.getMovies().add(updateMovie);
                            return newdirector;
                        }).collect(Collectors.toList()));
		
        return movieRepository.save(updateMovie);
	}
		
	@Override
	public Movie getRating(Long movieId) {
		return this.getMovieById(movieId);
	}
		
	@Override
	public Movie updateRating(Long movieId, Integer rating) {
		Movie updatedMovie = this.getMovieById(movieId);
		updatedMovie.setRating(rating);
		return movieRepository.save(updatedMovie);
	}
		
	@Override
	public Movie deleteRating(Long movieId) {
		return this.updateRating(movieId, 0);
	}

}
