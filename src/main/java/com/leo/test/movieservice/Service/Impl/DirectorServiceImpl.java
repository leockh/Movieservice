package com.leo.test.movieservice.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.exception.AlreadyExistsException;
import com.leo.test.movieservice.exception.NotExistsException;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DirectorServiceImpl.class);
	
	@Autowired
    private DirectorRepository directorRepository;
	
	@Override
	public Director addDirector(Director director) {
		LOGGER.debug("Creating {}", director);
        if (directorRepository.existsByFirstNameAndLastName(director.getFirstName(), director.getLastName())) {
            throw new AlreadyExistsException (
                    String.format("Director with name=%s %s already exists", director.getFirstName(), director.getLastName()));
        }
        return directorRepository.save(new Director(director.getFirstName(), director.getLastName()));
    }
	
	@Override
    public void deleteDirector(Long directorId) {
		LOGGER.debug("Deleting movie with id {}", directorId);
        Director director = directorRepository.findById(directorId).orElseThrow(
				() -> new NotExistsException (String.format("Director with id=%s don't exists", directorId)));
        if(director.getMovies().size() > 0) {
        	throw new AlreadyExistsException (
                    String.format("Director with name=%s %s relate to movie(s)", director.getFirstName(), director.getLastName()));
        }
        directorRepository.deleteById(directorId);
    }
	
	@Override
    public List<Director> getAllDirectors() {
		return directorRepository.findAll();
    }
	
	@Override
    public Director getDirectorById(Long directorId) {
		return directorRepository.findById(directorId).orElseThrow(
				() -> new NotExistsException (
	                    String.format("Director with id=%s don't exists", directorId)));
    }
	
	@Override
    public Director updateDirector(Director director) {
		Director updatedDirector = directorRepository.findById(director.getId()).orElseThrow(
				() -> new NotExistsException (
	                    String.format("Director with id=%s don't exists", director.getId())));
		updatedDirector.setFirstName(director.getFirstName());
		updatedDirector.setLastName(director.getLastName());
		return directorRepository.save(updatedDirector);
    }

}
