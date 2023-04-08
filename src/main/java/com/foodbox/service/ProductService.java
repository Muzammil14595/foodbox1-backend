package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.Product;
import com.foodbox.repository.ProductRepo;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepo repo;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	public Product getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void delProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public void updProduct(int id, Product prod) {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
			
			Product oldItem = repo.findById(id).get();
			oldItem.setName(prod.getName());
			oldItem.setDescription(prod.getDescription());
			oldItem.setCategory(prod.getCategory());
			oldItem.setUnit_price(prod.getUnit_price());
			oldItem.setImgUrl(prod.getImgUrl());
			
			repo.save(oldItem);
		}
	}
}
