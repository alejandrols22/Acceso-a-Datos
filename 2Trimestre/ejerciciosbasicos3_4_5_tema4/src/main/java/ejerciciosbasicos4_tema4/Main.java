package ejerciciosbasicos4_tema4;


import ejerciciosbasicos4_tema4.CategoriaProducto;
import ejerciciosbasicos4_tema4.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        // Insertar una nueva categoría
        CategoriaProducto nuevaCategoria = new CategoriaProducto();
        nuevaCategoria.setId(1);
        nuevaCategoria.setCategoria("Electrónica");
        nuevaCategoria.setSubcategoria("Smartphones");
        InsertarRegistroCategoria.insertar(nuevaCategoria);

        // Modificar una categoría existente
        ModificarRegistroCategoria.modificar(1, "Electrónica", "Tablets");

        // Mostrar todas las categorías
        MostrarRegistrosCategoria.mostrar();

        // Eliminar una categoría
        EliminarRegistroCategoria.eliminar(1);

        // Cerrar la SessionFactory al final
        HibernateUtil.shutdown();
    }
}
