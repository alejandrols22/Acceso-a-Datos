package examen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CitaDAO {
	private SessionFactory sessionFactory;

	public CitaDAO() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Cita.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public Cita buscarCita(Session session, long id) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cita cita = session.get(Cita.class, id);
			tx.commit();
			return cita;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	public void insertarCita(Cita cita) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(cita);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizarCita(Cita cita) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(cita);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public boolean eliminarCita(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cita cita = session.get(Cita.class, id);
			if (cita != null) {
				session.delete(cita);
				tx.commit();
				return true; // Devuelve true si se ha eliminado correctamente
			} else {
				return false; // Devuelve false si la cita no existe
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

	public List<Cita> listarCitas() {
		List<Cita> citas = null;
		Session session = sessionFactory.openSession();
		try {
			citas = session.createQuery("from Cita", Cita.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return citas;
	}
}
