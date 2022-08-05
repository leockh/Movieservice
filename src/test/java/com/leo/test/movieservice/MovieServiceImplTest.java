package com.leo.test.movieservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.leo.test.movieservice.Service.MovieService;
import com.leo.test.movieservice.Service.Impl.MovieServiceImpl;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;
import com.leo.test.movieservice.repository.MovieRepository;

@SpringBootTest
public class MovieServiceImplTest {

    @TestConfiguration
    static class movieServiceImplTestContextConfiguration {
    }

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    public void whenValidNameAndRating_thenMovieShouldBeAdded() {
    	Movie movie1 = new Movie("Batman",5,null);
        Mockito.when(movieRepository.save(movie1)).thenReturn(movie1);
        
        Movie added = movieService.addMovie(movie1);
        assertThat(added.getName()).isEqualTo(movie1.getName());
        assertThat(added.getRating()).isEqualTo(movie1.getRating());
    }

    @Test
    public void whenFindMoviesByDirectorsId_thenReturnJsonArray() throws Exception {
    	Director director1 = new Director(Long.valueOf(1),"Tony","Lee");
    	Director director2 = new Director(Long.valueOf(3),"Jacky","Chan");
        
    	List<Director> directors1 = new ArrayList();
    	directors1.add(director1);
    	directors1.add(director2);
    	
    	List<Director> directors2 = new ArrayList();
    	directors2.add(director1);
    	
    	Movie movie1 = new Movie(Long.valueOf(1),"Batman",5,directors1);
    	Movie movie2 = new Movie(Long.valueOf(2),"Superman",7,directors1);
    	Movie movie3 = new Movie(Long.valueOf(3),"Ironman",10,directors1);
    	
        List<Movie> allMovies = Arrays.asList(movie1, movie2, movie3);

        given(movieRepository.findMoviesByDirectorsId(director1.getId())).willReturn(Optional.of(allMovies));
        
        List<Movie> found = movieService.findMoviesByDirector(director1.getId());
        assertThat(found.size()).isEqualTo(allMovies.size());
        assertThat(found.get(0).getName()).isEqualTo(found.get(0).getName());
        assertThat(found.get(0).getRating()).isEqualTo(found.get(0).getRating());
        assertThat(found.get(1).getName()).isEqualTo(found.get(1).getName());
        assertThat(found.get(1).getRating()).isEqualTo(found.get(1).getRating());
        assertThat(found.get(2).getName()).isEqualTo(found.get(2).getName());
        assertThat(found.get(2).getRating()).isEqualTo(found.get(2).getRating());
    }
    
    @Test
    public void whenFindMoviesByRating_thenReturnJsonArray() throws Exception {
    	Director director1 = new Director(Long.valueOf(1),"Tony","Lee");
    	Director director2 = new Director(Long.valueOf(3),"Jacky","Chan");
        
    	List<Director> directors1 = new ArrayList();
    	directors1.add(director1);
    	directors1.add(director2);
    	
    	List<Director> directors2 = new ArrayList();
    	directors2.add(director1);
    	
    	Movie movie1 = new Movie(Long.valueOf(1),"Batman",5,directors1);
    	Movie movie2 = new Movie(Long.valueOf(2),"Superman",7,directors1);
    	Movie movie3 = new Movie(Long.valueOf(3),"Ironman",10,directors1);
    	
        List<Movie> allMovies = Arrays.asList(movie1, movie2, movie3);
        int rating = 4;

        given(movieRepository.findByRating(rating)).willReturn(Optional.of(allMovies));

        List<Movie> found = movieService.findMoviesByRating(rating);
        assertThat(found.size()).isEqualTo(allMovies.size());
        assertThat(found.get(0).getName()).isEqualTo(found.get(0).getName());
        assertThat(found.get(0).getRating()).isEqualTo(found.get(0).getRating());
        assertThat(found.get(1).getName()).isEqualTo(found.get(1).getName());
        assertThat(found.get(1).getRating()).isEqualTo(found.get(1).getRating());
        assertThat(found.get(2).getName()).isEqualTo(found.get(2).getName());
        assertThat(found.get(2).getRating()).isEqualTo(found.get(2).getRating());
    }
    
    @Test
    public void whenFindMoviesByDirectorsId_thenReturnBlankJsonArray() throws Exception {
        List<Movie> allMovies = new ArrayList<>();
        long directorId = 1;
        given(movieRepository.findMoviesByDirectorsId(Long.valueOf(directorId))).willReturn(Optional.of(allMovies));

        List<Movie> found = movieService.findMoviesByDirector(directorId);
        assertThat(found.size()).isEqualTo(allMovies.size());
    }
    
    @Test
    public void whenFindMoviesByRating_thenReturnBlankJsonArray() throws Exception {
        List<Movie> allMovies = new ArrayList<>();
        int rating = 4;
        given(movieRepository.findByRating(rating)).willReturn(Optional.of(allMovies));

        List<Movie> found = movieService.findMoviesByRating(rating);
        assertThat(found.size()).isEqualTo(allMovies.size());
    }
}
