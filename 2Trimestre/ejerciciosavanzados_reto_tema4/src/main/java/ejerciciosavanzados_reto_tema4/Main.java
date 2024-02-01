package ejerciciosavanzados_reto_tema4;


/*
 * CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    departamento VARCHAR(255),
    salario NUMERIC(10, 2)
);

 */
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        EmpleadoDAOHibernate empleadoDao = new EmpleadoDAOHibernate(sessionFactory);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Añadiendo empleado...");
                    Empleado nuevoEmpleado = solicitarDatosEmpleado(new Scanner(System.in));
                    empleadoDao.agregar(nuevoEmpleado);
                    System.out.println("Empleado añadido.");
                    break;
                case 2:
                    System.out.println("Mostrando empleados...");
                    List<Empleado> empleados = empleadoDao.obtenerTodos();
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado);
                    }
                    break;
                case 3:
                    System.out.println("Actualizar empleado...");
                    System.out.print("ID del empleado a actualizar: ");
                    long idActualizar = scanner.nextLong();
                    scanner.nextLine();
                    Empleado empleadoExistente = empleadoDao.obtener(idActualizar);
                    if (empleadoExistente != null) {
                        Empleado datosActualizados = solicitarDatosEmpleado(new Scanner(System.in));
                        datosActualizados.setId(idActualizar); // Mantener el mismo ID
                        empleadoDao.actualizar(datosActualizados);
                        System.out.println("Empleado actualizado.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Eliminar empleado...");
                    System.out.print("ID del empleado a eliminar: ");
                    long idEliminar = scanner.nextLong();
                    empleadoDao.eliminar(idEliminar);
                    System.out.println("Empleado eliminado.");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    HibernateUtil.shutdown(); // Cerrar la SessionFactory
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static Empleado solicitarDatosEmpleado(Scanner scanner) {
        Empleado empleado = new Empleado();
        System.out.print("Nombre: ");
        empleado.setNombre(scanner.nextLine());
        System.out.print("Apellido: ");
        empleado.setApellido(scanner.nextLine());
        System.out.print("Departamento: ");
        empleado.setDepartamento(scanner.nextLine());
        System.out.print("Salario: ");
        empleado.setSalario(scanner.nextDouble());
        scanner.nextLine(); // Consumir la nueva línea restante
        return empleado;
    }
}

