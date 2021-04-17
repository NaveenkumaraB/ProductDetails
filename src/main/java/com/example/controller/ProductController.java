package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProductDao;
import com.example.entity.Product;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired(required = false)
	public ProductDao productDao;

	ProductController(ProductDao productDao)
	{
		this.productDao=productDao;
	}
	@PostMapping(value = "/save")
	public String save(@RequestBody Product product) {
		Product res = productDao.save(product);
		return res.getId().toString();
	}

	@GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		Iterable<Product> result = productDao.findAll();
		return (List<Product>) result;
	}
	
	@GetMapping(value = "product/{id}")
	public Optional<Product> getProductByid(@PathVariable Long id) {
		Optional<Product> result = productDao.findById(id);
		return result;
	}
	
	  @PutMapping("/product/{id}")
	  Optional<Object> replaceProduct(@RequestBody Product product, @PathVariable Long id) {
	    
	    return productDao.findById(id)
	      .map(existProduct -> {
	        existProduct.setName(product.getName());
	        existProduct.setPrice(product.getPrice());
	        existProduct.setDescription(product.getDescription());
	        return productDao.save(existProduct);
	      });
	  }
	@DeleteMapping(value="/delete/{id}")
	public String deleteproduct(@PathVariable Long id)
	{
		 productDao.deleteById(id);
		return "deleted"+id;
	}
}
