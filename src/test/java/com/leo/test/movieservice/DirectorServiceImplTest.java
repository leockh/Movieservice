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

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.model.Director;
import com.leo.test.movieservice.repository.DirectorRepository;

@SpringBootTest
public class DirectorServiceImplTest {

    @TestConfiguration
    static class movieServiceImplTestContextConfiguration {
    }

    @Autowired
    private DirectorService directorService;

    @MockBean
    private DirectorRepository directorRepository;

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    public void whenValidFirstNameAndLastName_thenDirectorShouldBeAdded() {
    	Director director1 = new Director("Johny", "Lam");
        given(directorRepository.save(Mockito.any())).willReturn(director1);
        
        Director added = directorService.addDirector(director1);
        assertThat(added.getFirstName()).isEqualTo(director1.getFirstName());
        assertThat(added.getLastName()).isEqualTo(director1.getLastName());
    }

    
}
