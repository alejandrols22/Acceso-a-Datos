package ejerciciosbasicos4_tema4;



import ejerciciosbasicos4_tema4.CategoriaProducto;
import ejerciciosbasicos4_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertarRegistroCategoria {

    public static void insertar(CategoriaProducto categoriaProducto) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();
            session.save(categoriaProducto);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            e.printStackTrace();
        }
    }
}
