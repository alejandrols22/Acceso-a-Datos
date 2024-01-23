package modelo.dao;

import modelo.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class PedidoDAO {
    private SessionFactory sessionFactory;

    public PedidoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear un nuevo pedido
    public void crearPedido(Pedido pedido) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(pedido);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer un pedido por su ID
    public Pedido leerPedido(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Pedido.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar un pedido
    public void actualizarPedido(Pedido pedido) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(pedido);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar un pedido por su ID
    public void eliminarPedido(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pedido pedido = session.get(Pedido.class, id);
            if (pedido != null) {
                session.delete(pedido);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todos los pedidos
    public List<Pedido> listarPedidos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Pedido", Pedido.class).list();
        } finally {
            session.close();
        }
    }
}
