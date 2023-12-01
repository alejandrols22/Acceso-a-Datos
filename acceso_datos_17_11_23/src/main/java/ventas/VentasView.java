package ventas;

import java.util.List;

public class VentasView {

	public void mostrarVentas(List<Ventas> ventas) {
		for (Ventas venta : ventas) {
			System.out.println("ID Venta: " + venta.getIdVentas());
			System.out.println("ID Producto: " + venta.getIdProductos());
			System.out.println("ID Cliente: " + venta.getIdClientes());
			System.out.println("Fecha de Venta: " + venta.getFechaDeVenta());
			System.out.println("Unidades: " + venta.getUnidades());
			System.out.println("Fecha de Emision: " + venta.getFemision());
			System.out.println();
		}
	}
}
