package ejerciciosbasicos3_tema4;



import ejerciciosbasicos3_tema4.Empresa;
import ejerciciosbasicos3_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModificarRegistro {

    public static void modificar(int id, String nuevoNombre, String nuevoPais) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                empresa.setNombre(nuevoNombre);
                empresa.setPais(nuevoPais);
                session.update(empresa);
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
