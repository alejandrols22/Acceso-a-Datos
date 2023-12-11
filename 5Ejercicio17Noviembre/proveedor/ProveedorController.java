package proveedor;

import java.sql.SQLException;
import java.util.List;

public class ProveedorController {
	private ProveedorModel model;
	private ProveedorView view;

	public ProveedorController(String dbURL, String dbUser, String dbPassword) throws SQLException {
		model = new ProveedorModel(dbURL, dbUser, dbPassword);
		view = new ProveedorView();
	}

	public void mostrarProveedores() throws SQLException {
		List<Proveedor> proveedores = model.getAllProveedores();
		view.mostrarProveedores(proveedores);
	}

	public void cerrarConexion() throws SQLException {
		model.close();
	}
}
