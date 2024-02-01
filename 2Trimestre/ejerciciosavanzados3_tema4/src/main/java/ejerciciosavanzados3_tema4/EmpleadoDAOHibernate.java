package ejerciciosavanzados3_tema4;


import ejerciciosavanzados3_tema4.EmpleadoDAO;
import ejerciciosavanzados3_tema4.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmpleadoDAOHibernate implements EmpleadoDAO {
    private final Session session;

    public EmpleadoDAOHibernate(Session session) {
        this.session = session;
    }

    public void agregarEmpleado(Empleado empleado) {
        Transaction tx = session.beginTransaction();
        session.save(empleado);
        tx.commit();
    }

    public Empleado obtenerEmpleado(int id) {
        return session.get(Empleado.class, id);
    }

    public void actualizarEmpleado(Empleado empleado) {
        Transaction tx = session.beginTransaction();
        session.update(empleado);
        tx.commit();
    }

    public void eliminarEmpleado(int id) {
        Empleado empleado = obtenerEmpleado(id);
        if (empleado != null) {
            Transaction tx = session.beginTransaction();
            session.delete(empleado);
            tx.commit();
        }
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return session.createQuery("from Empleado", Empleado.class).list();
    }
}
