package com.leo.test.movieservice.api;

import com.leo.test.movieservice.model.Director;
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
 * A delegate to be called by the {@link DirectorApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface DirectorApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /director : Add Director
     * Add Director
     *
     * @param director  (optional)
     * @return successful operation (status code 200)
     *         or Invalid input (status code 405)
     * @see DirectorApi#addDirector
     */
    default ResponseEntity<Director> addDirector(Director director) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Tony Lee\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /director/{directorId} : Delete director by ID
     * Delete director by ID
     *
     * @param directorId ID of the director that needs to be deleted (required)
     * @return Invalid ID supplied (status code 400)
     *         or Director not found (status code 404)
     * @see DirectorApi#deleteDirector
     */
    default ResponseEntity<Void> deleteDirector(Long directorId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /director : Returns all director
     * Returns all director
     *
     * @return successful operation (status code 200)
     * @see DirectorApi#getAllDirectors
     */
    default ResponseEntity<List<Director>> getAllDirectors() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Tony Lee\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /director/{directorId} : Find director by ID
     * Find director by ID
     *
     * @param directorId ID of director that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Director not found (status code 404)
     * @see DirectorApi#getDirectorById
     */
    default ResponseEntity<Director> getDirectorById(Long directorId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Tony Lee\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /director : Update Director
     * Update Director
     *
     * @param director  (optional)
     * @return successful operation (status code 200)
     *         or Invalid input (status code 405)
     * @see DirectorApi#updateDirector
     */
    default ResponseEntity<Director> updateDirector(Director director) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Tony Lee\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
