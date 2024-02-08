package examen;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class HospitalApp {

	private static SessionFactory sessionFactory; // Declaración de sessionFactory
	private static Scanner scanner = new Scanner(System.in);
	private static PacienteDAO pacienteDAO = new PacienteDAO();

	private static MedicoDAO medicoDAO = new MedicoDAO();
	private static CitaDAO citaDAO = new CitaDAO();

	public static void main(String[] args) {

		// Inicializar la sessionFactory
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error al inicializar la SessionFactory: " + e);
			throw new ExceptionInInitializerError(e);
		}

		while (true) {
			System.out.println("\n------ Menú ------");
			System.out.println("1. Gestionar pacientes");
			System.out.println("2. Gestionar médicos");
			System.out.println("3. Gestionar citas");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				gestionarPacientes();
				break;
			case 2:
				gestionarMedicos();
				break;
			case 3:
				gestionarCitas();
				break;
			case 4:
				System.out.println("Saliendo...");
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	private static void gestionarPacientes() {
		while (true) {
			System.out.println("\n------ Menú Pacientes ------");
			System.out.println("1. Insertar paciente");
			System.out.println("2. Actualizar paciente");
			System.out.println("3. Mostrar lista de pacientes");
			System.out.println("4. Eliminar paciente");
			System.out.println("5. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			int opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				insertarPaciente();
				break;
			case 2:
				actualizarPaciente();
				break;
			case 3:
				mostrarPacientes();
				break;
			case 4:
				eliminarPaciente();
				break;
			case 5:
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	private static void gestionarMedicos() {
		while (true) {
			System.out.println("\n------ Menú Médicos ------");
			System.out.println("1. Insertar médico");
			System.out.println("2. Actualizar médico");
			System.out.println("3. Mostrar lista de médicos");
			System.out.println("4. Eliminar médico");
			System.out.println("5. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			int opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				insertarMedico();
				break;
			case 2:
				actualizarMedico();
				break;
			case 3:
				mostrarMedicos();
				break;
			case 4:
				eliminarMedico();
				break;
			case 5:
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	private static void gestionarCitas() {
		while (true) {
			System.out.println("\n------ Menú Citas ------");
			System.out.println("1. Agendar cita");
			System.out.println("2. Actualizar cita");
			System.out.println("3. Mostrar lista de citas");
			System.out.println("4. Cancelar cita");
			System.out.println("5. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			int opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				insertarCita();
				break;
			case 2:
				actualizarCita();
				break;
			case 3:
				mostrarCitas();
				break;
			case 4:
				eliminarCita();
				break;
			case 5:
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	// Métodos de gestión de pacientes
	private static void insertarPaciente() {
		System.out.println("Insertar nuevo paciente:");
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Apellidos: ");
		String apellidos = scanner.nextLine();
		System.out.print("Ciudad: ");
		String ciudad = scanner.nextLine();
		System.out.print("Dirección: ");
		String direccion = scanner.nextLine();
		System.out.print("Teléfono: ");
		String telefono = scanner.nextLine();
		System.out.print("Edad: ");
		int edad = Integer.parseInt(scanner.nextLine());
		System.out.print("Historial: ");
		String historial = scanner.nextLine();

		Paciente paciente = new Paciente(nombre, apellidos, ciudad, direccion, telefono, edad, historial);
		pacienteDAO.insertarPaciente(paciente);
		System.out.println("Paciente insertado correctamente.");
	}

	private static void actualizarPaciente() {
		System.out.print("Ingrese el ID del paciente a actualizar: ");
		long id = Long.parseLong(scanner.nextLine());
		Paciente paciente = pacienteDAO.buscarPaciente(id);
		if (paciente != null) {
			System.out.print("Nombre (" + paciente.getNombre() + "): ");
			paciente.setNombre(scanner.nextLine());

			System.out.print("Apellidos (" + paciente.getApellidos() + "): ");
			paciente.setApellidos(scanner.nextLine());

			System.out.print("Ciudad (" + paciente.getCiudad() + "): ");
			paciente.setCiudad(scanner.nextLine());

			System.out.print("Dirección (" + paciente.getDireccion() + "): ");
			paciente.setDireccion(scanner.nextLine());

			System.out.print("Teléfono (" + paciente.getTelefono() + "): ");
			paciente.setTelefono(scanner.nextLine());

			System.out.print("Edad (" + paciente.getEdad() + "): ");
			paciente.setEdad(Integer.parseInt(scanner.nextLine()));

			System.out.print("Historial (" + paciente.getHistorial() + "): ");
			paciente.setHistorial(scanner.nextLine());

			pacienteDAO.actualizarPaciente(paciente);
			System.out.println("Paciente actualizado correctamente.");
		} else {
			System.out.println("Paciente no encontrado.");
		}
	}

	private static void mostrarPacientes() {
		List<Paciente> pacientes = pacienteDAO.listarPacientes();
		if (pacientes.isEmpty()) {
			System.out.println("No hay pacientes registrados.");
		} else {
			for (Paciente paciente : pacientes) {
				System.out.println(paciente);
			}
		}
	}

	private static void eliminarPaciente() {
		System.out.print("Ingrese el ID del paciente a eliminar: ");
		long id = Long.parseLong(scanner.nextLine());
		boolean eliminado = pacienteDAO.eliminarPaciente(id);
		if (eliminado) {
			System.out.println("Paciente eliminado correctamente.");
		} else {
			System.out.println("Error al eliminar el paciente o paciente no encontrado.");
		}
	}

	// Métodos para gestionar médicos
	private static void insertarMedico() {
		System.out.println("Insertar nuevo médico:");
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Apellidos: ");
		String apellidos = scanner.nextLine();
		System.out.print("Especialidad: ");
		String especialidad = scanner.nextLine();

		Medico medico = new Medico(nombre, apellidos, especialidad);
		medicoDAO.insertarMedico(medico);
		System.out.println("Médico insertado correctamente.");
	}

	private static void actualizarMedico() {
		System.out.print("Ingrese el ID del médico a actualizar: ");
		long id = Long.parseLong(scanner.nextLine());
		Medico medico = medicoDAO.buscarMedico(id);
		if (medico != null) {
			System.out.print("Nombre (" + medico.getNombre() + "): ");
			medico.setNombre(scanner.nextLine());
			System.out.print("Apellidos (" + medico.getApellidos() + "): ");
			medico.setApellidos(scanner.nextLine());
			System.out.print("Especialidad (" + medico.getEspecialidad() + "): ");
			medico.setEspecialidad(scanner.nextLine());

			medicoDAO.actualizarMedico(medico);
			System.out.println("Médico actualizado correctamente.");
		} else {
			System.out.println("Médico no encontrado.");
		}
	}

	private static void mostrarMedicos() {
		List<Medico> medicos = medicoDAO.listarMedicos();
		if (medicos.isEmpty()) {
			System.out.println("No hay médicos registrados.");
		} else {
			for (Medico medico : medicos) {
				System.out.println(medico);
			}
		}
	}

	private static void eliminarMedico() {
		System.out.print("Ingrese el ID del médico a eliminar: ");
		long id = Long.parseLong(scanner.nextLine());
		boolean eliminado = medicoDAO.eliminarMedico(id);
		if (eliminado) {
			System.out.println("Médico eliminado correctamente.");
		} else {
			System.out.println("Error al eliminar el médico o médico no encontrado.");
		}
	}

	//Metodos para gestionar citas
	private static void insertarCita() {
		System.out.println("Insertar nueva cita:");
		System.out.print("ID del Paciente: ");
		long idPaciente = scanner.nextLong();
		scanner.nextLine(); // Limpiar el buffer

		System.out.print("ID del Médico: ");
		long idMedico = scanner.nextLong();
		scanner.nextLine(); // Limpiar el buffer

		System.out.print("Fecha (yyyy-MM-dd): ");
		String fechaString = scanner.nextLine();
		LocalDate fecha = LocalDate.parse(fechaString);

		System.out.print("Hora (HH:mm): ");
		String horaString = scanner.nextLine();
		LocalTime hora = LocalTime.parse(horaString);

		// Crear la nueva cita con los datos ingresados
		Cita nuevaCita = new Cita(idPaciente, idMedico, fecha, hora);

		// Llamar al método de insertar cita del CitaDAO
		citaDAO.insertarCita(nuevaCita);

		System.out.println("Cita insertada correctamente.");
	}

	private static void actualizarCita() {
		System.out.println("Actualizar cita existente:");
		System.out.print("ID de la cita a actualizar: ");
		long idCita = scanner.nextLong();
		scanner.nextLine(); // Limpiar el buffer

		
		Session session = sessionFactory.openSession();

		// Buscar la cita por su ID, pasando la sesión como un parámetro
		Cita citaExistente = citaDAO.buscarCita(session, idCita);
		if (citaExistente != null) {
			System.out.print("Nueva fecha (yyyy-MM-dd) [" + citaExistente.getFecha() + "]: ");
			String nuevaFechaString = scanner.nextLine();
			LocalDate nuevaFecha = nuevaFechaString.isEmpty() ? citaExistente.getFecha()
					: LocalDate.parse(nuevaFechaString);

			System.out.print("Nueva hora (HH:mm) [" + citaExistente.getHora() + "]: ");
			String nuevaHoraString = scanner.nextLine();
			LocalTime nuevaHora = nuevaHoraString.isEmpty() ? citaExistente.getHora()
					: LocalTime.parse(nuevaHoraString);

			// Actualizar la cita con los nuevos datos
			citaExistente.setFecha(nuevaFecha);
			citaExistente.setHora(nuevaHora);

			// Llamar al método de actualizar cita del CitaDAO
			citaDAO.actualizarCita(citaExistente);

			System.out.println("Cita actualizada correctamente.");
		} else {
			System.out.println("No se encontró la cita con el ID especificado.");
		}
		
		session.close();
	}

	private static void mostrarCitas() {
		List<Cita> citas = citaDAO.listarCitas();
		if (citas.isEmpty()) {
			System.out.println("No hay citas registradas.");
		} else {
			for (Cita cita : citas) {
				System.out.println(cita);
			}
		}
	}

	private static void eliminarCita() {
		System.out.print("Ingrese el ID de la cita a eliminar: ");
		long id = Long.parseLong(scanner.nextLine());
		boolean eliminado = citaDAO.eliminarCita(id);
		if (eliminado) {
			System.out.println("Cita eliminada correctamente.");
		} else {
			System.out.println("Error al eliminar la cita o la cita no encontrada.");
		}

	}

	
	public static void cerrarSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
