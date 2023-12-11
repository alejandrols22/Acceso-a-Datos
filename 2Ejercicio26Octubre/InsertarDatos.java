package acceso_datos_27_10_23_ejercicio1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    static String usuario = "usuario";
    static String contraseña = "contraseña";
    static String url = "jdbc:mysql://localhost:3306/MiNuevaBaseDatos";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conexion.prepareStatement("INSERT INTO nombreTabla (columna1, columna2) VALUES (?, ?)")) {
             
            ps.setString(1, "dato1");
            ps.setString(2, "dato2");
            int filasAfectadas = ps.executeUpdate();
            System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
