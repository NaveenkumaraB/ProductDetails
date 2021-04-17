package com.example.entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long Id;
	@Column(name="Name")
	String name;
	@Column(name="Description")
	String description;
	@Column(name="price")
	Integer price;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}