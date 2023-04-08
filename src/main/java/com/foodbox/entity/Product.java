package com.foodbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "unit_price")
    private double unit_price;

    @Column(name = "available")
    private boolean available;

    @Column(name = "image_url")
    private String imgUrl;

    @Column(name="category")
    private String category;

//    @Column(name = "availableQuantity")
//    private int availableQuantity;

	public Product() {
		super();
	}

	public Product(int id, String name, String description, double unit_price, boolean available, String imgUrl,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unit_price = unit_price;
		this.available = available;
		this.imgUrl = imgUrl;
		this.category = category;
//		this.availableQuantity = availableQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public int getAvailableQuantity() {
//		return availableQuantity;
//	}
//
//	public void setAvailableQuantity(int availableQuantity) {
//		this.availableQuantity = availableQuantity;
//	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", unit_price=" + unit_price
				+ ", available=" + available + ", imgUrl=" + imgUrl + ", category=" + category + ", availableQuantity="
				 + "]";
	}
    
    
}

