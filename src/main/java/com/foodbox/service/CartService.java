package com.foodbox.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.Cart;
import com.foodbox.entity.Product;
import com.foodbox.repository.CartRepo;
import com.foodbox.repository.ProductRepo;

@Service
public class CartService {

	
	@Autowired
	private CartRepo repo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public Cart addToCart(Cart cart) {
		int productId = cart.getProductId();
		Optional<Product> product = productRepo.findById(productId);
		if(product.isPresent()) {
			Product product1 = product.get();
			double singleCartAmount = cart.getQuantity() * product1.getUnit_price();
		
			cart.setAmount(singleCartAmount);
		
	}
		return repo.save(cart);
	}
	
	
	public Cart getCartById(int id) {
		return repo.findById(id).get();
		
	}
	
	public List<Cart> getAllCartItems(){

		return repo.findAll();
		
	}
	
//	public double getCartAmount(List<Cart> cartItems) {
//		
//		double totalCartAmount = 0d;
//		double singleCartAmount = 0d;
//		
//		for (Cart cart : cartItems) {
//			
//			int productId = cart.getProductId();
//			Optional<Product> product = productRepo.findById(productId);
//			if(product.isPresent()) {
//				Product product1 = product.get();
//				singleCartAmount = cart.getQuantity() * product1.getUnit_price();
//				totalCartAmount = totalCartAmount + singleCartAmount;
//				cart.setProductName(product1.getName());
//				cart.setAmount(singleCartAmount);
//				productRepo.save(product1);
//			}
//			
//		}
//		return totalCartAmount;
//	}
	
}

