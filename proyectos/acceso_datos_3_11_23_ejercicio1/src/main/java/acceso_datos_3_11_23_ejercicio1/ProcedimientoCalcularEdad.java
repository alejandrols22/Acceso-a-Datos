package acceso_datos_3_11_23_ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedimientoCalcularEdad {

	/*
	 * DELIMITER $$
	 * 
	 * DROP PROCEDURE IF EXISTS CalcularEdad $$
	 * 
	 * CREATE PROCEDURE CalcularEdad ( IN fechaNacimiento INT, OUT edad INT ) BEGIN
	 * DECLARE actual INT DEFAULT YEAR(CURDATE()); -- Obtiene el año actual SET edad
	 * = actual - fechaNacimiento; -- Calcula la edad END $$
	 * 
	 * DELIMITER ;
	 */

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

			// Llamar al procedimiento almacenado para calcular la edad
			cstmt = conn.prepareCall("{call CalcularEdad(?, ?)}");
			cstmt.setInt(1, 1990); // Suponiendo que 1990 es el año de nacimiento
			cstmt.registerOutParameter(2, Types.INTEGER);

			// Ejecutar el procedimiento
			cstmt.execute();

			// Obtener el resultado
			int edad = cstmt.getInt(2);

			System.out.println("La edad calculada es: " + edad);

			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}