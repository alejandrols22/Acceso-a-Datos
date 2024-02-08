package examen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PacienteDAO {
	private SessionFactory sessionFactory;

	public PacienteDAO() {
		// Crear una instancia de Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// Añadir clases anotadas
		configuration.addAnnotatedClass(Paciente.class);
		// Construir la SessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}

	public Paciente buscarPaciente(long id) {
		Session session = sessionFactory.openSession();
		Paciente paciente = session.get(Paciente.class, id);
		session.close();
		return paciente;
	}

	public void insertarPaciente(Paciente paciente) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(paciente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizarPaciente(Paciente paciente) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(paciente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public boolean eliminarPaciente(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Paciente paciente = session.get(Paciente.class, id);
			if (paciente != null) {
				session.delete(paciente);
				tx.commit();
				return true; // Devuelve true si se ha eliminado correctamente
			} else {
				return false; // Devuelve false si el paciente no existe
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false; // Devuelve false en caso de error
		} finally {
			session.close();
		}
	}

	public List<Paciente> listarPacientes() {
		List<Paciente> pacientes = null;
		Session session = sessionFactory.openSession();
		try {
			pacientes = session.createQuery("from Paciente", Paciente.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pacientes;
	}
}
