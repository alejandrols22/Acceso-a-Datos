package ejerciciosbasicos4_tema4;



import ejerciciosbasicos4_tema4.CategoriaProducto;
import ejerciciosbasicos4_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModificarRegistroCategoria {

    public static void modificar(int id, String nuevaCategoria, String nuevaSubcategoria) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();

            CategoriaProducto categoriaProducto = session.get(CategoriaProducto.class, id);
            if (categoriaProducto != null) {
                categoriaProducto.setCategoria(nuevaCategoria);
                categoriaProducto.setSubcategoria(nuevaSubcategoria);
                session.update(categoriaProducto);
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
