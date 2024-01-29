package ejerciciosbasicos3_tema4;



import ejerciciosbasicos3_tema4.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarRegistro {

    public static void main(String[] args) {
        // Configuración de Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Crear y guardar una entidad Empresa
        Empresa empresa = new Empresa();
        empresa.setId(1);
        empresa.setNombre("Empresa XYZ");
        empresa.setPais("España");
        session.save(empresa);

        session.getTransaction().commit();
        session.close();
    }
}
