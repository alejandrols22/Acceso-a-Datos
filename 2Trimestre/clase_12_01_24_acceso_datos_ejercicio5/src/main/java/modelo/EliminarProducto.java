package modelo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class EliminarProducto {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Realizar una consulta para obtener los datos antes de la eliminación
            String selectHqlBeforeDelete = "FROM Productos WHERE id = 1";
            Query<Productos> selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Productos.class);
            List<Productos> productosBeforeDelete = selectQueryBeforeDelete.list();

            // Imprimir resultados antes de la eliminación
            System.out.println("Registros en la tabla productos antes de la eliminación:");
            for (Productos producto : productosBeforeDelete) {
                System.out.println(producto.toString());
            }

            // Eliminar el registro
            String deleteHql = "DELETE FROM Productos WHERE id = 1";
            Query<?> deleteQuery = session.createQuery(deleteHql);
            deleteQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos después de la eliminación
            String selectHqlAfterDelete = "FROM Productos";
            Query<Productos> selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Productos.class);
            List<Productos> productosAfterDelete = selectQueryAfterDelete.list();

            // Imprimir resultados después de la eliminación
            System.out.println("Registros en la tabla productos después de la eliminación:");
            for (Productos producto : productosAfterDelete) {
                System.out.println(producto.toString());
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}
