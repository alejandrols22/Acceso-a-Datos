package ejerciciosbasicos3_tema4;


import ejerciciosbasicos3_tema4.Empresa;
import ejerciciosbasicos3_tema4.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        // Insertar un registro
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.setId(1);
        nuevaEmpresa.setNombre("Empresa XYZ");
        nuevaEmpresa.setPais("España");
        InsertarRegistro.insertar(nuevaEmpresa);

        // Modificar un registro
        ModificarRegistro.modificar(1, "Empresa ABC", "USA");

        // Mostrar registros
        MostrarRegistros.mostrar();

        // Eliminar un registro
        EliminarRegistro.eliminar(1);

        // Cerrar la SessionFactory al final
        HibernateUtil.shutdown();
    }
}
