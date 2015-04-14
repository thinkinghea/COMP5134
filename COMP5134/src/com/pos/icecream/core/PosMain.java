package com.pos.icecream.core;

import com.pos.icecream.controller.IceCreamController;
import com.pos.icecream.view.IceCreamPanel;

public class PosMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IceCreamController creator = new IceCreamController();
		IceCreamPanel icp = new IceCreamPanel(creator);
		icp.setVisible(true);
	}

}
