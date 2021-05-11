package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.Date;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ShowResultSearch extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ShowResultSearch(int idvideojuego, String name, String sipnosis, Date fecha_lanzamiento,
			double precio, String infoJuego, String requisistos) {
		
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JScrollPane scroller = new JScrollPane(panel);
		panel.add(label("id_videogame:"));
		panel.add(field(String.valueOf(idvideojuego)));
		panel.add(label("name_game:"));
		panel.add(field(name));
		panel.add(label("sipnosis:"));
		panel.add(field(sipnosis));
		panel.add(label("fecha_lanzamiento:"));
		panel.add(field(String.valueOf(fecha_lanzamiento)));
		panel.add(label("precio:"));
		panel.add(field(String.valueOf(precio)));
		panel.add(label("info_juego:"));
		panel.add(field(infoJuego));
		panel.add(label("requisitos:"));
		panel.add(field(requisistos));
		int aux = infoJuego.length();
		GridLayout gridLayout = new GridLayout(7,1,-(aux*5),0);
		panel.setLayout(gridLayout);
		this.add( scroller);
		this.setVisible(true);
		this.setSize(900,400);
	}
	
	
	
	public JLabel label(String name) {
		JLabel jLabel = new JLabel(name,JLabel.LEFT);
		return jLabel;
	}
	
	
	public JTextField field(String text) {
		JTextField field = new JTextField();
		field.setText(text);
		field.setEditable(false);
		return field;
	}
	

	
}
