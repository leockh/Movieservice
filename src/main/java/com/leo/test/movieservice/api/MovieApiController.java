package com.leo.test.movieservice.api;

import com.leo.test.movieservice.model.Movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.movieserviceOpenAPI30.base-path:/api}")
public class MovieApiController implements MovieApi {

    private final MovieApiDelegate delegate;

    public MovieApiController(@Autowired(required = false) MovieApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new MovieApiDelegate() {});
    }

    @Override
    public MovieApiDelegate getDelegate() {
        return delegate;
    }

}
