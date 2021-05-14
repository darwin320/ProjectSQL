package sql;

import java.sql.*;
import java.util.List;
import java.util.Vector;

import view.ShowResultSearch;

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
    
    
    public String ReportOne() throws SQLException {
        String result = "";
        ResultSet resultSet = this.select("SELECT v.id_videojuego,nombre_juego,COUNT(v.id_videojuego) AS logrosNumber\r\n"
        		+ "FROM videojuegos v\r\n"
        		+ "INNER JOIN logros l ON v.id_videojuego = l.id_videojuego\r\n"
        		+ "GROUP BY v.id_videojuego\r\n"
        		+ "ORDER BY logrosNumber DESC LIMIT 1\r\n"
        		+ "");
        while (resultSet.next()){
        	result+= "\n ID: " +  resultSet.getInt("id_videojuego") + "\n Nombre:" + resultSet.getString("nombre_juego");
        }
        return result;
    }
    
    public String ReportTwo() throws SQLException {
        String result = "";
        ResultSet resultSet = this.select("SELECT v.id_videojuego,nombre_juego\r\n"
        		+ "FROM videojuegos v\r\n"
        		+ "INNER JOIN asignacion_idiomas a ON v.id_videojuego = a.id_videojuego\r\n"
        		+ "INNER JOIN idiomas i ON a.ID_IDIOMA = i.ID_IDIOMA AND i.NOMBRE_IDIOMA = 'SPANISH'");
        while (resultSet.next()){
        	result+= "\n ID: " +  resultSet.getInt("id_videojuego") + "\n Nombre:" + resultSet.getString("nombre_juego");
        }
        return result;
    }
    
  

    public List<String> getVideoGames() throws SQLException {
        List<String> regions = new Vector<>();
        ResultSet resultSet = this.select("SELECT *FROM videojuegos");
        while (resultSet.next()){
            regions.add(resultSet.getInt("id_videojuego") + "  "+resultSet.getString("nombre_juego"));
        }
        return regions;
    }
    
    public int deleteVideogame(int videoGame) throws SQLException {
    	int deleteRow = this.statement.executeUpdate(String.format("DELETE FROM videojuegos WHERE id_videojuego = %d ",videoGame));
    	return deleteRow;
    }
    
    public int getVideoGamesInfo(int idVideogame) throws SQLException {
        ResultSet resultSet = this.select(String.format("SELECT *FROM videojuegos WHERE id_videojuego=%d",idVideogame));
        while (resultSet.next()){
        	 new ShowResultSearch(idVideogame, resultSet.getString("nombre_juego"), resultSet.getString("sinopsis"),
             		resultSet.getDate("fecha_lanzamiento"), resultSet.getDouble("precio"), resultSet.getString("info_juego"),
             		resultSet.getString("requisitos"));
        }
        
        return idVideogame;
       
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
	
	
	public int UpdateVideogame(int id_videogame,String itemSelect,String value) throws SQLException {
		int rowSelected = 0;
		if (itemSelect.equals("id_videojuego")) {
			rowSelected = this.statement.executeUpdate(String.format("UPDATE videojuegos SET %1$s = %2$d WHERE id_videojuego=%3$d "
			, itemSelect,Integer.parseInt(value),id_videogame));
		}else if(itemSelect.equals("precio")) {
			rowSelected = this.statement.executeUpdate(String.format("UPDATE videojuegos SET %1$s = %2$f WHERE id_videojuego=%3$d "
			, itemSelect,Double.parseDouble(value),id_videogame));
		}else {
//			System.out.println(String.format("UPDATE videojuegos SET %1$s = '%2$s' WHERE id_videojuego=%3$d "
//					, itemSelect,value,id_videogame));

			rowSelected = this.statement.executeUpdate(String.format("UPDATE videojuegos SET %1$s = '%2$s' WHERE id_videojuego=%3$d "
			, itemSelect,value,id_videogame));
		}
		
		return rowSelected;
		 
	}

	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}
}
