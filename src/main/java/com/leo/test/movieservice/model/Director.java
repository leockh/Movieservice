package com.leo.test.movieservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="director")

public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(0)
    private long id;
    
    @Column(name="first_name", nullable=false, length=50)
    private String firstName;
    
    @Column(name="last_name", nullable=false, length=50)
    private String lastName;
    
    @ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      },
    	      mappedBy = "directors")
    @JsonIgnore
	private List<Movie> movies = new ArrayList<>();
    	    
    protected Director() {}
    
    public Director(long id, String firstName, String lastName) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
    public Director(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setMovies(List<Movie> movies) {
    	this.movies = movies;
    }
    
    public List<Movie> getMovies() {
    	return movies;
    }
}
