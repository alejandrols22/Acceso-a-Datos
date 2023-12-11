package productos;

public class Producto {
	private int idProducto;
	private int idProveedor;
	private String nombre;
	private String fabricante;
	private String precio;
	private double pvp;
	private String descripcion;
	private int columna8; 

	
	public Producto(int idProducto, int idProveedor, String nombre, String fabricante, String precio, double pvp,
			String descripcion, int columna8) {
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
		this.pvp = pvp;
		this.descripcion = descripcion;
		this.columna8 = columna8;
	}

	
	public int getIdProducto() {
		return idProducto;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getPrecio() {
		return precio;
	}

	public double getPvp() {
		return pvp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getColumna8() {
		return columna8;
	}
}
