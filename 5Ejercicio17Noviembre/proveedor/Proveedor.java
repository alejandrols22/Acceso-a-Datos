package proveedor;

public class Proveedor {
	private int idProveedor;
	private String nombreProveedor;
	private String tlfProveedor;

	public Proveedor(int idProveedor, String nombreProveedor, String tlfProveedor) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.tlfProveedor = tlfProveedor;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public String getTlfProveedor() {
		return tlfProveedor;
	}
}
