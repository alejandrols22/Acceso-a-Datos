package ejerciciosavanzados1_tema4;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crear una SessionFactory a partir de hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Registrar el error en caso de falla en la creación de SessionFactory
            System.err.println("La creación inicial de SessionFactory falló." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cerrar caches y pools de conexión
        getSessionFactory().close();
    }
}
