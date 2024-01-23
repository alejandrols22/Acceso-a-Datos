package modelo.dao;

import modelo.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class LibroDAO {
    private SessionFactory sessionFactory;

    public LibroDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear un nuevo libro
    public void crearLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(libro);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer un libro por su ID
    public Libro leerLibro(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Libro.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar un libro
    public void actualizarLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(libro);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar un libro por su ID
    public void eliminarLibro(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                session.delete(libro);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todos los libros
    public List<Libro> listarLibros() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Libro", Libro.class).list();
        } finally {
            session.close();
        }
    }

    // Vender libro (disminuir stock)
    public void venderLibro(int idLibro, int cantidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro libro = session.get(Libro.class, idLibro);
            if (libro != null && libro.getStock() >= cantidad) {
                libro.setStock(libro.getStock() - cantidad);
                session.update(libro);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Devolver libro (aumentar stock)
    public void devolverLibro(int idLibro, int cantidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro libro = session.get(Libro.class, idLibro);
            if (libro != null) {
                libro.setStock(libro.getStock() + cantidad);
                session.update(libro);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Método de búsqueda por título
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Libro l WHERE l.titulo LIKE :titulo";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            query.setParameter("titulo", "%" + titulo + "%");
            return query.getResultList();
        } finally {
            session.close();
        }
    }

 // Método para obtener libros de un autor específico
    public List<Libro> obtenerLibrosDeAutor(String nombreAutor) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT l FROM Libro l JOIN l.autores a WHERE a.nombre = :nombreAutor";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            query.setParameter("nombreAutor", nombreAutor);
            return query.getResultList();
        }
    }
 // Método para obtener libros por categoría
    public List<Libro> obtenerLibrosPorCategoria(String nombreCategoria) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "SELECT l FROM Libro l JOIN l.categorias c WHERE c.nombre = :nombreCategoria";
            Query<Libro> query = session.createQuery(hql, Libro.class);
            query.setParameter("nombreCategoria", nombreCategoria);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
