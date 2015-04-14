package com.pos.icecream.model;

public class FlavoredIceCream extends AIceCream {
	/*
	 * only allow one Flavor
	 */

	public FlavoredIceCream(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public AIceCream makeIceCream() {
		return this;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getDescription() {
		return this.description + " Icecream";
	}

	@Override
	public double getTotalPrice() {
		return this.price;
	}
}
