package proveedor;

import java.util.List;

public class ProveedorView {

	public void mostrarProveedores(List<Proveedor> proveedores) {
		for (Proveedor proveedor : proveedores) {
			System.out.println("ID Proveedor: " + proveedor.getIdProveedor());
			System.out.println("Nombre Proveedor: " + proveedor.getNombreProveedor());
			System.out.println("Teléfono Proveedor: " + proveedor.getTlfProveedor());
			System.out.println();
		}
	}
}
