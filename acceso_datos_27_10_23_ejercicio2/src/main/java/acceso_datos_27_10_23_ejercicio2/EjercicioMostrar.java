package acceso_datos_27_10_23_ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjercicioMostrar {

	 private static final String URL = "jdbc:mysql://localhost:3306/TiendaPC?serverTimezone=UTC";
	    private static final String USER = "root";   
	    private static final String PASSWORD = "";   

	    public static void main(String[] args) {
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establecer conexión con la BBDD
	            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

	            // Si la conexión es exitosa, mostrar un mensaje
	            System.out.println("Conexión establecida con éxito a la base de datos 'TiendaPC'!");

	            // Crear una sentencia SQL
	            Statement stmt = con.createStatement();

	            // SQL para obtener los datos de la tabla productos
	            String selectSQL = "SELECT * FROM productos";

	            // Ejecutar la sentencia SQL
	            ResultSet rs = stmt.executeQuery(selectSQL);

	            System.out.println("\nDatos en la tabla 'productos':");
	            System.out.println("------------------------------------------------");
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("Id") + "\tNombre del Producto: " + rs.getString("nombreProduct") + "\tFabricante: " + rs.getString("fabricante"));
	            }
	            System.out.println("------------------------------------------------");

	            // Cerrar conexiones
	            rs.close();
	            stmt.close();
	            con.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}