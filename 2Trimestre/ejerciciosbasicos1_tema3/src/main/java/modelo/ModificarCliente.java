package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class ModificarCliente {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Modificar el nombre del cliente
            String updateHql = "UPDATE Clientes SET nombre = 'Gandalf' WHERE id = 9";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Clientes WHERE id = 9";
            Query<Clientes> selectQuery = session.createQuery(selectHql, Clientes.class);
            List<Clientes> clientes = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla clientes después de la actualización:");
            for (Clientes c : clientes) {
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
