package ventas;

import java.sql.SQLException;

public class ConectarConVentas {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost/nuevodb";
		String dbUser = "root";
		String dbPassword = "1234";

		try {
			VentasController controller = new VentasController(dbURL, dbUser, dbPassword);
			controller.mostrarVentas();
			controller.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
