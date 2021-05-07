package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOne extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonOne;
	private JTextField fieldOne ;
	
	public PanelOne() {
		buttonOne = new JButton("Insertar");
		fieldOne = new JTextField(40);
		this.add(buttonOne);
		this.add(fieldOne);
	}
	
}
