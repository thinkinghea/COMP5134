package com.pos.icecream.model;

public abstract class AIceCream {
	protected String description;
	protected double price;
	
	public abstract String getDescription();
	public abstract double getTotalPrice();
	
	public abstract String getName();
	public abstract double getPrice();
}
