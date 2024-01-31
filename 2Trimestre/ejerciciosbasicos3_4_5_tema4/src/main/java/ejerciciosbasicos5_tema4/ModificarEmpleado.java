package ejerciciosbasicos5_tema4;


import ejerciciosbasicos5_tema4.Empleado;
import ejerciciosbasicos5_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModificarEmpleado {

    public static void modificar(int id, String nuevoNombre, String nuevoPais) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                empleado.setNombre(nuevoNombre);
                empleado.setPais(nuevoPais);
                session.update(empleado);
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
