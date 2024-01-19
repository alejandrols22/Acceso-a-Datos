package modelo;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private double precio;

	@Column(name = "fabricante")
	private String fabricante;

	@Column(name = "unidades")
	private int unidades;

	public Productos() {

	}

	public Productos(String nombre, String descripcion, double precio, String fabricante, int unidades) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fabricante = fabricante;
		this.unidades = unidades;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	// Metodo para imprimir informacion del objeto Clientes
	@Override
	public String toString() {
		return "Productos{" + "id=" + id + ", nombre='" + nombre + '\'' + ", descripcion='" + descripcion + '\''
				+ ", precio='" + precio + '\'' + ", fabricante='" + fabricante + '\'' + ", unidades='" + unidades + '\''
				+ '}';
	}

}
