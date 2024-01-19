package modelo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class ModificarFabricante {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Modificar el nombre del fabricante a "Gandalf"
            String updateHql = "UPDATE Fabricante SET nombre = 'Gandalf' WHERE codigo = 14";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Fabricante WHERE codigo = 14";
            Query<Fabricante> selectQuery = session.createQuery(selectHql, Fabricante.class);
            List<Fabricante> fabricantes = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla fabricante después de la actualización:");
            for (Fabricante f : fabricantes) {
                System.out.println(f.toString());
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
