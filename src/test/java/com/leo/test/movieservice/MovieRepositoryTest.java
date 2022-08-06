package com.leo.test.movieservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;
import com.leo.test.movieservice.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void whenFindById_thenReturnMovie() {
    	Movie movie1 = new Movie("Batman",5,null);
        entityManager.persistAndFlush(movie1);

        Movie found = movieRepository.findById(movie1.getId()).orElse(null);
        assertThat(found.getName()).isEqualTo(movie1.getName());
    }

    @Test
    void whenNotExistId_thenReturnNull() {
        Movie fromDb = movieRepository.findById(-11l).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenListtOfMovies_whenFindAll_thenReturnAllMovies() {
    	Director director1 = new Director("Tony","Lee");
    	Director director2 = new Director("Jacky","Chan");
    	
    	entityManager.persist(director1);
        entityManager.persist(director2);
        entityManager.flush();
        
    	List<Director> directors1 = new ArrayList();
    	directors1.add(director1);
    	directors1.add(director2);
    	
    	List<Director> directors2 = new ArrayList();
    	directors2.add(director1);
    	
    	Movie movie1 = new Movie("Batman",5,directors1);
    	Movie movie2 = new Movie("Superman",7,null);
    	Movie movie3 = new Movie("Ironman",10,directors2);
    	
        entityManager.persist(movie1);
        entityManager.persist(movie2);
        entityManager.persist(movie3);
        entityManager.flush();

        List<Movie> movies = movieRepository.findMoviesByDirectorsId(director1.getId()).orElse(new ArrayList<Movie>());

        assertThat(movies).hasSize(2).extracting(Movie::getName).containsOnly(movie1.getName(), movie3.getName());
    }
}
