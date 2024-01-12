package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class VerDatosProductos {

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
            String hql = "FROM Productos"; // Asegúrate de que 'Alumnos' sea el nombre correcto de la clase de entidad
            Query<Productos> query = session.createQuery(hql, Productos.class);

            // Ejecutar consulta y obtener resultados
            List<Productos> Productos = query.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla productos:");
            for (Productos producto : Productos) {
                System.out.println(producto.toString());
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