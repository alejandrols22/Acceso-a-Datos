package acceso_datos_1_12_23;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuFicheros {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("A - Crear carpeta");
            System.out.println("B - Crear fichero");
            System.out.println("C - Borrar fichero");
            System.out.println("D - Borrar carpeta");
            System.out.println("E - Leer fichero");
            System.out.println("F - Salir");
            System.out.print("Opción: ");
            opcion = reader.readLine().toUpperCase();

            switch (opcion) {
                case "A":
                    crearCarpeta(reader);
                    break;
                case "B":
                    crearFichero(reader);
                    break;
                case "C":
                    borrarFichero(reader);
                    break;
                case "D":
                    borrarCarpeta(reader);
                    break;
                case "E":
                    leerFichero(reader);
                    break;
                case "F":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("F"));
    }

    private static void crearCarpeta(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la ruta de la carpeta a crear: ");
        String ruta = reader.readLine();
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta creada exitosamente.");
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }

    private static void crearFichero(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la ruta del fichero a crear: ");
        String ruta = reader.readLine();
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el fichero.");
            }
        } else {
            System.out.println("El fichero ya existe.");
        }
    }

    private static void borrarFichero(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la ruta del fichero a borrar: ");
        String ruta = reader.readLine();
        File fichero = new File(ruta);
        if (fichero.exists()) {
            if (fichero.delete()) {
                System.out.println("Fichero borrado exitosamente.");
            } else {
                System.out.println("No se pudo borrar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    private static void borrarCarpeta(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la ruta de la carpeta a borrar: ");
        String ruta = reader.readLine();
        File carpeta = new File(ruta);
        if (carpeta.exists()) {
            if (carpeta.delete()) { // Esto solo funcionará para directorios vacíos
                System.out.println("Carpeta borrada exitosamente.");
            } else {
                System.out.println("No se pudo borrar la carpeta o no está vacía.");
            }
        } else {
            System.out.println("La carpeta no existe.");
        }
    }

    private static void leerFichero(BufferedReader reader) throws IOException {
        System.out.print("Introduzca la ruta del fichero a leer: ");
        String ruta = reader.readLine();
        File fichero = new File(ruta);
        if (fichero.exists() && !fichero.isDirectory()) {
            Files.lines(Paths.get(ruta)).forEach(System.out::println);
        } else {
            System.out.println("El fichero no existe o es una carpeta.");
        }
    }
}
