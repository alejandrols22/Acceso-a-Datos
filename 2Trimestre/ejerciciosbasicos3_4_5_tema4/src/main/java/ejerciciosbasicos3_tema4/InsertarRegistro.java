package ejerciciosbasicos3_tema4;




import ejerciciosbasicos3_tema4.Empresa;
import ejerciciosbasicos3_tema4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertarRegistro {

    public static void insertar(Empresa empresa) {
        Transaction transaccion = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaccion = session.beginTransaction();
            session.save(empresa);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null) {
                transaccion.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setId(1);
        empresa.setNombre("Empresa XYZ");
        empresa.setPais("España");
        insertar(empresa);
    }
}
