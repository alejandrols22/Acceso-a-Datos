package acceso_datos_27_10_23_ejercicio1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {
    static String usuario = "usuario";
    static String contraseña = "contraseña";
    static String url = "jdbc:mysql://localhost:3306/";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement sentencia = conexion.createStatement()) {
             
            String sql = "CREATE DATABASE MiNuevaBaseDatos";
            sentencia.executeUpdate(sql);
            System.out.println("Base de datos creada exitosamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
}
