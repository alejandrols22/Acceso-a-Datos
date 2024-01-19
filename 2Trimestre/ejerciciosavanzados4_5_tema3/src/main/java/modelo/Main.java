package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            Fabricante fabricante = new Fabricante("Fabricante Gaming");
            session.save(fabricante);

            Productos producto = new Productos("PORTATIL Gaming", 3000.00, fabricante);
            session.save(producto);

            Compra compra = new Compra();
            compra.setProducto(producto);
            compra.setUnidades(5);
            compra.setFecha(new Date()); // Fecha actual
            session.save(compra);

            session.getTransaction().commit();

            System.out.println("Fabricante guardado con éxito: " + fabricante);
            System.out.println("Producto guardado con éxito: " + producto);
            System.out.println("Compra guardada con éxito: " + compra);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}



