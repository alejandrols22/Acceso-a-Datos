package modelo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class ModificarProducto {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Modificar datos de un producto
            String updateHql = "UPDATE Productos SET precio = 1300.0 WHERE id = 2";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Productos WHERE id = 2";
            Query<Productos> selectQuery = session.createQuery(selectHql, Productos.class);
            List<Productos> productos = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla productos después de la actualización:");
            for (Productos producto : productos) {
                System.out.println(producto.toString());
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

