package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GestorProfesores {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void altaProfesor(Profesor profesor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
        session.close();
    }

    public void consultarProfesores() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Profesor> result = session.createQuery("from Profesor", Profesor.class).list();
        for (Profesor profesor : result) {
            System.out.println(profesorToString(profesor));
        }
        session.getTransaction().commit();
        session.close();
    }

    private String profesorToString(Profesor profesor) {
        return "ID: " + profesor.getId() + "\n" +
               "Nombre: " + profesor.getNombre() + "\n" +
               "Apellidos: " + profesor.getApellidos() + "\n" +
               "Dirección: " + profesor.getDireccion() + "\n" +
               "Código Postal: " + profesor.getCp() + "\n" +
               "Ciudad: " + profesor.getCiudad() + "\n" +
               "Provincia: " + profesor.getProvincia() + "\n" +
               "Teléfono: " + profesor.getTelefono() + "\n" +
               "-----------------------\n";
    }
}
