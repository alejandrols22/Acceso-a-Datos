package proveedor;

import java.sql.SQLException;

public class ConectarConProveedor {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/nuevodb";
        String dbUser = "root";
        String dbPassword = "1234";

        try {
            ProveedorController controller = new ProveedorController(dbURL, dbUser, dbPassword);
            controller.mostrarProveedores();
            controller.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
