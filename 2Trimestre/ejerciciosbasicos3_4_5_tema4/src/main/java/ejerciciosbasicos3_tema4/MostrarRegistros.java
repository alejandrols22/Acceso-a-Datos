package ejerciciosbasicos3_tema4;


import ejerciciosbasicos3_tema4.Empresa;
import ejerciciosbasicos3_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MostrarRegistros {

    public static void mostrar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Empresa> query = session.createQuery("FROM Empresa", Empresa.class);
            List<Empresa> listaEmpresas = query.list();

            for (Empresa empresa : listaEmpresas) {
                System.out.println(empresa.getId() + " - " + empresa.getNombre() + " - " + empresa.getPais());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
