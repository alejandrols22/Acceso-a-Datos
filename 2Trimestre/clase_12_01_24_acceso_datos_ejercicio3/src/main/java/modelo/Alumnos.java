package modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumnos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido1")
	private String apellido1;

	@Column(name = "apellido2")
	private String apellido2;

	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Column(name = "es_repetidor")
	private String es_repetidor;

	@Column(name = "telefono")
	private double telefono;

	// Constructor por defecto requerido por Hibernate
	public Alumnos() {

	}

	// Constructor para crear un objeto de tipo Alumnos con un nombre,
	// un apellido1, un apellido2, una fecha de nacimiento, si es repetidor, y su
	// telefono
	public Alumnos(String nombre, String apellido1, String apellido2, Date fecha_nacimiento, String es_repetidor,
			double telefono) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecha_nacimiento = fecha_nacimiento;
		this.es_repetidor = es_repetidor;
		this.telefono = telefono;

	}

	// Getter y setter para atributo id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	// Getter y setter para el atributo nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 // Getter y setter para el atributo apellido1
    public String getApellido1() {
        return apellido1;
    }


    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    // Getter y setter para el atributo apellido2
    public String getApellido2() {
        return apellido2;
    }


    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
 // Getter y setter para el atributo fecha_nacimiento
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }


    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
 // Getter y setter para el atributo es_repetidor
    public String getEs_repetidor() {
        return es_repetidor;
    }


    public void setEs_repetidor(String es_repetidor) {
        this.es_repetidor = es_repetidor;
    }
    
    // Getter y setter para el atributo telefono
    public double telefono() {
    	return telefono;
    	
    }
    
    public void setTelefono(double telefono) {
    	this.telefono = telefono;
    }
    
    // Metodo para imprimir informacion del objeto Alumnos
    @Override
    public String toString() {
    	return "Alumnos{" +
    			"id=" + id +
    			", nombre='" + nombre + '\'' +
    			", apellido1='" + apellido1 + '\'' +
    			", apellido2='" + apellido2 + '\'' +
    			", fecha_nacimiento='" + fecha_nacimiento + '\'' +
    			", es_repetidor='" + es_repetidor + '\'' +
    			", telefono='" + telefono + '\'' +
    			'}';
    			
    }
}
