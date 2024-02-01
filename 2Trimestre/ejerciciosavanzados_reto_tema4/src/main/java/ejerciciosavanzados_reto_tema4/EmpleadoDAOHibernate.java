package ejerciciosavanzados_reto_tema4;



import ejerciciosavanzados_reto_tema4.EmpleadoDAO;
import ejerciciosavanzados_reto_tema4.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmpleadoDAOHibernate implements EmpleadoDAO {
    private SessionFactory sessionFactory;

    public EmpleadoDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public void agregar(Empleado empleado) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(empleado);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    
    public Empleado obtener(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Empleado.class, id);
        } finally {
            session.close();
        }
    }

    
    public void actualizar(Empleado empleado) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(empleado);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    
    public void eliminar(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                session.delete(empleado);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

   
    public List<Empleado> obtenerTodos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Empleado", Empleado.class).list();
        } finally {
            session.close();
        }
    }
}

