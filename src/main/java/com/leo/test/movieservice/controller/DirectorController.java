package com.leo.test.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.model.Director;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
@Validated
@RequestMapping("/api")
public class DirectorController {
	
	@Autowired
	DirectorService directorServiceImp;
	
    @Operation(
        operationId = "addDirector",
        summary = "Add Director",
        tags = { "director" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Director.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        }
    )
    @PostMapping(
        value = "/director",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Director> addDirector(
        @Parameter(name = "Director", description = "") @Valid @RequestBody(required = false) Director director
    ) {
    	return ResponseEntity.ok().body(directorServiceImp.addDirector(director));
    }


    @Operation(
        operationId = "deleteDirector",
        summary = "Delete director by ID",
        tags = { "director" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Director not found")
        }
    )
    @DeleteMapping(
        value = "/director/{directorId}"
    )
    public ResponseEntity<Void> deleteDirector(
        @Parameter(name = "directorId", description = "ID of the director that needs to be deleted", required = true) @PathVariable("directorId") Long directorId
    ) {
    	directorServiceImp.deleteDirector(directorId);
		return ResponseEntity.ok().build();
    }


    @Operation(
        operationId = "getAllDirectors",
        summary = "Returns all director",
        tags = { "director" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Director.class))
            })
        }
    )
    @GetMapping(
        value = "/director",
        produces = { "application/json" }
    )
    public ResponseEntity<List<Director>> getAllDirectors(
        
    ) {
    	return ResponseEntity.ok().body(directorServiceImp.getAllDirectors());
    }


    @Operation(
        operationId = "getDirectorById",
        summary = "Find director by ID",
        tags = { "director" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Director.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Director not found")
        }
    )
    @GetMapping(
        value = "/director/{directorId}",
        produces = { "application/json" }
    )
    public ResponseEntity<Director> getDirectorById(
        @Parameter(name = "directorId", description = "ID of director that needs to be fetched", required = true) @PathVariable("directorId") Long directorId
    ) {
    	return ResponseEntity.ok().body(directorServiceImp.getDirectorById(directorId));
    }


    @Operation(
        operationId = "updateDirector",
        summary = "Update Director",
        tags = { "director" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Director.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        }
    )
    @PutMapping(
        value = "/director",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Director> updateDirector(
        @Parameter(name = "Director", description = "") @Valid @RequestBody(required = false) Director director
    ) {
    	return ResponseEntity.ok().body(directorServiceImp.updateDirector(director));
    }
}
