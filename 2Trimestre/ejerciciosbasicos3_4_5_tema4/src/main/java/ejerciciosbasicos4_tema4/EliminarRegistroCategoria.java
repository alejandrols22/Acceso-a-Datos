package ejerciciosbasicos4_tema4;


import ejerciciosbasicos4_tema4.CategoriaProducto;
import ejerciciosbasicos4_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EliminarRegistroCategoria {

    public static void eliminar(int id) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            CategoriaProducto categoriaProducto = session.get(CategoriaProducto.class, id);
            if (categoriaProducto != null) {
                session.delete(categoriaProducto);
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
