package com.foodbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.Cart;
import com.foodbox.entity.Order;
import com.foodbox.entity.Product;
import com.foodbox.repository.OrderRepo;
import com.foodbox.repository.ProductRepo;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private ProductRepo productRepo;

	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	public Order saveOrder(Order order) {
		return repo.save(order);
	}
	
	public double getCartAmount(List<Cart> cartItems) {
		
		double totalCartAmount = 0d;
		double singleCartAmount = 0d;
		
		if(cartItems != null) {
		for (Cart cart : cartItems) {
			
			int productId = cart.getProductId();
			Optional<Product> product = productRepo.findById(productId);
			if(product.isPresent()) {
				Product product1 = product.get();
				singleCartAmount = cart.getQuantity() * product1.getUnit_price();
				totalCartAmount = totalCartAmount + singleCartAmount;
				cart.setProductName(product1.getName());
				cart.setAmount(singleCartAmount);
				productRepo.save(product1);
			}
		}
			
		}
		return totalCartAmount;
	}
		
}
