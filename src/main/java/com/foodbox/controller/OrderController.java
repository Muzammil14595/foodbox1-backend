package com.foodbox.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.dto.OrderDto;
import com.foodbox.dto.ResponseOrderDto;
import com.foodbox.entity.Order;
import com.foodbox.entity.User;
import com.foodbox.service.CartService;
import com.foodbox.service.OrderService;
import com.foodbox.service.UserService;

import util.DateUtil;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("http://localhost:4200/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/allOrders")
	public List<Order> getAllOrder(){
		return orderService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getOrder(@PathVariable int id) {
		Order order= orderService.getOrder(id);
		if(order!=null)
			return new ResponseEntity<Object>(order,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found",
					HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/placeOrder")
	ResponseEntity<ResponseOrderDto> placeOrder(@RequestBody OrderDto orderDto){
		ResponseOrderDto responseOrderDto = new ResponseOrderDto();
		double amount = orderService.getCartAmount(orderDto.getCartItems());
		
		User user = new User(orderDto.getCustomerName(), orderDto.getCustomerEmail());
		Integer userIdFromDb = userService.isUserPresent(user);
		if(userIdFromDb != null) {
			user.setId(userIdFromDb);
		}else {
			user = userService.addUser(user);
		}
		
		Order order = new Order(orderDto.getOrderDescription(), user, orderDto.getCartItems());
		order = orderService.saveOrder(order);
		
		responseOrderDto.setAmount(amount);
		responseOrderDto.setDate(DateUtil.getCurrentDateTime());
		responseOrderDto.setInvoiceNumber(new Random().nextInt(1000));
		responseOrderDto.setOrderId(order.getId());
		responseOrderDto.setOrderDescription(orderDto.getOrderDescription());
		
		return ResponseEntity.ok(responseOrderDto);
	}
	
}
