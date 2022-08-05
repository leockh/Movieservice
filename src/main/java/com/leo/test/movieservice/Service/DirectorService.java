package com.leo.test.movieservice.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;

public interface DirectorService {
	
	Director addDirector(Director director);
	
	void deleteDirector(Long directorId);
	
	List<Director> getAllDirectors();
	
	Director getDirectorById(Long directorId);
	
	Director updateDirector(Director director);
    
}
