package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReportsSelection extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton reportOne;
	private JButton reportTwo;
	
	public ReportsSelection() {
		 JPanel jPanel = new JPanel();
	    jPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    jPanel.setLayout(new GridLayout(2,1));
		reportOne = new JButton("REPORTE NUMERO 1");
		reportTwo  =new JButton("REPORTE NUMERO 2");
		jPanel.add(reportOne);
		jPanel.add(reportTwo);
		this.add(jPanel);
		this.setVisible(true);
		this.setSize(300,300);
	}
	
	public JButton getReportOne() {
		return reportOne;
	}

	public void setReportOne(JButton reportOne) {
		this.reportOne = reportOne;
	}

	public JButton getReportTwo() {
		return reportTwo;
	}

	public void setReportTwo(JButton reportTwo) {
		this.reportTwo = reportTwo;
	}

	public static void main(String[] args) {
		new FrameSelection(null);
	}
}
