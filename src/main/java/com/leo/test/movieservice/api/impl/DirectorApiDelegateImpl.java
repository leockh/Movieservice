package com.leo.test.movieservice.api.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.api.DirectorApiDelegate;
import com.leo.test.movieservice.api.MovieApiDelegate;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;

@Service
public class DirectorApiDelegateImpl implements DirectorApiDelegate {
	
	@Autowired
	DirectorService directorServiceImp;
	
	@Override
	public ResponseEntity<Director> addDirector(Director director) {
		return ResponseEntity.ok().body(directorServiceImp.addDirector(director));
    }
	
	@Override
    public ResponseEntity<Void> deleteDirector(Long directorId) {
		directorServiceImp.deleteDirector(directorId);
		return ResponseEntity.ok().build();
    }
	
	@Override
    public ResponseEntity<List<Director>> getAllDirectors() {
		return ResponseEntity.ok().body(directorServiceImp.getAllDirectors());
    }
	
	@Override
    public ResponseEntity<Director> getDirectorById(Long directorId) {
		return ResponseEntity.ok().body(directorServiceImp.getDirectorById(directorId));
    }
	
	@Override
    public ResponseEntity<Director> updateDirector(Director director) {
		return ResponseEntity.ok().body(directorServiceImp.updateDirector(director));
    }
}
