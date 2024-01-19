package modelovistacontrolador;
import java.sql.SQLException;
import java.util.List;

public class AlumnoController {
	//Instanciamos el modelo y la vista
	private AlumnoModel model;
	private AlumnoView view;
	
	// Constructor que recibe la url, el usuario y la contraseña de la base de datos
	public AlumnoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
		model = new AlumnoModel(dbURL, dbUser, dbPassword);
		view = new AlumnoView();
	}
	// Metodo que muestra los alumnos
	public void mostrarAlumnos() throws SQLException {
		List<Alumno> alumnos = model.getAllAlumnos();
		view.mostrarAlumnos(alumnos);
	}
	// Metodo para cerrar la conexion
	public void cerrarConexion() throws SQLException {
		model.close();
	}

}
