package sql;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import view.Events;
import view.FrameCrud;
import view.FrameSelection;
import view.Login;
import view.PanelSelectItem;
import view.ReportsSelection;

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
	
	
	
	
	public List<String> listVideoGames(){
		List<String> regions = null;
		 try {
	            regions = connectionDataBase.getVideoGames();
	            regions.forEach((String reg)->{
	            });
	        } catch (SQLException e) {
	        	System.err.println(e);
	        }
		 return regions;
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
			PanelSelectItem itemToDelete = new  PanelSelectItem(listVideoGames(),"Eliminar",false);
			itemToDelete.getButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							String  id = (String) itemToDelete.getComboBox().getSelectedItem();
							int value =connectionDataBase.deleteVideogame(Integer.parseInt(id.replaceAll(" .*", "")));
							if (value==1) {
								JOptionPane.showMessageDialog(null,"Videojuego eliminado correctamente");
							}
						} catch (SQLException e1) {
							System.err.println(e1);
						}
				}
			} );
			break;
		case REPORTS:
			ReportsSelection reportsSelection = new ReportsSelection();
			reportsSelection.getReportOne().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JOptionPane.showMessageDialog(null, "EL VIDEOJUEGO CON EL MAYOR NUMERO DE LOGROS ES : "
								+connectionDataBase.ReportOne());
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			reportsSelection.getReportTwo().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JOptionPane.showMessageDialog(null, "VIDEOJUEGOS CON DISPONIBILIDAD DEL IDIOMA ESPAÑOL  : "
								+connectionDataBase.ReportTwo());
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			
			break;
		case SEARCH:
			PanelSelectItem item = new  PanelSelectItem(listVideoGames(),"Buscar",false);
			item.getButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int index = item.getComboBox().getSelectedIndex();
						try {
							String  id = (String) item.getComboBox().getSelectedItem();
							connectionDataBase.getVideoGamesInfo(Integer.parseInt(id.replaceAll(" .*", "")));
						} catch (SQLException e1) {
							System.err.println(e1);
						}
				}
			} );
			
			break;
		case UPDATE:
			PanelSelectItem value = new  PanelSelectItem(listVideoGames(),"Actualizar",true);
			value.getButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							String  id = (String) value.getComboBox().getSelectedItem();
							String name = JOptionPane.showInputDialog("Ingrese el nuevo  "+value.getComboAux().getSelectedItem() + " Del Videojuego");
							int result= connectionDataBase.UpdateVideogame(Integer.parseInt(id.replaceAll(" .*", ""))
									, (String) value.getComboAux().getSelectedItem(), name);
							
							if (result ==1) {
								JOptionPane.showMessageDialog(null,"Actualizacion satisfactoria");
							}
						} catch (SQLException e1) {
							System.err.println(e1);
						}
				}
			} );
			
			break;
		default:
			break;
			
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
