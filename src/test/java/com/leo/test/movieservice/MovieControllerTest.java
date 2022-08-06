package com.leo.test.movieservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.leo.test.movieservice.Service.MovieService;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.model.Movie;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService service;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void whenPostMovie_thenCreateMovie() throws Exception {
        Movie movie1 = new Movie("Batman",5,null);
        given(service.addMovie(Mockito.any())).willReturn(movie1);

        mvc.perform(post("/api/movie").contentType(MediaType.APPLICATION_JSON)
        	.content(JsonMapperUtil.toJson(movie1)))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.name", is("Batman")))
        	.andExpect(jsonPath("$.rating", is(5)));
        verify(service, VerificationModeFactory.times(1)).addMovie(Mockito.any());
        reset(service);
    }

    @Test
    void whenGetMovies_thenReturnJsonArray() throws Exception {
    	Movie movie1 = new Movie(Long.valueOf(1),"Batman",5);
    	Movie movie2 = new Movie(Long.valueOf(2),"Superman",7);
    	Movie movie3 = new Movie(Long.valueOf(3),"Ironman",10);

        List<Movie> allMovies = Arrays.asList(movie1, movie2, movie3);

        given(service.getAllMovies()).willReturn(allMovies);

        mvc.perform(get("/api/movie").contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasSize(3)))
        	.andExpect(jsonPath("$[0].name", is(movie1.getName())))
        	.andExpect(jsonPath("$[1].name", is(movie2.getName())))
            .andExpect(jsonPath("$[2].name", is(movie3.getName())));
        verify(service, VerificationModeFactory.times(1)).getAllMovies();
        reset(service);
    }
    
    @Test
    void whenFindMoviesByDirectorsId_thenReturnJsonArray() throws Exception {
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

        given(service.findMoviesByDirector(Long.valueOf(director1.getId()))).willReturn(allMovies);

        mvc.perform(get("/api/movie/findByDirectorId/"+String.valueOf(director1.getId()))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasSize(3)))
        	.andExpect(jsonPath("$[0].name", is(movie1.getName())))
        	.andExpect(jsonPath("$[1].name", is(movie2.getName())))
            .andExpect(jsonPath("$[2].name", is(movie3.getName())));
        verify(service, VerificationModeFactory.times(1)).findMoviesByDirector(director1.getId());
        reset(service);
    }
    
    @Test
    void whenFindMoviesByRating_thenReturnJsonArray() throws Exception {
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

        given(service.findMoviesByRating(rating)).willReturn(allMovies);

        mvc.perform(get("/api/movie/findByRating/"+String.valueOf(rating))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
        	.andExpect(jsonPath("$[0].name", is(movie1.getName())))
        	.andExpect(jsonPath("$[1].name", is(movie2.getName())))
        	.andExpect(jsonPath("$[2].name", is(movie3.getName())));
        verify(service, VerificationModeFactory.times(1)).findMoviesByRating(rating);
        reset(service);
    }
    
    @Test
    void whenFindMoviesByDirectorsId_thenReturnBlankJsonArray() throws Exception {
        List<Movie> allMovies = new ArrayList<>();
        long directorId = 1;
        given(service.findMoviesByDirector(Long.valueOf(directorId))).willReturn(allMovies);

        mvc.perform(get("/api/movie/findByDirectorId/"+String.valueOf(directorId))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status()
        	.isOk())
        	.andExpect(jsonPath("$", hasSize(0)) );
        verify(service, VerificationModeFactory.times(1)).findMoviesByDirector(directorId);
        reset(service);
    }
    
    @Test
    void whenFindMoviesByRating_thenReturnBlankJsonArray() throws Exception {
        List<Movie> allMovies = new ArrayList<>();
        int rating = 4;
        given(service.findMoviesByRating(rating)).willReturn(allMovies);

        mvc.perform(get("/api/movie/findByRating/"+String.valueOf(rating))
        	.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$", hasSize(0)));
        verify(service, VerificationModeFactory.times(1)).findMoviesByRating(rating);
        reset(service);
    }
    
    @Test
    void whenFindMoviesByNagetiveDirectorsId_thenThrowException() throws Exception {
    	Assertions
	        .assertThatThrownBy(
	            () -> mvc.perform(get("/api/movie/findByDirectorId/-1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError()))
	        .hasCauseInstanceOf(RuntimeException.class).hasMessageContaining("findMoviesByDirector.directorId: must be greater than or equal to 0");
    }
    
    @Test
    void whenFindMoviesByNagetiveRating_thenThrowException() throws Exception {
    	Assertions
        .assertThatThrownBy(
            () -> mvc.perform(get("/api/movie/findByRating/-1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError()))
        .hasCauseInstanceOf(RuntimeException.class).hasMessageContaining("findMoviesByRating.rating: must be greater than or equal to 0");
    }

}