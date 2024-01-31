package ejerciciosbasicos5_tema4;

import ejerciciosbasicos5_tema4.Empleado;
import ejerciciosbasicos5_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertarEmpleado {

	public static void insertar(Empleado empleado) {
	    Transaction transaccion = null;
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaccion = session.beginTransaction();
	        session.save(empleado);
	        transaccion.commit();
	    } catch (Exception e) {
	        if (transaccion != null) {
	            transaccion.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
