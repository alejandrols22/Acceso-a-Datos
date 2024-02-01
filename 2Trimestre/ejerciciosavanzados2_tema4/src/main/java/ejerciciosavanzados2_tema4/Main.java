package ejerciciosavanzados2_tema4;


import ejerciciosavanzados2_tema4.EmpresaDAOHibernate;
import ejerciciosavanzados2_tema4.Empresa;
import ejerciciosavanzados2_tema4.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EmpresaDAOHibernate empresaDao = new EmpresaDAOHibernate(session);

        // Añadir un nuevo registro
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.setId(6);
        nuevaEmpresa.setNombre("Juan");
        nuevaEmpresa.setPais("España");
        empresaDao.agregarEmpresa(nuevaEmpresa);

        // Modificar el registro
        Empresa empresaModificada = empresaDao.obtenerEmpresa(6);
        if (empresaModificada != null) {
            empresaModificada.setNombre("Pedro");
            empresaDao.actualizarEmpresa(empresaModificada);
        }

        // Eliminar el registro
        empresaDao.eliminarEmpresa(6);

        // Cerrar la sesión
        session.close();
        HibernateUtil.shutdown();
    }
}
