package com.pos.icecream.core;

import com.pos.icecream.ui.IceCreamPanel;

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
