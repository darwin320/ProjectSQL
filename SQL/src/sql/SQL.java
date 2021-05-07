package sql;
import java.sql.*;
public class SQL {

	public static void main(String[] args) {
	      Connection connection =null;
	        try {

	             connection = DriverManager.getConnection("jdbc:mysql://localhost/videogames?user=root&password=");
	            Statement statement =connection.createStatement();
	            statement.setQueryTimeout(15);
	            ResultSet resultSet = statement.executeQuery("SELECT *FROM videojuegos");

	            while (resultSet.next()){
	                System.out.println(resultSet.getInt("id_videojuego") + "  "+resultSet.getString("nombre_juego"));
	            }

	            connection.close();

	        } catch (SQLException e) {
	            System.err.println(e.getMessage());
	            try {
	                if (connection!=null){
	                    connection.close();
	                }
	            } catch (SQLException f) {
	                System.err.println(f.getMessage());
	            }
	        }
	}
	
}
