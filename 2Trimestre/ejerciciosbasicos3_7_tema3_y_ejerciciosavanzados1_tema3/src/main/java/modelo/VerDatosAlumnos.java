package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class VerDatosAlumnos {

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

            // Crear consulta HQL para seleccionar todos los registros de la tabla alumnos
            String hql = "FROM Alumnos"; // Asegúrate de que 'Alumnos' sea el nombre correcto de la clase de entidad
            Query<Alumnos> query = session.createQuery(hql, Alumnos.class);

            // Ejecutar consulta y obtener resultados
            List<Alumnos> alumnos = query.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla alumnos:");
            for (Alumnos alumno : alumnos) {
                System.out.println(alumno.toString());
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
