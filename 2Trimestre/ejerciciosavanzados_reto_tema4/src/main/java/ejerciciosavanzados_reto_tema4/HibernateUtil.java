package ejerciciosavanzados_reto_tema4;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ejerciciosavanzados_reto_tema4.Empleado;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crea la SessionFactory desde hibernate.cfg.xml
            return new Configuration()
                    .configure() // Configura Hibernate desde el archivo de configuración
                    .addAnnotatedClass(Empleado.class) // Añade la clase de entidad Empleado
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Muestra un mensaje de error en caso de fallo durante la creación de la SessionFactory
            System.err.println("La creación inicial de SessionFactory ha fallado." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cierra los caches y las conexiones de la pool
        getSessionFactory().close();
    }
}
