package ejercicio.conectar2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;

		try {
			// Conectar a MySQL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			stmt = conn.createStatement();

			// 1. Crear base de datos
			String sqlCrearDB = "CREATE DATABASE IF NOT EXISTS tienda3"; // Nuevo nombre de base de datos
			stmt.executeUpdate(sqlCrearDB);

			// Usar la base de datos
			String usarDB = "USE tienda3"; // Usar la nueva base de datos
			stmt.executeUpdate(usarDB);

			// 2. Crear tabla
			String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS productos (" // Nombre de tabla "productos"
					+ "codigo INT PRIMARY KEY AUTO_INCREMENT, " + "nombreProducto VARCHAR(255), "
					+ "descripcion VARCHAR(255), " + "precio DOUBLE)";
			stmt.executeUpdate(sqlCrearTabla);

			// 3. Insertar datos en la tabla
			String sqlInsertar = "INSERT INTO productos (nombreProducto, descripcion, precio) VALUES "
					+ "('Teclado', 'Teclado mecánico RGB', 50.99),"
					+ "('Mouse', 'Mouse ergonómico inalámbrico', 30.49)";
			stmt.executeUpdate(sqlInsertar);

			// 4. Recuperar datos y mostrarlos
			String sqlSeleccionar = "SELECT * FROM productos";
			ResultSet rs = stmt.executeQuery(sqlSeleccionar);
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombreProducto = rs.getString("nombreProducto");
				String descripcion = rs.getString("descripcion");
				double precio = rs.getDouble("precio");
				System.out.println("codigo: " + codigo + " ,nombreProducto " + nombreProducto + " ,descripcion "
						+ descripcion + ", precio " + precio);
			}

			// Cerrar conexiones
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}