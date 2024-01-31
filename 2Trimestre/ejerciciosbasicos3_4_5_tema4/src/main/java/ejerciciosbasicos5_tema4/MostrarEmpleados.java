package ejerciciosbasicos5_tema4;

import ejerciciosbasicos5_tema4.Empleado;
import ejerciciosbasicos5_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MostrarEmpleados {

    public static void mostrar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
            List<Empleado> listaEmpleados = query.list();

            for (Empleado empleado : listaEmpleados) {
                System.out.println("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() + ", Pais: " + empleado.getPais() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
