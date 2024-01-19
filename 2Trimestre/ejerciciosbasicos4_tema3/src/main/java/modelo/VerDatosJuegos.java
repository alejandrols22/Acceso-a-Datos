package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class VerDatosJuegos {

    public static void main(String[] args) {
        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Configurar la sesión en el contexto actual
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            // Obtener la sesión actual
            Session session = context.currentSession();

            // Iniciar transacción
            session.beginTransaction();

            // Crear consulta HQL para seleccionar todos los registros de la tabla juegos
            String hql = "FROM Juegos"; // Asegúrate de que 'Alumnos' sea el nombre correcto de la clase de entidad
            Query<Juegos> query = session.createQuery(hql, Juegos.class);

            // Ejecutar consulta y obtener resultados
            List<Juegos> Juegos = query.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla alumnos:");
            for (Juegos juego : Juegos) {
                System.out.println(juego.toString());
            }

            // Hacer commit de la transacción
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Desligar la sesión del contexto
            context.unbind(sessionFactory);
            // Cerrar la sesión de Hibernate
            sessionFactory.close();
        }
    }
}