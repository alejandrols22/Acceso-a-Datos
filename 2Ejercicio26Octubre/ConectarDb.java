package acceso_datos_27_10_23_ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDb {
    static String usuario = "usuario";
    static String contraseña = "contraseña";
    static String url = "jdbc:mysql://localhost:3306/nombreBaseDatos";

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}