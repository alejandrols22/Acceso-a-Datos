package examen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class MedicoDAO {
	private SessionFactory sessionFactory;

	public MedicoDAO() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Medico.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public Medico buscarMedico(long id) {
		Session session = sessionFactory.openSession();
		Medico medico = session.get(Medico.class, id);
		session.close();
		return medico;
	}

	public void insertarMedico(Medico medico) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(medico);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizarMedico(Medico medico) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(medico);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public boolean eliminarMedico(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Medico medico = session.get(Medico.class, id);
			if (medico != null) {
				session.delete(medico);
				tx.commit();
				return true; // Devuelve true si se ha eliminado correctamente
			} else {
				return false; // Devuelve false si el médico no existe
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

	public List<Medico> listarMedicos() {
		List<Medico> medicos = null;
		Session session = sessionFactory.openSession();
		try {
			medicos = session.createQuery("from Medico", Medico.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return medicos;
	}
}
