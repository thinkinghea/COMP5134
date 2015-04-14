package com.pos.icecream.model;

public class IceCreamDecorator extends AIceCream {
	protected AIceCream icecream;

	public IceCreamDecorator(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public AIceCream makeIceCream(AIceCream icecream) {
		this.icecream = icecream;
		return this;
	}

	@Override
	public String getDescription() {
		return icecream.getDescription() + " with a " + getName();
	}

	@Override
	public double getTotalPrice() {
		return icecream.getTotalPrice() + getPrice();
	}

	@Override
	public String getName() {
		return this.description;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
