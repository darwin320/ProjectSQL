package view;

import javax.swing.JFrame;

public class Frame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelOne panelOne;
	
	public Frame() {
		panelOne = new PanelOne();
		this.setVisible(true);
		this.setSize(400,500);
		this.add(panelOne);
	}

	public static void main(String[] args) {
		new Frame();
	}
	
}
