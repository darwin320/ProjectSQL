package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSelectItem extends JPanel {

	/**
	 * 
	 */
	private JFrame frame;

	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboAux;
    private JButton button;
    private JButton buttonAux;

    public PanelSelectItem(List<String> list,String nameJbutton,boolean aux) {
    	   frame = new JFrame("Seleccionar Videojuego");
    	   button = new JButton(nameJbutton);
           comboBox = new JComboBox<Object>(list.toArray());
           comboBox.setBounds(50, 50, 90, 20);

           comboBox.setSize(200,40);
           this.add(comboBox);
           
           Object[] listItems = {"id_videojuego","nombre_juego","sinopsis","fecha_lanzamiento","precio","info_juego","requisitos"};
    	   comboAux = new JComboBox<Object>(listItems);
		   comboAux.setBounds(50, 50, 90, 20);
		   comboAux.setSize(200,40);
           if (aux) {
        	   this.add(comboAux);
        	   this.add(button);
           }else {
        	   this.add(button);
           }
           frame.add(this);
           frame.setSize(400, 200);
           frame.setVisible(true);
		}
    
    public JComboBox<Object> getComboAux() {
		return comboAux;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JComboBox<Object> getComboBox() {
		return comboBox;
	}

	public JButton getButton() {
		return button;
	}

    }




