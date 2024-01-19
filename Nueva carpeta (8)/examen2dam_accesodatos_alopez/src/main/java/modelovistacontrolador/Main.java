package modelovistacontrolador;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		// las variables necesarias para la conexion con la base de datos
		String dbURL = "jdbc:mysql://localhost/instituto";
		String dbUser = "root";
		String dbPassword = "";
		
		try {
			AlumnoController controller = new AlumnoController(dbURL, dbUser, dbPassword);
			controller.mostrarAlumnos(); // Llama al metodo para mostar los alumnos
			controller.cerrarConexion();// Llama al metodo para cerrar la conexion
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
