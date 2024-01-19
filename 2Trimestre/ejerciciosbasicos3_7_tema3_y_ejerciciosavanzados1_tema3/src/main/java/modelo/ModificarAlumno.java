package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class ModificarAlumno {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Modificar el nombre y apellido de un alumno
            String updateHql = "UPDATE Alumnos SET nombre = 'Gandalf', apellido1 = 'El Gris' WHERE id = 5";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Alumnos WHERE id = 5";
            Query<Alumnos> selectQuery = session.createQuery(selectHql, Alumnos.class);
            List<Alumnos> alumnos = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla alumnos después de la actualización:");
            for (Alumnos a : alumnos) {
                System.out.println(a.toString());
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
