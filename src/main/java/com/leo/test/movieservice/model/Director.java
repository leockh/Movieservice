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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Table(name="director")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(0)
    private long id;
    
    @Column(name="first_name", nullable=false, length=50)
    @NonNull
    private String firstName;
    
    @Column(name="last_name", nullable=false, length=50)
    @NonNull
    private String lastName;
    
    @ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      },
    	      mappedBy = "directors")
    @JsonIgnore
	private List<Movie> movies = new ArrayList<>();
    
    public Director(long id, String firstName, String lastName) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
    public Director(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
}
