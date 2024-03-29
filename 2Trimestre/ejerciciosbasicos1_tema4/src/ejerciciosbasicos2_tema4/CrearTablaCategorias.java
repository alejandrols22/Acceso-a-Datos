package ejerciciosbasicos2_tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaCategorias {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "SYSTEM";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        Connection conexion = obtenerConexion();
        if (conexion != null) {
            try (Statement statement = conexion.createStatement()) {
                String crearTablaSQL = "CREATE TABLE categorias_de_productos ("
                        + "id INT PRIMARY KEY,"
                        + "categoria VARCHAR(30),"
                        + "subcategoria VARCHAR(30)"
                        + ")";
                statement.executeUpdate(crearTablaSQL);
                System.out.println("Tabla 'categorias_de_productos' creada con éxito.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
