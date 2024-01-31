package ejerciciosbasicos5_tema4;


import ejerciciosbasicos5_tema4.Empleado;
import ejerciciosbasicos5_tema4.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        // Crear y guardar un nuevo empleado
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setId(1); // Asegúrate de que este ID sea único
        nuevoEmpleado.setNombre("Juan Pérez");
        nuevoEmpleado.setPais("España");
        InsertarEmpleado.insertar(nuevoEmpleado);

        // Actualizar los datos de un empleado existente
        ModificarEmpleado.modificar(1, "Juan Pérez", "España");

        // Mostrar todos los empleados
        System.out.println("Lista de empleados después de la inserción y actualización:");
        MostrarEmpleados.mostrar();

        // Eliminar un empleado
        EliminarEmpleado.eliminar(1);

        // Mostrar todos los empleados después de la eliminación
        System.out.println("Lista de empleados después de la eliminación:");
        MostrarEmpleados.mostrar();

        // Cerrar la SessionFactory al final
        HibernateUtil.shutdown();
    }
}
