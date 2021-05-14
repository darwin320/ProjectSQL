package view;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField field;
	private JPasswordField password;
	private JButton button;
	private JPanel jPanel;
	private JLabel user;
	private JLabel passwordLabel;
	
	
	public Login(ActionListener actionListener) {
		this.setName("Login");
		button = new JButton("Login");
		jPanel = new JPanel();
		field = new JTextField(20);
		password = new JPasswordField(20);
		user = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(300,200);
		button.addActionListener(actionListener);
		button.setActionCommand(Events.LOGIN.name());
		jPanel.add(user);
		jPanel.add(field);
		jPanel.add(passwordLabel);
		jPanel.add(password);
		jPanel.add(button);
		this.add(jPanel);
		this.setLocationRelativeTo(null);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JTextField getField() {
		return field;
	}


	public JPasswordField getPassword() {
		return password;
	}


	public JButton getButton() {
		return button;
	}


	public JPanel getjPanel() {
		return jPanel;
	}


	public JLabel getUser() {
		return user;
	}


	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	
	
}
