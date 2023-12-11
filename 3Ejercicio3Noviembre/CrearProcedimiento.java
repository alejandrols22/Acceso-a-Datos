package acceso_datos_3_11_23_ejercicio1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CrearProcedimiento {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        // SQL para eliminar el procedimiento almacenado si ya existe
        String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientes";

        // SQL para crear el procedimiento almacenado
        String createProcedure = "CREATE PROCEDURE ObtenerClientes() " +
                                 "BEGIN " +
                                 "SELECT * FROM clientes; " +
                                 "END";

        try {
            // Establecer la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "password");

            // Crear un objeto Statement
            stmt = conn.createStatement();

            // Ejecutar la instrucción para eliminar el procedimiento si existe
            stmt.execute(dropProcedure);

            // Ejecutar la instrucción para crear el nuevo procedimiento
            stmt.execute(createProcedure);

            // Imprimir mensaje de éxito
            System.out.println("Procedimiento almacenado 'ObtenerClientes' creado con éxito.");

        } catch (SQLException e) {
            // Manejar posibles errores de SQL
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            // Cerrar los recursos para evitar fugas de memoria
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("SQLException al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
