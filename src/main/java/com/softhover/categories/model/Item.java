package com.softhover.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue
	private int Id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="postBy")
	private String postBy;
	
	@ManyToOne
	private Category category = new Category();

}
