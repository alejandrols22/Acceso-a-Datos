package ejerciciosavanzados3_tema4;

import ejerciciosavanzados3_tema4.EmpleadoDAOHibernate;
import ejerciciosavanzados3_tema4.Empleado;
import ejerciciosavanzados3_tema4.HibernateUtil;
import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * 
		 * CREATE TABLE empleados ( id INT PRIMARY KEY, nombre VARCHAR2(100),
		 * departamento VARCHAR2(100), salario NUMBER(10, 2) );
		 * 
		 * ALTER TABLE empresa ADD SALARIO NUMBER; ALTER TABLE empresa ADD DEPARTAMENTO
		 * VARCHAR2(100);
		 * 
		 * 
		 * 
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		EmpleadoDAOHibernate empleadoDao = new EmpleadoDAOHibernate(session);

		// Añadir un nuevo empleado
		Empleado nuevoEmpleado = new Empleado();
		nuevoEmpleado.setId(1); // Asegúrate de que este ID sea único
		nuevoEmpleado.setNombre("Juan");
		nuevoEmpleado.setDepartamento("Ventas");
		nuevoEmpleado.setSalario(3000.00f);
		empleadoDao.agregarEmpleado(nuevoEmpleado);

		// Obtener y mostrar un empleado
		Empleado empleadoObtenido = empleadoDao.obtenerEmpleado(1);
		if (empleadoObtenido != null) {
			System.out.println("Empleado obtenido: " + empleadoObtenido.getNombre());
		}

		// Actualizar un empleado
		if (empleadoObtenido != null) {
			empleadoObtenido.setNombre("Juan Actualizado");
			empleadoDao.actualizarEmpleado(empleadoObtenido);
		}

		// Eliminar un empleado
		empleadoDao.eliminarEmpleado(1);

		// Cerrar la sesión
		session.close();
		HibernateUtil.shutdown();
	}
}
