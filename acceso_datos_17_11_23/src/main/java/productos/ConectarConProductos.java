package productos;

import java.sql.SQLException;

public class ConectarConProductos {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/nuevodb";
        String dbUser = "root";
        String dbPassword = "1234";

        try {
            ProductoController controller = new ProductoController(dbURL, dbUser, dbPassword);
            controller.mostrarProductos();
            controller.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}