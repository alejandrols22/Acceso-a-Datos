package ejerciciosavanzados1_tema4;


import ejerciciosavanzados1_tema4.EmpresaDAOHibernate;
import ejerciciosavanzados1_tema4.Empresa;
import ejerciciosavanzados1_tema4.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EmpresaDAOHibernate empresaDao = new EmpresaDAOHibernate(session);

        // Mostrar todas las empresas
        System.out.println("Empresas existentes:");
        empresaDao.obtenerTodasLasEmpresas().forEach(empresa -> 
            System.out.println(empresa.getId() + ": " + empresa.getNombre()));

        // Actualizar el nombre de una empresa específica
        Empresa empresa = empresaDao.obtenerEmpresa(1);
        if (empresa != null) {
            empresa.setNombre("Nombre Actualizado");
            empresaDao.actualizarEmpresa(empresa);
        }

        // Cerrar sesión
        session.close();
        HibernateUtil.shutdown();
    }
}
