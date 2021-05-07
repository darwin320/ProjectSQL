package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameSelection extends JFrame{


	private JButton crud;
	private JButton reports;
	
	public FrameSelection(ActionListener listener) {
		 JPanel jPanel = new JPanel();
	    jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    jPanel.setLayout(new GridLayout(2,1));
		crud = new JButton("CRUD");
		reports  =new JButton("REPORTS");
		jPanel.add(crud);
		jPanel.add(reports);
		crud.addActionListener(listener);
		reports.addActionListener(listener);
		crud.setActionCommand(Events.CRUD.name());
		reports.setActionCommand(Events.REPORTS.name());
		this.add(jPanel);
		this.setVisible(true);
		this.setSize(300,300);
	}
	
	public static void main(String[] args) {
		new FrameSelection(null);
	}

	
}
