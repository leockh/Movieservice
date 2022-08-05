package com.leo.test.movieservice.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(0)
    private long id;
    
    @Column(name="name", nullable=false, length=100)
    @NotNull
    private String name;
    
    @Column(name="rating", nullable=false, columnDefinition = "integer default 0")
    @Min(0)
    @NotNull
    private int rating;
    
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.MERGE
    })
	@JoinTable(name = "movie_director",
	      joinColumns = { @JoinColumn(name = "movie_id") },
	      inverseJoinColumns = { @JoinColumn(name = "director_id") },
	      uniqueConstraints = {@UniqueConstraint(
	              columnNames = {"movie_id", "director_id"})})
    private List<Director> directors = new ArrayList<>();
    
    public Movie(long id, String name, int rating, List<Director> directors) {
    	this.id = id;
        this.name = name;
        this.rating = rating;
        this.directors = directors;
    }
    
    public Movie(String name, int rating, List<Director> directors) {
        this.name = name;
        this.rating = rating;
        this.directors = directors;
    }
    
    public Movie(long id, String name, int rating) {
    	this.id = id;
        this.name = name;
        this.rating = rating;
    }
    
    protected Movie() {}
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setRating(int rating) {
    	this.rating = rating;
    }
    
    public int getRating() {
    	return rating;
    }
    
    public void setDirectors(List<Director> directors) {
    	this.directors = directors;
    }
    
    public List<Director> getDirectors() {
    	return directors;
    }

}
