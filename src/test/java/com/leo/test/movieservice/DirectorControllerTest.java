package com.leo.test.movieservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.leo.test.movieservice.Service.DirectorService;
import com.leo.test.movieservice.model.Director;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DirectorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DirectorService service;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void whenPostDirector_thenCreateDirector() throws Exception {
        Director director1 = new Director("Leo","Cheung");
        given(service.addDirector(Mockito.any())).willReturn(director1);

        mvc.perform(post("/api/director").contentType(MediaType.APPLICATION_JSON)
        	.content(JsonMapperUtil.toJson(director1)))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.firstName", is("Leo")))
        	.andExpect(jsonPath("$.lastName", is("Cheung")));
        verify(service, VerificationModeFactory.times(1)).addDirector(Mockito.any());
        reset(service);
    }

}