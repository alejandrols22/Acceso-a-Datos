package modelo.dao;


import modelo.Cliente;
import modelo.Pedido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAO {
    private SessionFactory sessionFactory;

    public ClienteDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Crear un nuevo cliente
    public void crearCliente(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Leer un cliente por su ID
    public Cliente leerCliente(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Cliente.class, id);
        } finally {
            session.close();
        }
    }

    // Actualizar un cliente
    public void actualizarCliente(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(cliente);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Eliminar un cliente por su ID
    public void eliminarCliente(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                session.delete(cliente);
            }
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Cliente", Cliente.class).list();
        } finally {
            session.close();
        }
    }
    
    // Obtener el historial de pedidos de un cliente
    public List<Pedido> obtenerPedidosCliente(int idCliente) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Pedido p WHERE p.cliente.id = :idCliente";
            Query<Pedido> query = session.createQuery(hql, Pedido.class);
            query.setParameter("idCliente", idCliente);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
