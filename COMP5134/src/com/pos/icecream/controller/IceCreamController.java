package com.pos.icecream.controller;

import java.util.Observable;
import java.util.Vector;

import com.pos.icecream.model.AIceCream;
import com.pos.icecream.model.FlavoredIceCream;
import com.pos.icecream.model.IceCreamDecorator;

public class IceCreamController extends Observable {

	private FlavoredIceCream icecream = null;
	private Vector<IceCreamDecorator> decorators = new Vector<IceCreamDecorator>();

	public IceCreamController() {

	}

	public void createIcacream(AIceCream newicecream) {
		if (newicecream == null) {
			return;
		}
		
		if(newicecream instanceof FlavoredIceCream){
			this.icecream = (FlavoredIceCream)newicecream;
		}
		
		if(newicecream instanceof IceCreamDecorator){
			IceCreamDecorator deco = (IceCreamDecorator)newicecream;
			decorators.add(deco);
		}
		
		fnMakeIceCream();
	}

	private void fnMakeIceCream() {
		if(this.icecream ==null){
			return;
		}
		AIceCream baseIceCream = this.icecream.makeIceCream();
		
		
		for(IceCreamDecorator adeco:decorators){
			baseIceCream = adeco.makeIceCream(baseIceCream);
		}

		setChanged();
		notifyObservers(baseIceCream);
	}

	public void clear() {
		icecream = null;
		decorators.clear();
		setChanged();
		notifyObservers(icecream);
	}

}
