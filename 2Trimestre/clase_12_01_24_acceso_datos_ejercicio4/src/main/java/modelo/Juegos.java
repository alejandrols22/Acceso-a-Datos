package modelo;

import javax.persistence.*;

@Entity
@Table(name = "tvideojuegos")
public class Juegos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "anio")
	private int anio;

	@Column(name = "compañia")
	private String compañia;

	@Column(name = "precio")
	private double precio;

	@Column(name = "sinopsis")
	private String sinopsis;

	@Column(name = "plataforma")
	private String plataforma;

	public Juegos() {

	}

	public Juegos(String nombre, Integer anio, String compania, Double precio, String sinopsis, String plataforma) {

		this.nombre = nombre;
		this.anio = anio;
		this.compañia = compania;
		this.precio = precio;
		this.sinopsis = sinopsis;
		this.plataforma = plataforma;
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	// M�todo para imprimir informaci�n del objeto Clientes
    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anio='" + anio + '\'' +
                ", compañia='" + compañia + '\'' +
                ", precio='" + precio + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }

}