package acceso_datos_3_11_23_ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement presta = null;
		String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientes";
		String createProcedure = "CREATE PROCEDURE ObtenerClientes() " + "BEGIN " + "SELECT * FROM clientes;" + "END;";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

			// Primero, eliminamos el procedimiento si existe
			presta = conn.prepareStatement(dropProcedure);
			presta.executeUpdate();

			// Luego, creamos el procedimiento
			presta = conn.prepareStatement(createProcedure);
			presta.executeUpdate();

			System.out.println("Procedimiento creado");

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
