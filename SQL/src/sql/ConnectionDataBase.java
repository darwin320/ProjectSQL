package sql;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class ConnectionDataBase {

	private Connection connection;
	private Statement statement;

	public ConnectionDataBase() {
		this.connection = null;
		this.statement = null;
	}
	
	
    private ResultSet select(String query) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(query);
        return  resultSet;
    }

    public List<String> getRegions() throws SQLException {
        List<String> regions = new Vector<>();
        ResultSet resultSet = this.select("SELECT *FROM videojuegos");
        while (resultSet.next()){
            regions.add(resultSet.getInt("id_videojuego") + "  "+resultSet.getString("nombre_juego"));
        }
        return regions;
    }

	public boolean insertVideogame(int idvideojuego, String name, String sipnosis, String fecha_lanzamiento,
			double precio, String infoJuego, String requisistos) throws SQLException {
		int rowInsert = this.statement.executeUpdate((String.format(
				"INSERT INTO VIDEOJUEGOS (ID_VIDEOJUEGO,NOMBRE_JUEGO,SINOPSIS,FECHA_LANZAMIENTO,PRECIO,INFO_JUEGO,REQUISITOS) "
						+ "VALUES(%1$d,'%2$s','%3$s','%4$s',%5$f,'%6$s','%7$s')",
				idvideojuego, name, sipnosis, fecha_lanzamiento, precio, infoJuego, requisistos)));
		return rowInsert == 1;
	}
	
	

	public void Login(String username, char[] comparepasswordfield) throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost/videogames?user=" + username + "&password="
				+ String.valueOf(comparepasswordfield));
		this.statement = this.connection.createStatement();
		this.statement.setQueryTimeout(15);
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}
}
