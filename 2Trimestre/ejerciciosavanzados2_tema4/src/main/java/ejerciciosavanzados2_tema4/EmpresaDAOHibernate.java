package ejerciciosavanzados2_tema4;



import ejerciciosavanzados2_tema4.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmpresaDAOHibernate implements EmpresaDAO {
    private Session session;

    public EmpresaDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public void agregarEmpresa(Empresa empresa) {
        Transaction tx = session.beginTransaction();
        session.save(empresa);
        tx.commit();
    }

    @Override
    public void actualizarEmpresa(Empresa empresa) {
        Transaction tx = session.beginTransaction();
        session.update(empresa);
        tx.commit();
    }

    @Override
    public void eliminarEmpresa(int id) {
        Transaction tx = session.beginTransaction();
        Empresa empresa = session.get(Empresa.class, id);
        if (empresa != null) {
            session.delete(empresa);
        }
        tx.commit();
    }

    @Override
    public Empresa obtenerEmpresa(int id) {
        return session.get(Empresa.class, id);
    }

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() {
        return session.createQuery("from Empresa", Empresa.class).list();
    }
}

