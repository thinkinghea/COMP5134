package com.pos.icecream.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AdminPanel extends JFrame{
	IceCreamPanel parent;

	private JTextField favName,decoName,favPrice,decoPrice;
	
	public AdminPanel(){
		
	}
	
	public AdminPanel(IceCreamPanel parent) {
		this.parent = parent;
		this.setTitle("Point-of-Sale for Admin");
		this.setSize(320, 180);
		
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(parent);
		
		/*
		 * Tabbed Pnl
		 * */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		/*
		 * flavorPnl Pnl
		 * */
		JPanel flavorPnl = new JPanel();
		tabbedPane.addTab("Add Flavor", null, flavorPnl, null);
		flavorPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel fCenterPnl = new JPanel();
		flavorPnl.add(fCenterPnl);
		fCenterPnl.setLayout(new BoxLayout(fCenterPnl, BoxLayout.Y_AXIS));
		
		JPanel flavorDescPnl = new JPanel();
		FlowLayout fl1 = (FlowLayout) flavorDescPnl.getLayout();
		fl1.setAlignment(FlowLayout.LEFT);
		fCenterPnl.add(flavorDescPnl);
		
		JLabel lnflavor = new JLabel("Description");
		lnflavor.setLabelFor(favName);
		flavorDescPnl.add(lnflavor);
		
		favName = new JTextField();
		flavorDescPnl.add(favName);
		favName.setPreferredSize(new Dimension(180, 24));
		
		JPanel flavorPricePnl = new JPanel();
		FlowLayout fl2 = (FlowLayout) flavorPricePnl.getLayout();
		fl2.setAlignment(FlowLayout.LEFT);
		fCenterPnl.add(flavorPricePnl);
		
		JLabel lbflavorPrice = new JLabel("Price           ");
		lbflavorPrice.setLabelFor(favPrice);
		flavorPricePnl.add(lbflavorPrice);
		
		favPrice = new JTextField();
		flavorPricePnl.add(favPrice);

		favPrice.setPreferredSize(new Dimension(180, 24));
		
		JPanel flavorBtnPnl = new JPanel();
		fCenterPnl.add(flavorBtnPnl);
		
		JButton btnFlavorNew = new JButton("Add Flavor");
		btnFlavorNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFlavor();
			}
		});
		flavorBtnPnl.add(btnFlavorNew);
		
		JButton btnFlavorCancel = new JButton("Close");
		btnFlavorCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		flavorBtnPnl.add(btnFlavorCancel);
		
		/*
		 * decoPnl Pnl
		 * */
		JPanel decoPnl = new JPanel();
		tabbedPane.addTab("Add Decorator", null, decoPnl, null);
		decoPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel dCenterPnl = new JPanel();
		decoPnl.add(dCenterPnl);
		dCenterPnl.setLayout(new BoxLayout(dCenterPnl, BoxLayout.Y_AXIS));
		
		JPanel decoDescPnl = new JPanel();
		FlowLayout fl3 = (FlowLayout) decoDescPnl.getLayout();
		fl3.setAlignment(FlowLayout.LEFT);
		dCenterPnl.add(decoDescPnl);
		
		JLabel lbDeco = new JLabel("Description");
		lnflavor.setLabelFor(decoName);
		decoDescPnl.add(lbDeco);
		
		decoName = new JTextField();
		decoDescPnl.add(decoName);
		decoName.setPreferredSize(new Dimension(180, 24));
		
		JPanel decoPricePnl = new JPanel();
		FlowLayout fl4 = (FlowLayout) decoPricePnl.getLayout();
		fl4.setAlignment(FlowLayout.LEFT);
		dCenterPnl.add(decoPricePnl);
		
		JLabel lbDecoPrice = new JLabel("Price           ");
		decoPricePnl.add(lbDecoPrice);
		
		decoPrice = new JTextField();
		decoPricePnl.add(decoPrice);
		decoPrice.setPreferredSize(new Dimension(180, 24));
		
		JPanel decoBtnPnl = new JPanel();
		dCenterPnl.add(decoBtnPnl);
		
		JButton btnDecoNew = new JButton("Add Decorator");
		btnDecoNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDeco();
			}
		});
		decoBtnPnl.add(btnDecoNew);
		
		JButton btnDecoClose = new JButton("Close");
		btnDecoClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		decoBtnPnl.add(btnDecoClose);
		
		
		/*
		 * decoPnl Pnl
		 * */
		JPanel dummyPnl = new JPanel();
		tabbedPane.addTab("Add Sample", null, dummyPnl, null);
		dummyPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel duCenterPnl = new JPanel();
		dummyPnl.add(duCenterPnl);

		JButton btnDummyNew = new JButton("Add Sample");
		btnDummyNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSample();
			}
		});
		duCenterPnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		duCenterPnl.add(btnDummyNew);
	}

	private void addFlavor(){		
		String name =favName.getText();
		String price = favPrice.getText();
		boolean result = checkValid(name,price);
		double dPrice = 0;
		if(result==true){
			try{
				dPrice = Double.parseDouble(price);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, "Please input positive numbers.");
				return;
			}
			parent.addIceCreamFlavor(new IceCreamButton(name,dPrice,false,parent.getCreator()));
		}
	}
	
	private void addDeco(){
		String name =decoName.getText();
		String price = decoPrice.getText();
		boolean result = checkValid(name,price);
		double dPrice = 0;
		if(result==true){
			try{
				dPrice = Double.parseDouble(price);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, "Please input positive number.");
				return;
			}
			parent.addIceCreamDecorator(new IceCreamButton(name,dPrice,true,parent.getCreator()));
		}
	}
	
	private boolean checkValid(String name, String price) {
		if(isValidDescription(name)==false){
			JOptionPane.showMessageDialog(this, "Please input a description.");
			return false;
		}
		if(isValidPrice(price)==false){
			JOptionPane.showMessageDialog(this, "Please input positive number.");
			return false;
		}
		return true;
	}

	private void close(){
		parent.allow(true);
		this.dispose();
	}
	
	
	
	public boolean isValidDescription(String name){
		if(name==null||name.equalsIgnoreCase("")){
			return false;			
		}
		return true;
	}
	
	public boolean isValidPrice(String price){
		if(price==null||price.equalsIgnoreCase("")){
			return false;			
		}
		try{
			double dprice = Double.parseDouble(price);
			if(dprice<0){
				throw new Exception();
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	private void addSample() {
		parent.addIceCreamFlavor(new IceCreamButton("Chocolate",20,false,parent.getCreator()));
		parent.addIceCreamFlavor(new IceCreamButton("Vanilla",21,false,parent.getCreator()));
		

		parent.addIceCreamDecorator(new IceCreamButton("M&M",5,true,parent.getCreator()));
		parent.addIceCreamDecorator(new IceCreamButton("Strawberry",4,true,parent.getCreator()));
		parent.addIceCreamDecorator(new IceCreamButton("Nuts",6,true,parent.getCreator()));
		parent.addIceCreamDecorator(new IceCreamButton("Cookie",3,true,parent.getCreator()));
	}
}
