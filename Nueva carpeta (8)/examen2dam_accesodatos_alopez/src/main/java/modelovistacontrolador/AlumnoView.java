package modelovistacontrolador;
import java.util.List;

public class AlumnoView {
	// Método para mostrar los clientes en la vista
	public void mostrarAlumnos(List<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			System.out.println("ID: " + alumno.getId());
			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Primer Apellido: " + alumno.getApellido1());
			System.out.println("Segundo Apellido: " + alumno.getApellido2());
			System.out.println("Fecha de naciminto: " + alumno.getFecha_nacimiento());
			System.out.println("Es repetidor: " + alumno.getEs_repetidor());
			System.out.println("Numero de telefono: " + alumno.getTelefono());
			System.out.println();
		}
	}
}
