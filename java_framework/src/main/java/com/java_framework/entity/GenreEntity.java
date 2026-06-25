
	
	package com.java_framework.entity;

	import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

	@Entity
	@Table(name = "genres")
	@Getter
	@Setter
	public class GenreEntity {
	    
		@Id
	    private Integer id;

	    private String name;
	}
	
	
	
	
