package com.pos.icecream.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.pos.icecream.controller.IceCreamController;
import com.pos.icecream.model.FlavoredIceCream;
import com.pos.icecream.model.IceCreamDecorator;

public class IceCreamButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double price;
	private boolean isDecorator;
	
//	private AIceCream icecream;
	private IceCreamController creator;

	public IceCreamButton(String name, double price, boolean isDecorator, IceCreamController creator) {
		super("[" + name + ",$" + price + "]");
		this.creator = creator;
		this.name = name;
		this.price = price;
		this.isDecorator = isDecorator;
		addActionListener();
	}

//	public AIceCream getIceCream() {
//		return this.icecream;
//	}

	private void addActionListener() {
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// GENERATE ICECREAM
				IceCreamButton btn = (IceCreamButton) e.getSource();
				if(btn.isDecorator==false){
					creator.createIcacream(new FlavoredIceCream(name,price));
				}else{
					creator.createIcacream(new IceCreamDecorator(name,price));					
				}
			}

		});
	}

}
