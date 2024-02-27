package modelo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
            System.out.println(profesor.getNombre() + " " + profesor.getApellidos());
        }
        session.getTransaction().commit();
        session.close();
    }
}
