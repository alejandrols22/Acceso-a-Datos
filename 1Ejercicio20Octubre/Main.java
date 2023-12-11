package ejercicio.conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		

		        Connection conn = null;
		        Statement stmt = null;

		        try {
		            // Conectar a MySQL
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		            stmt = conn.createStatement();

		            // 1. Crear base de datos
		            String sqlCrearDB = "CREATE DATABASE IF NOT EXISTS empresa2";
		            stmt.executeUpdate(sqlCrearDB);

		            // Usar la base de datos
		            String usarDB = "USE empresa2";
		            stmt.executeUpdate(usarDB);

		            // 2. Crear tabla
		            String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS clientes ("
		                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
		                    + "nif VARCHAR(255), "
		                    + "nombre VARCHAR(255), "
		                    + "edad INT)";
		            stmt.executeUpdate(sqlCrearTabla);

		            // 3. Insertar datos en la tabla
		            String sqlInsertar = "INSERT INTO clientes (nif, nombre, edad) VALUES "
		                    + "('12345678A', 'Juan', 30),"
		                    + "('87654321B', 'Marta', 25)";
		            stmt.executeUpdate(sqlInsertar);

		            // 4. Recuperar datos y mostrarlos
		            String sqlSeleccionar = "SELECT * FROM clientes";
		            ResultSet rs = stmt.executeQuery(sqlSeleccionar);
		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String nif = rs.getString("nif");
		                String nombre = rs.getString("nombre");
		                int edad = rs.getInt("edad");
		                System.out.println("id: " + id + " ,nif " + nif + " ,nombre " + nombre + ", edad " + edad);
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