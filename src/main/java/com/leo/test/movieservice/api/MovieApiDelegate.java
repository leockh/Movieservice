package com.leo.test.movieservice.api;

import com.leo.test.movieservice.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link MovieApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface MovieApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /movie : Add a new movie
     * Add a new movie
     *
     * @param movie Create a new movie (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 405)
     * @see MovieApi#addMovie
     */
    default ResponseEntity<Movie> addMovie(Movie movie) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /movie/{movieId} : Deletes a movie
     * delete a movie
     *
     * @param movieId Movie id to delete (required)
     * @return Invalid Movie value (status code 400)
     * @see MovieApi#deleteMovie
     */
    default ResponseEntity<Void> deleteMovie(Long movieId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /movie/{movieId}/rating : Delete movie rating
     * Delete movie rating
     *
     * @param movieId ID of movie to return (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @see MovieApi#deleteRating
     */
    default ResponseEntity<Movie> deleteRating(Long movieId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /movie/findByDirectorId/{directorId} : Finds Movies by director
     * Finds Movies by director
     *
     * @param directorId director value that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     * @see MovieApi#findMoviesByDirector
     */
    default ResponseEntity<List<Movie>> findMoviesByDirector(Long directorId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /movie/findByRating/{rating} : Finds Movies by rating
     * Finds Movies by rating
     *
     * @param rating rating value that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @see MovieApi#findMoviesByRating
     */
    default ResponseEntity<List<Movie>> findMoviesByRating(Integer rating) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /movie : Returns all movies
     * Returns movies
     *
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     * @see MovieApi#getAllMovies
     */
    default ResponseEntity<List<Movie>> getAllMovies() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /movie/{movieId} : Find movie by ID
     * Returns a single movie
     *
     * @param movieId ID of movie to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Movie not found (status code 404)
     * @see MovieApi#getMovieById
     */
    default ResponseEntity<Movie> getMovieById(Long movieId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /movie/{movieId}/rating : Returns movie rating
     * Returns movie rating
     *
     * @param movieId ID of movie to return (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @see MovieApi#getRating
     */
    default ResponseEntity<Movie> getRating(Long movieId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /movie : Update an existing movie
     * Update an existing movie by Id
     *
     * @param movie Update an existent movie (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Movie not found (status code 404)
     *         or Validation exception (status code 405)
     * @see MovieApi#updateMovie
     */
    default ResponseEntity<Movie> updateMovie(Movie movie) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>10</id> <name>approved</name> <rating>7</rating> <description>approved</description> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /movie/{movieId}/rating/{rating} : Provides rating to movie
     * Provides rating to movie
     *
     * @param movieId ID of movie to return (required)
     * @param rating rating value that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @see MovieApi#updateRating
     */
    default ResponseEntity<Movie> updateRating(Long movieId,
        Integer rating) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"approved\", \"rating\" : 7, \"description\" : \"approved\", \"id\" : 10 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
