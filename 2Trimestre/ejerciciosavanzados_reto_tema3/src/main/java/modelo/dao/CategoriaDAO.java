package modelo.dao;

import modelo.Categoria;
import modelo.Libro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoriaDAO {
    private SessionFactory sessionFactory;

    public CategoriaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear una nueva categoría
    public void crearCategoria(Categoria categoria) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(categoria);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer una categoría por su ID
    public Categoria leerCategoria(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Categoria.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar una categoría
    public void actualizarCategoria(Categoria categoria) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(categoria);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar una categoría por su ID
    public void eliminarCategoria(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                session.delete(categoria);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todas las categorías
    public List<Categoria> listarCategorias() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Categoria", Categoria.class).list();
        } finally {
            session.close();
        }
    }
    
    
    
    // Obtener todos los libros en una categoría específica
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
