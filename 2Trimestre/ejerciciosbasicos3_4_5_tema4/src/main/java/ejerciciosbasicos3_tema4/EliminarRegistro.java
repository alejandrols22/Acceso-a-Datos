package ejerciciosbasicos3_tema4;



import ejerciciosbasicos3_tema4.Empresa;
import ejerciciosbasicos3_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EliminarRegistro {

    public static void eliminar(int id) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                session.delete(empresa);
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

