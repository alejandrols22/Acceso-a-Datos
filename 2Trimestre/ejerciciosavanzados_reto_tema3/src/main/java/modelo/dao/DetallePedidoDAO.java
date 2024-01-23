package modelo.dao;

import modelo.DetallePedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class DetallePedidoDAO {
    private SessionFactory sessionFactory;

    public DetallePedidoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear un nuevo detalle de pedido
    public void crearDetallePedido(DetallePedido detallePedido) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detallePedido);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer un detalle de pedido por su ID
    public DetallePedido leerDetallePedido(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(DetallePedido.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar un detalle de pedido
    public void actualizarDetallePedido(DetallePedido detallePedido) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detallePedido);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar un detalle de pedido por su ID
    public void eliminarDetallePedido(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            DetallePedido detallePedido = session.get(DetallePedido.class, id);
            if (detallePedido != null) {
                session.delete(detallePedido);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todos los detalles de pedido
    public List<DetallePedido> listarDetallesPedido() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from DetallePedido", DetallePedido.class).list();
        } finally {
            session.close();
        }
    }
}
