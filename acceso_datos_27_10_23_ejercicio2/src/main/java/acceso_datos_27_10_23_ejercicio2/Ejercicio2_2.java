package acceso_datos_27_10_23_ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio2_2 {

	private static final String URL = "jdbc:mysql://localhost:3306/TiendaPC?serverTimezone=UTC";
	private static final String USER = "root"; // Por defecto es 'root' en XAMPP
	private static final String PASSWORD = ""; // Por defecto es vacío en XAMPP

	 public static void main(String[] args) {
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establecer conexión con la BBDD
	            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

	            // Si la conexión es exitosa, mostrar un mensaje
	            System.out.println("Conexión establecida con éxito a la base de datos 'TiendaPC'!");

	            // Cerrar conexión
	            con.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	



