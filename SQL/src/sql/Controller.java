package sql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import view.Events;
import view.FrameCrud;
import view.FrameSelection;
import view.Login;

public class Controller implements ActionListener{

	private Login login;
	private ConnectionDataBase connectionDataBase;
	
	public Controller() {
		login= new Login(this);
		connectionDataBase = new ConnectionDataBase();
	}
	
	
	
	public boolean createVideogame() throws SQLException {
		int idvideojuego = Integer.parseInt(JOptionPane.showInputDialog("Ingrese El id Del Videojuego"));
		String name = JOptionPane.showInputDialog("Ingrese El nombre Del Videojuego");
		String sipnosis = JOptionPane.showInputDialog("Ingrese la sipnosis Del Videojuego");
		String fecha_lanzamiento = JOptionPane.showInputDialog("Ingrese la fecha de lanzamiento Del Videojuego formato YYYY/MM/DD");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese El precio Del Videojuego"));
		String infoJuego = JOptionPane.showInputDialog("Ingrese la informacion del Videojuego");
		String requisistos = JOptionPane.showInputDialog("Ingrese los requisitos del videojuego");
		return connectionDataBase.insertVideogame(idvideojuego, name, sipnosis, fecha_lanzamiento, precio, infoJuego, requisistos);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
			case LOGIN:
			try {
				char[] comparepasswordfield = login.getPassword().getPassword();
				connectionDataBase.Login(login.getField().getText(),comparepasswordfield);
				login.dispatchEvent(new WindowEvent(login, WindowEvent.WINDOW_CLOSING));
				JOptionPane.showMessageDialog(null,"Login Correcto");
				new FrameSelection(this);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null,"Error en la conexion usuario o contraseña invalida Reintente");
			}
			break;
		case CREATE:
			try {
				if (createVideogame()) {
					JOptionPane.showMessageDialog(null,"Videojuego añadido correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Error al añadir el videojuego");
				}
			} catch (SQLException e1) {
				System.err.println(e1);
			}
			break;
		case CRUD:
			new FrameCrud(this);
			break;
		case DELETE:
			break;
		case REPORTS:
			break;
		case SEARCH:
			break;
		case UPDATE:
			break;
		default:
			break;
			
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
