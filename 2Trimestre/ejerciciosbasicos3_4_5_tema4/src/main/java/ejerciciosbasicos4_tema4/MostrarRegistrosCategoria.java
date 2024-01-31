package ejerciciosbasicos4_tema4;



import ejerciciosbasicos4_tema4.CategoriaProducto;
import ejerciciosbasicos4_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MostrarRegistrosCategoria {

    public static void mostrar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CategoriaProducto> query = session.createQuery("FROM CategoriaProducto", CategoriaProducto.class);
            List<CategoriaProducto> listaCategorias = query.list();

            for (CategoriaProducto categoriaProducto : listaCategorias) {
                System.out.println("ID: " + categoriaProducto.getId() + ", Categoría: " + categoriaProducto.getCategoria() + ", Subcategoría: " + categoriaProducto.getSubcategoria());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
