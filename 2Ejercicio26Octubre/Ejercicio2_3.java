package acceso_datos_27_10_23_ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ejercicio2_3 {

	 	private static final String URL = "jdbc:mysql://localhost:3306/TiendaPC?serverTimezone=UTC";
	    private static final String USER = "root";   
	    private static final String PASSWORD = "";   

	    public static void main(String[] args) {
	        try {
	            // Registrar el driver de MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establecer conexión con la BBDD
	            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	            
	            // SQL para insertar datos en la tabla productos
	            String insertSQL = "INSERT INTO productos (Id, nombreProduct, fabricante) VALUES (?, ?, ?)";
	            
	            // Preparar la sentencia SQL
	            PreparedStatement pstmt = con.prepareStatement(insertSQL);

	            // Insertar el primer producto
	            pstmt.setInt(1, 1);
	            pstmt.setString(2, "Portatil");
	            pstmt.setString(3, "Hp");
	            pstmt.executeUpdate();

	            // Insertar el segundo producto
	            pstmt.setInt(1, 2);
	            pstmt.setString(2, "Tablet");
	            pstmt.setString(3, "Lenovo");
	            pstmt.executeUpdate();
	            
	            System.out.println("Datos insertados con éxito en la tabla 'productos'!");

	            // Cerrar conexiones
	            pstmt.close();
	            con.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}