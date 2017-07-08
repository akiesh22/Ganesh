package com.softhover.categories.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Item> item = new ArrayList<>();

}
