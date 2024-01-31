package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;


public class EliminarCliente {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Realizar una consulta para obtener los datos antes de la eliminación
            String selectHqlBeforeDelete = "FROM Clientes WHERE id = 14";
            Query<Clientes> selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Clientes.class);
            List<Clientes> clientesBeforeDelete = selectQueryBeforeDelete.list();

            // Imprimir resultados antes de la eliminación
            System.out.println("Registros en la tabla clientes antes de la eliminación:");
            for (Clientes c : clientesBeforeDelete) {
                System.out.println(c.toString());
            }

            // Eliminar el registro
            String deleteHql = "DELETE FROM Clientes WHERE id = 14";
            Query<?> deleteQuery = session.createQuery(deleteHql);
            deleteQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos después de la eliminación
            String selectHqlAfterDelete = "FROM Clientes";
            Query<Clientes> selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Clientes.class);
            List<Clientes> clientesAfterDelete = selectQueryAfterDelete.list();

            // Imprimir resultados después de la eliminación
            System.out.println("Registros en la tabla clientes después de la eliminación:");
            for (Clientes c : clientesAfterDelete) {
                System.out.println(c.toString());
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
