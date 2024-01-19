package gestorborrado;

import java.io.File;
import java.util.Scanner;

public class GestorBorrado {
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        // muestra menu borrado y sus opciones
        do {
            System.out.println("\n--- Menú de Borrado ---");
            System.out.println("1. Borrar Carpeta");
            System.out.println("2. Borrar Fichero");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    borrarCarpeta();
                    break;
                case 2:
                    borrarFichero();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
    // Metodo para borrar una carpeta
    private static void borrarCarpeta() {
        System.out.print("Ingrese el nombre de la carpeta a borrar: ");
        String nombreCarpeta = scanner.nextLine();
        File carpeta = new File(nombreCarpeta);
        // si la carpeta no existe o no tiene directorio se informara al usuario
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La carpeta no existe o el nombre corresponde a un fichero.");
            return;
        }
        // si la carpeta tiene archivos no se podra borrar
        String[] archivos = carpeta.list();
        if (archivos != null && archivos.length > 0) {
            System.out.println("La carpeta no está vacía y no puede ser borrada.");
            return;
        }
        
        if (carpeta.delete()) {
            System.out.println("Carpeta borrada exitosamente.");
        } else {
            System.out.println("No se pudo borrar la carpeta.");
        }
    }
    // metodo para borrar ficheros
    private static void borrarFichero() {
        System.out.print("Ingrese el nombre del fichero a borrar: ");
        String nombreFichero = scanner.nextLine();
        File fichero = new File(nombreFichero);
        // si el fichero no existe o no tiene directorio se informara al usuario
        if (!fichero.exists() || fichero.isDirectory()) {
            System.out.println("El fichero no existe o el nombre corresponde a una carpeta.");
            return;
        }

        if (fichero.delete()) {
            System.out.println("Fichero borrado exitosamente.");
        } else {
            System.out.println("No se pudo borrar el fichero.");
        }
    }

    // Método main para mostar el menu de borrado
    public static void main(String[] args) {
        mostrarMenu();
    }
}
