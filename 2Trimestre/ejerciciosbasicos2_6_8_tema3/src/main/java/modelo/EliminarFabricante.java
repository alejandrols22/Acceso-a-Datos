package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class EliminarFabricante {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();
            session.beginTransaction();

            // Realizar una consulta para obtener los datos antes de la eliminación
            String selectHqlBeforeDelete = "FROM Fabricante WHERE codigo = 14";
            Query<Fabricante> selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Fabricante.class);
            List<Fabricante> fabricantesBeforeDelete = selectQueryBeforeDelete.list();

            // Imprimir resultados antes de la eliminación
            System.out.println("Registros en la tabla fabricante antes de la eliminación:");
            for (Fabricante f : fabricantesBeforeDelete) {
                System.out.println(f.toString());
            }

            // Eliminar el registro
            String deleteHql = "DELETE FROM Fabricante WHERE codigo = 14";
            Query<?> deleteQuery = session.createQuery(deleteHql);
            deleteQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos después de la eliminación
            String selectHqlAfterDelete = "FROM Fabricante";
            Query<Fabricante> selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Fabricante.class);
            List<Fabricante> fabricantesAfterDelete = selectQueryAfterDelete.list();

            // Imprimir resultados después de la eliminación
            System.out.println("Registros en la tabla fabricante después de la eliminación:");
            for (Fabricante f : fabricantesAfterDelete) {
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
