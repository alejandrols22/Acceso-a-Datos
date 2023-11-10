package simulacro_10_11_23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement presta = null;
        String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientes";
        String createProcedure = "CREATE PROCEDURE ObtenerClientes() " +
                "BEGIN " +
                "SELECT * FROM clientes;" +
                "END;";

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection("jdbc:mysql://localhost/simulacro", "root", "");

            // Eliminar el procedimiento si existe
            presta = conn.prepareStatement(dropProcedure);
            presta.execute();

            // Crear el nuevo procedimiento
            presta = conn.prepareStatement(createProcedure);
            presta.execute();

            System.out.println("Procedimiento almacenado creado con éxito.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar PreparedStatement y Connection
            try {
                if (presta != null) presta.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
