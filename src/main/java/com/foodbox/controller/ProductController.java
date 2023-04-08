package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.Product;
import com.foodbox.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:4200/")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/allProducts")
	public List<Product> getAll(){
		return service.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		Product createdItem = service.addProduct(product);
		if(createdItem != null) {
			return new ResponseEntity<Object> (createdItem, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Object> ("Error while adding Item", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delProduct(@PathVariable int id) {
		service.delProduct(id);
	}
	
	@PutMapping("/{id}")
	public void updProduct(@PathVariable int id, @RequestBody Product product) {
		service.updProduct(id, product);		
	}
}
