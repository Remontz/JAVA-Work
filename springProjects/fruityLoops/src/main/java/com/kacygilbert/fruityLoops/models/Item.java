package com.kacygilbert.fruityLoops.models;

public class Item {
	// MEMBER VARIABLES
	private String name;
	private double price;
	
	// CONSTRUCTOR
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// As always, don't forget to generate Getters and Setters!
	public void setName(String newName) {
		this.name = newName;
	}
	public String getName() {
		return name;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	public double getPrice() {
		return price;
	}
}
