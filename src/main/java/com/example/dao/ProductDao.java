package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Product;

public interface ProductDao extends JpaRepository<Product,Long>{

}
