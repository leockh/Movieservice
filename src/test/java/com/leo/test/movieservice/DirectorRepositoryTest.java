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
import com.leo.test.movieservice.repository.DirectorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DirectorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void whenFindById_thenReturnMovie() {
    	Director director1 = new Director("Tony","Chan");
        entityManager.persistAndFlush(director1);

        Director found = directorRepository.findById(director1.getId()).orElse(null);
        assertThat(found.getFirstName()).isEqualTo(director1.getFirstName());
        assertThat(found.getLastName()).isEqualTo(director1.getLastName());
    }

   
}
