package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class ModificarJuego {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Modificar datos de un juego
            String updateHql = "UPDATE Juegos SET nombre = 'Nuevo Nombre', precio = 90.00 WHERE idjuego = 1";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Juegos WHERE idjuego = 1";
            Query<Juegos> selectQuery = session.createQuery(selectHql, Juegos.class);
            List<Juegos> juegos = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla juegos después de la actualización:");
            for (Juegos juego : juegos) {
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
