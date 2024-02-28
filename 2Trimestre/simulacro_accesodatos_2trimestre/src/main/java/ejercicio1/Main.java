package ejercicio1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProfesores gestor = new GestorProfesores();
        
        while (true) {
            System.out.println("\nGestión de Profesores");
            System.out.println("1. Dar de alta un profesor");
            System.out.println("2. Consultar profesores");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            
            switch (opcion) {
                case 1:
                    Profesor profesor = new Profesor();
                    System.out.print("Ingrese nombre: ");
                    profesor.setNombre(scanner.nextLine());
                    System.out.print("Ingrese apellidos: ");
                    profesor.setApellidos(scanner.nextLine());
                    System.out.print("Ingrese dirección: ");
                    profesor.setDireccion(scanner.nextLine());
                    System.out.print("Ingrese código postal: ");
                    profesor.setCp(scanner.nextLine());
                    System.out.print("Ingrese ciudad: ");
                    profesor.setCiudad(scanner.nextLine());
                    System.out.print("Ingrese provincia: ");
                    profesor.setProvincia(scanner.nextLine());
                    System.out.print("Ingrese teléfono: ");
                    profesor.setTelefono(scanner.nextLine());
                    
                    gestor.altaProfesor(profesor);
                    System.out.println("Profesor añadido exitosamente.");
                    break;
                case 2:
                    System.out.println("\nLista de Profesores:");
                    gestor.consultarProfesores();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
