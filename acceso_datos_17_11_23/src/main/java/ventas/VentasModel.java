package ventas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentasModel {
	private Connection conn;

	public VentasModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Ventas> getAllVentas() throws SQLException {
		List<Ventas> ventas = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ventas");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int idVentas = rs.getInt("Id_VENTAS");
			int idProductos = rs.getInt("id_PRODUCTOS");
			int idClientes = rs.getInt("Id_CLIENTES");
			String fechaDeVenta = rs.getString("FECHA_DE_VENTA");
			int unidades = rs.getInt("UNIDADES");
			Date femision = rs.getDate("FEMISION");

			ventas.add(new Ventas(idVentas, idProductos, idClientes, fechaDeVenta, unidades, femision));
		}

		stmt.close();
		rs.close();
		return ventas;
	}

	public void close() throws SQLException {
		conn.close();
	}
}
