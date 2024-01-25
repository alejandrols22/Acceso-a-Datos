package ejerciciosbasicos2_tema4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaCategorias {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "SYSTEM";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static void main(String[] args) {
        try (Connection conexion = obtenerConexion();
             Statement statement = conexion.createStatement()) {

            String sqlCrear = "CREATE TABLE categorias_productos (" +
                    "id INT PRIMARY KEY, " +
                    "categoria VARCHAR(30), " +
                    "subcategoria VARCHAR(30))";

            statement.execute(sqlCrear);
            System.out.println("Tabla 'categorias_productos' creada con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
