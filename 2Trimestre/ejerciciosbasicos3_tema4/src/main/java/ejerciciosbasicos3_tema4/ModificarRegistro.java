package ejerciciosbasicos3_tema4;



import ejerciciosbasicos3_tema4.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ModificarRegistro {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Obtener el registro por ID y modificarlo
            Empresa empresa = session.get(Empresa.class, 1); // Suponiendo que el ID es 1
            if (empresa != null) {
                empresa.setNombre("Nombre Modificado");
                empresa.setPais("Pais Modificado");
                session.update(empresa);
            }

            session.getTransaction().commit();
        }
    }
}
