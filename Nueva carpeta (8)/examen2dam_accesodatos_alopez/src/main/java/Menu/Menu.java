package Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        // muestra menu
        do {
            System.out.println("\n--- Menú de Gestión de Archivos ---");
            System.out.println("1. Crear carpetas o fichero");
            System.out.println("2. Borrar carpeta o fichero");
            System.out.println("3. Ver información del fichero o carpeta");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            // dependiendo de el numero que ponga el usuario hara un diferente metodo
            switch (opcion) {
                case 1:
                    crearArchivoOCarpeta();
                    break;
                case 2:
                    eliminarArchivoOCarpeta();
                    break;
                case 3:
                    verInformacionArchivo();
                    break;
                // metodo para salir del programa
                case 4:
                    System.out.println("¿Está seguro de que desea salir? (s/n)");
                    String confirmar = scanner.nextLine();
                    if (confirmar.equalsIgnoreCase("n")) {
                        opcion = 0; // Continuar en el menú
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    // metodo para crear archivo o carpeta
    private static void crearArchivoOCarpeta() {
        System.out.print("Ingrese el nombre de la carpeta o fichero a crear: ");
        String nombre = scanner.nextLine();
        File archivo = new File(nombre);
        // si existe no se crea ninguna carpeta o fichero
        if (archivo.exists()) {
            System.out.println("El fichero o carpeta ya existe.");
            return;
        }
        // Se creara un fichero solo cuando el nombre posea un .
        if (nombre.contains(".")) { // Es un fichero
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Fichero creado exitosamente.");
                    System.out.print("¿Desea introducir información en el fichero? (s/n): ");
                    String opcion = scanner.nextLine();
                    if (opcion.equalsIgnoreCase("s")) {
                        System.out.print("Ingrese el contenido del fichero: ");
                        String contenido = scanner.nextLine();
                        try (FileWriter writer = new FileWriter(archivo)) {
                            writer.write(contenido);
                        }
                    }
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        } else { // Es una carpeta
            if (archivo.mkdir()) {
                System.out.println("Carpeta creada exitosamente.");
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
        }
    }
    // Metodo para eliminar un archivo o una carpeta
    private static void eliminarArchivoOCarpeta() {
        System.out.print("Ingrese el nombre de la carpeta o fichero a eliminar: ");
        String nombre = scanner.nextLine();
        File archivo = new File(nombre);
        // Si la carpeta no existe no se eliminara ninguna carpeta
        if (!archivo.exists()) {
            System.out.println("El fichero o carpeta no existe.");
            return;
        }
        // si la carpeta tiene un directorio se le preguntara si se le quiere mostrar los datos
        if (archivo.isDirectory()) {
            System.out.print("¿Desea listar los archivos en la carpeta antes de eliminarla? (s/n): ");
            String listar = scanner.nextLine();
            if (listar.equalsIgnoreCase("s")) {
                listarArchivosEnCarpeta(nombre);
            }
        }
        // si el archivo tiene directorio y la lista es mayor a 0 se dira que no esta vacia por lo que no lo borrara
        if (archivo.isDirectory() && archivo.list().length > 0) {
            System.out.println("La carpeta no está vacía.");
            return;
        }
        // si no tiene directorio, lo eliminara
        if (archivo.delete()) {
            System.out.println("Fichero o carpeta eliminado(a) exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el fichero o carpeta.");
        }
    }
    // metodo para ver informacion de un archivo
    private static void verInformacionArchivo() {
        System.out.print("Ingrese el nombre del fichero o carpeta para ver su información: ");
        String nombre = scanner.nextLine();
        File archivo = new File(nombre);
        // Si no existe no mostrara la informacion
        if (!archivo.exists()) {
            System.out.println("El fichero o carpeta no existe.");
            return;
        }
        // Si el archivo tiene directorio se mostrara el listado
        if (archivo.isDirectory()) {
            System.out.print("¿Desea listar los archivos en esta carpeta? (s/n): ");
            String listar = scanner.nextLine();
            if (listar.equalsIgnoreCase("s")) {
                listarArchivosEnCarpeta(nombre);
            }
        }

        System.out.println("Nombre: " + archivo.getName());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("Tamaño: " + archivo.length() + " bytes");
        System.out.println("Modificable: " + archivo.canWrite());
        System.out.println("Legible: " + archivo.canRead());
        System.out.println("Es un directorio: " + archivo.isDirectory());
    }
    // metodo que muestra los archivos que tiene la carpeta
    private static void listarArchivosEnCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (carpeta.isDirectory()) {
            String[] archivos = carpeta.list();
            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos en la carpeta:");
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            } else {
                System.out.println("La carpeta está vacía.");
            }
        } else {
            System.out.println("La ruta proporcionada no es una carpeta.");
        }
    }
}

