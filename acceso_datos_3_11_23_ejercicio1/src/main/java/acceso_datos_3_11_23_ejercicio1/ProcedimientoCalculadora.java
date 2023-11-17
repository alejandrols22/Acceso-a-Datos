package acceso_datos_3_11_23_ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedimientoCalculadora {
	/*
	 * DELIMITER $$
	 * 
	 * DROP PROCEDURE IF EXISTS `Calculadora` $$ CREATE PROCEDURE `Calculadora`( IN
	 * num1 DOUBLE, IN num2 DOUBLE, IN op CHAR(1), OUT result DOUBLE ) BEGIN CASE op
	 * WHEN '+' THEN SET result = num1 + num2; WHEN '-' THEN SET result = num1 -
	 * num2; WHEN '*' THEN SET result = num1 * num2; WHEN '/' THEN SET result = num1
	 * / num2; ELSE SET result = 0; END CASE; END$$
	 * 
	 * DELIMITER ;
	 */
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

			// Llamar al procedimiento almacenado para la calculadora
			cstmt = conn.prepareCall("{call Calculadora(?, ?, ?, ?)}");
			cstmt.setDouble(1, 10.0); // Primer número
			cstmt.setDouble(2, 5.0); // Segundo número
			cstmt.setString(3, "+"); // Operación
			cstmt.registerOutParameter(4, Types.DOUBLE);

			// Ejecutar el procedimiento
			cstmt.execute();

			// Obtener el resultado
			double resultado = cstmt.getDouble(4);
			System.out.println("El resultado de la operación es: " + resultado);

			// cerrar las conexiones
			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
