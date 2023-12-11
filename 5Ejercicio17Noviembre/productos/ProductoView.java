package productos;


import java.util.List;

public class ProductoView {

    public void mostrarProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID Producto: " + producto.getIdProducto());
            System.out.println("ID Proveedor: " + producto.getIdProveedor());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Fabricante: " + producto.getFabricante());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("PVP: " + producto.getPvp());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Columna 8: " + producto.getColumna8());
            System.out.println();
        }
    }
}
