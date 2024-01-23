package modelo.dao;

import modelo.Autor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class AutorDAO {
    private SessionFactory sessionFactory;

    public AutorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear un nuevo autor
    public void crearAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(autor);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer un autor por su ID
    public Autor leerAutor(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Autor.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar un autor
    public void actualizarAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(autor);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar un autor por su ID
    public void eliminarAutor(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            if (autor != null) {
                session.delete(autor);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todos los autores
    public List<Autor> listarAutores() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Autor", Autor.class).list();
        } finally {
            session.close();
        }
    }
}
