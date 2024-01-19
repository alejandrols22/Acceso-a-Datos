package modelovistacontrolador;

public class Alumno {
	//variables de clase alumno
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fecha_nacimiento;
	private String es_repetidor;
	private int telefono;
	
	public Alumno(int id, String nombre, String apellido1, String apellido2, String fecha_nacimiento, String es_repetidor, int telefono ) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecha_nacimiento = fecha_nacimiento;
		this.es_repetidor = es_repetidor;
		this.telefono = telefono;
	}
	
	// contructores para conseguir los datos de la variable
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public String getEs_repetidor() {
		return es_repetidor;
	}
	public int getTelefono() {
		return telefono;
	}
}
