package com.leo.test.movieservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.test.movieservice.Service.MovieService;
import com.leo.test.movieservice.model.Movie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
@Validated
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	MovieService movieServiceImp;
	
    @Operation(
        operationId = "addMovie",
        summary = "Add a new movie",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        }
    )
    @PostMapping(
        value = "/movie",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Movie> addMovie(
        @Parameter(name = "Movie", description = "Create a new movie", required = true) @Valid @RequestBody Movie movie
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.addMovie(movie));
    }

    
    @Operation(
        operationId = "deleteMovie",
        summary = "Deletes a movie",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid Movie value")
        }
    )
    @DeleteMapping(
        value = "/movie/{movieId}"
    )
    public ResponseEntity<Void> deleteMovie(
        @Min(1L) @Parameter(name = "movieId", description = "Movie id to delete", required = true) @PathVariable("movieId") Long movieId
    ) {
    	movieServiceImp.deleteMovie(movieId);
		return ResponseEntity.ok().build();
    }
    

    @Operation(
        operationId = "deleteRating",
        summary = "Delete movie rating",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid tag value")
        }
    )
    @DeleteMapping(
        value = "/movie/{movieId}/rating",
        produces = { "application/json" }
    )
    public ResponseEntity<Movie> deleteRating(
        @Min(1L) @Parameter(name = "movieId", description = "ID of movie to return", required = true) @PathVariable("movieId") Long movieId
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.deleteRating(movieId));
    }
    

    @Operation(
        operationId = "findMoviesByDirector",
        summary = "Finds Movies by director",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @GetMapping(
        value = "/movie/findByDirectorId/{directorId}",
        produces = { "application/json" }
    )
    public ResponseEntity<List<Movie>> findMoviesByDirector(
        @Min(0L) @Parameter(name = "directorId", description = "director value that need to be considered for filter", required = true) @PathVariable("directorId") Long directorId
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.findMoviesByDirector(directorId));
    }
    

    @Operation(
        operationId = "findMoviesByRating",
        summary = "Finds Movies by rating",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid tag value")
        }
    )
    @GetMapping(
        value = "/movie/findByRating/{rating}",
        produces = { "application/json" }
    )
    public ResponseEntity<List<Movie>> findMoviesByRating(
        @Min(0) @Parameter(name = "rating", description = "rating value that need to be considered for filter", required = true) @PathVariable("rating") Integer rating
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.findMoviesByRating(rating));
    }
    

    @Operation(
        operationId = "getAllMovies",
        summary = "Returns all movies",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @GetMapping(
        value = "/movie",
        produces = { "application/json" }
    )
    public ResponseEntity<List<Movie>> getAllMovies(
        
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.getAllMovies());
    }

    
    @Operation(
        operationId = "getMovieById",
        summary = "Find movie by ID",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
        }
    )
    @GetMapping(
        value = "/movie/{movieId}",
        produces = { "application/json" }
    )
    public ResponseEntity<Movie> getMovieById(
        @Min(1L) @Parameter(name = "movieId", description = "ID of movie to return", required = true) @PathVariable("movieId") Long movieId
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.getMovieById(movieId));
    }

    
    @Operation(
        operationId = "getRating",
        summary = "Returns movie rating",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid tag value")
        }
    )
    @GetMapping(
        value = "/movie/{movieId}/rating",
        produces = { "application/json" }
    )
    public ResponseEntity<Movie> getRating(
        @Min(1L) @Parameter(name = "movieId", description = "ID of movie to return", required = true) @PathVariable("movieId") Long movieId
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.getRating(movieId));
    }


    @Operation(
        operationId = "updateMovie",
        summary = "Update an existing movie",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @PutMapping(
        value = "/movie",
        produces = { "application/json", "application/xml" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Movie> updateMovie(
        @Parameter(name = "Movie", description = "Update an existent movie", required = true) @Valid @RequestBody Movie movie
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.updateMovie(movie));
    }

    
    @Operation(
        operationId = "updateRating",
        summary = "Provides rating to movie",
        tags = { "movie" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid tag value")
        }
    )
    @PutMapping(
        value = "/movie/{movieId}/rating/{rating}",
        produces = { "application/json" }
    )
    public ResponseEntity<Movie> updateRating(
        @Min(1L) @Parameter(name = "movieId", description = "ID of movie to return", required = true) @PathVariable("movieId") Long movieId,
        @Min(0) @Parameter(name = "rating", description = "rating value that need to be considered for filter", required = true) @PathVariable("rating") Integer rating
    ) {
    	return ResponseEntity.ok().body(movieServiceImp.updateRating(movieId, rating));
    }
}
