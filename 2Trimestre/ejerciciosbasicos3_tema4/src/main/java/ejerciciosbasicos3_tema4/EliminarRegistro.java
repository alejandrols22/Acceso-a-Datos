package ejerciciosbasicos3_tema4;


import ejerciciosbasicos3_tema4.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarRegistro {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Eliminar el registro por ID
            Empresa empresa = session.get(Empresa.class, 1); // Suponiendo que el ID es 1
            if (empresa != null) {
                session.delete(empresa);
            }

            session.getTransaction().commit();
        }
    }
}

