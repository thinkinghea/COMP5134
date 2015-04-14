package com.pos.icecream.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import com.pos.icecream.core.IceCreamController;
import com.pos.icecream.model.AIceCream;

public class IceCreamPanel extends JFrame implements Observer{
	private static final String TAG = IceCreamPanel.class.getName();
	private JPanel decoBtnPnl,flavorBtnPnl;
	private JLabel lbPrice,lbDesc;
	private IceCreamController creator;
	
	private static void fnSetTheme() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public IceCreamPanel(IceCreamController creator) {
		this.creator = creator;
		creator.addObserver(this);
		
		fnSetTheme();
		
		this.setTitle("Point-of-Sale for Ice-cream shop");
		this.setSize(800, 600);
		
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel toobarPnl = new JPanel();
		getContentPane().add(toobarPnl, BorderLayout.NORTH);
		toobarPnl.setLayout(new BoxLayout(toobarPnl, BoxLayout.X_AXIS));
		
		JPanel toobarPnlLeft = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) toobarPnlLeft.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		toobarPnl.add(toobarPnlLeft);
		
		JButton btnSystemAdministrator = new JButton("System Administrator");
		btnSystemAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnAdmin();
			}

		});
		toobarPnlLeft.add(btnSystemAdministrator);
		
		JPanel toobarPnlRight = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) toobarPnlRight.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		toobarPnl.add(toobarPnlRight);
		
		JButton btnNewIceCream = new JButton("New IceCream");
		btnNewIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnReset();
			}
		});
		toobarPnlRight.add(btnNewIceCream);
		
		JPanel centerPnl = new JPanel();
		getContentPane().add(centerPnl, BorderLayout.CENTER);
		centerPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel icecreamMainPnl = new JPanel();
		icecreamMainPnl.setBorder(new TitledBorder(null, "Please select one flavor and any decorator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		centerPnl.add(icecreamMainPnl, BorderLayout.CENTER);
		icecreamMainPnl.setLayout(new BorderLayout(0, 0));
		
		
		JPanel icecreamBtnPnl = new JPanel();
		icecreamMainPnl.add(icecreamBtnPnl, BorderLayout.CENTER);
		icecreamBtnPnl.setLayout(new BoxLayout(icecreamBtnPnl, BoxLayout.X_AXIS));
		
		/*
		 * Flavor
		 * */
		flavorBtnPnl = new JPanel();
		JScrollPane scrollPane_flavor = new JScrollPane();
		icecreamBtnPnl.add(scrollPane_flavor);
		scrollPane_flavor.setViewportView(flavorBtnPnl);
		flavorBtnPnl.setLayout(new BoxLayout(flavorBtnPnl, BoxLayout.Y_AXIS));

		/*
		 * DECO
		 * */
		decoBtnPnl = new JPanel();
		decoBtnPnl.setLayout(new BoxLayout(decoBtnPnl, BoxLayout.Y_AXIS));
		JScrollPane scrollPane_deco = new JScrollPane();
		icecreamBtnPnl.add(scrollPane_deco);
		scrollPane_deco.setViewportView(decoBtnPnl);
		

		
		

		/*
		 * Status Panel
		 * */
		
		JPanel headerPnl = new JPanel();
		icecreamMainPnl.add(headerPnl, BorderLayout.NORTH);
		headerPnl.setLayout(new BoxLayout(headerPnl, BoxLayout.X_AXIS));
		
		JPanel headerLeft = new JPanel();
		headerPnl.add(headerLeft);
		
		JLabel lbFavour = new JLabel("ICE-CREAM Flavor");
		headerLeft.add(lbFavour);
		
		JPanel headerRight = new JPanel();
		headerPnl.add(headerRight);
		
		JLabel lbDeco = new JLabel("Decorator");
		headerRight.add(lbDeco);
		
		JPanel resultMainPnl = new JPanel();
		centerPnl.add(resultMainPnl, BorderLayout.NORTH);
		resultMainPnl.setLayout(new BorderLayout(0, 0));
		
		JSeparator sep1 = new JSeparator();
		resultMainPnl.add(sep1, BorderLayout.NORTH);
		JPanel resultPnl = new JPanel();
		resultMainPnl.add(resultPnl, BorderLayout.CENTER);
		resultPnl.setBorder(new CompoundBorder());
		resultPnl.setLayout(new BoxLayout(resultPnl, BoxLayout.X_AXIS));
		
		JPanel resultPnlLeft = new JPanel();
		FlowLayout flowLayout_r1 = (FlowLayout) resultPnlLeft.getLayout();
		flowLayout_r1.setAlignment(FlowLayout.LEFT);
		resultPnl.add(resultPnlLeft);
		
		JLabel lbDesc1 = new JLabel("Description: ");
		Font newFont = lbDesc1.getFont().deriveFont(64).deriveFont(Font.BOLD);
		lbDesc1.setFont(newFont);
		resultPnlLeft.add(lbDesc1);
		
		lbDesc = new JLabel("");
		lbDesc.setFont(newFont);
		resultPnlLeft.add(lbDesc);
		

		JPanel resultPnlRight = new JPanel();
		resultPnl.add(resultPnlRight);
		FlowLayout fl_resultPnlRight = (FlowLayout) resultPnlRight.getLayout();
		fl_resultPnlRight.setAlignment(FlowLayout.RIGHT);
		
		JLabel lbTotal = new JLabel("Total: ");
		lbTotal.setFont(newFont);
		resultPnlRight.add(lbTotal);
		
		lbPrice = new JLabel("");
		lbPrice.setFont(newFont);
		resultPnlRight.add(lbPrice);
		
		JSeparator sep2 = new JSeparator();
		resultMainPnl.add(sep2, BorderLayout.SOUTH);
	}

	private void fnReset() {
		creator.clear();
		lbPrice.setText("");
		lbDesc.setText("");
	}
	
	private void fnUpdateStatus(String name,String price) {
		lbDesc.setText(name);
		lbPrice.setText(price);
	}

	private void fnAdmin() {
		AdminPanel ap = new AdminPanel(this);
		ap.setVisible(true);
		this.setEnabled(false);
		ap.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				allow(true);
			}
		});
	}
	
	public IceCreamController getCreator(){
		return this.creator;
	}
	
	public void allow(boolean a) {
		this.setEnabled(a);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(TAG+"|"+arg);
		if(arg instanceof AIceCream){
			AIceCream cream = (AIceCream)arg;
			fnUpdateStatus(cream.getDescription(),"$"+cream.getTotalPrice());
		}
	}
	
	public void addIceCreamFlavor(IceCreamButton btn){
		flavorBtnPnl.add(btn);
		flavorBtnPnl.doLayout();

		validate();
		repaint();
	}
	
	public void addIceCreamDecorator(IceCreamButton btn){
		decoBtnPnl.add(btn);
		decoBtnPnl.doLayout();

		validate();
		repaint();
	}
	
}
