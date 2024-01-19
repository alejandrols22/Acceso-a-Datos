package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class EliminarJuego {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Realizar una consulta para obtener los datos antes de la eliminación
            String selectHqlBeforeDelete = "FROM Juegos WHERE idjuego = 1";
            Query<Juegos> selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Juegos.class);
            List<Juegos> juegosBeforeDelete = selectQueryBeforeDelete.list();

            // Imprimir resultados antes de la eliminación
            System.out.println("Registros en la tabla juegos antes de la eliminación:");
            for (Juegos juego : juegosBeforeDelete) {
                System.out.println(juego.toString());
            }

            // Eliminar el registro
            String deleteHql = "DELETE FROM Juegos WHERE idjuego = 1";
            Query<?> deleteQuery = session.createQuery(deleteHql);
            deleteQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos después de la eliminación
            String selectHqlAfterDelete = "FROM Juegos";
            Query<Juegos> selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Juegos.class);
            List<Juegos> juegosAfterDelete = selectQueryAfterDelete.list();

            // Imprimir resultados después de la eliminación
            System.out.println("Registros en la tabla juegos después de la eliminación:");
            for (Juegos juego : juegosAfterDelete) {
                System.out.println(juego.toString());
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

