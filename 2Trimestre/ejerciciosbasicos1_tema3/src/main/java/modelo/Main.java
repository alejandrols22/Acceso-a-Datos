package modelo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {
	
	public static void main(String[] args) {
		
		// Configurar la sesion de Hibernate
		SessionFactory sessionFactory = (SessionFactory) new Configuration()
				.configure()
				
				// .configure("hibernate.cfg.xml") 
				// Ruta del archivo de configuracion de Hibernate
				.buildSessionFactory(); // Construit la sesion del Hibernate
		
		// Configurar la sesion en el contexto actual
		ThreadLocalSessionContext context = new
	ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		
		try {
			// Crear objeto cliente
			Clientes cliente = new Clientes("Eva", "Sevilla");
			
			
			// Obtener la sesion actual
			Session session = context.currentSession();
			
			// Iniciar transaccion
			session.beginTransaction();
			
			// Guardar objeto en la base de datos
			session.save(cliente);
			
			// Hacer commit de la transaccion
			session.getTransaction().commit();
			
			// Imprimir cliente guardado en la base de datos
			System.out.println("Cliente guardado + " + cliente);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Desligar la sesion del contexto
			ThreadLocalSessionContext.unbind(sessionFactory);
			// Cerrar la sesion de Hibernate
			sessionFactory.close();
		}
	}

}
