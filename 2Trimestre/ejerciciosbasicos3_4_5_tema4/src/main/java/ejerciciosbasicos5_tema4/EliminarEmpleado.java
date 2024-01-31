package ejerciciosbasicos5_tema4;


import ejerciciosbasicos5_tema4.Empleado;
import ejerciciosbasicos5_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EliminarEmpleado {

    public static void eliminar(int id) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                session.delete(empleado);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            e.printStackTrace();
        }
    }
}
