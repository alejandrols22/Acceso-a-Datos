package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class VerDatosClientes {

	public static void main(String[] args) {
		//EJERCICIO 6
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// Configurar la sesión en el contexto actual
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			// Obtener la sesión actual
			Session session = context.currentSession();

			// Iniciar transacción
			session.beginTransaction();

			// Crear consulta HQL para seleccionar todos los registros de la tabla
			// clientes
			String hql = "FROM Clientes";
			Query<Clientes> query = session.createQuery(hql, Clientes.class);

			// Ejecutar consulta y obtener resultados
			List<Clientes> clientes = query.list();

			// Imprimir resultados
			System.out.println("Registros en la tabla clientes:");
			for (Clientes f : clientes) {
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