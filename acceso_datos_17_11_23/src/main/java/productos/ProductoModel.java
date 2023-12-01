package productos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel {
	private Connection conn;

	public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Producto> getAllProductos() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int idProducto = rs.getInt("id_PRODUCTO");
			int idProveedor = rs.getInt("id_proveedor");
			String nombre = rs.getString("NOMBRE");
			String fabricante = rs.getString("FABRICANTE");
			String precio = rs.getString("PRECIO");
			double pvp = rs.getDouble("PVP");
			String descripcion = rs.getString("Descripcion");
			int columna8 = rs.getInt("Columna 8");

			productos
					.add(new Producto(idProducto, idProveedor, nombre, fabricante, precio, pvp, descripcion, columna8));
		}

		stmt.close();
		rs.close();
		return productos;
	}

	public void close() throws SQLException {
		conn.close();
	}
}
