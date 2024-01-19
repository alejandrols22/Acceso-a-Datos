package gestorinformacion;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.Scanner;

	public class GestorInformacion {

	    // Método para mostrar información de una carpeta
	    public void mostrarInformacionCarpeta(String nombreCarpeta) {
	        File carpeta = new File(nombreCarpeta);
	        if (carpeta.exists() && carpeta.isDirectory()) {
	            System.out.println("Nombre de la carpeta: " + carpeta.getName());
	            System.out.println("Tamaño: " + carpeta.length() + " bytes");

	            File[] archivos = carpeta.listFiles();
	            if (archivos != null) {
	                System.out.println("Archivos contenidos:");
	                for (File archivo : archivos) {
	                    System.out.println(" - " + archivo.getName());
	                }
	            }
	        } else {
	            System.out.println("La carpeta no existe o no es un directorio.");
	        }
	    }

	    // Método para mostrar información de un fichero
	    public void mostrarInformacionFichero(String nombreFichero) {
	        File fichero = new File(nombreFichero);
	        if (fichero.exists() && fichero.isFile()) {
	            System.out.println("Nombre del fichero: " + fichero.getName());
	            System.out.println("Tamaño: " + fichero.length() + " bytes");

	            // Mostrar contenido del fichero si no es demasiado grande
	            if (fichero.length() < 10000) { // Ejemplo de límite de tamaño
	                try {
	                    String contenido = new String(Files.readAllBytes(Paths.get(nombreFichero)));
	                    System.out.println("Contenido del fichero:\n" + contenido);
	                } catch (IOException e) {
	                    System.out.println("Error al leer el contenido del fichero.");
	                }
	            }
	        } else {
	            System.out.println("El fichero no existe o es un directorio.");
	        }
	    }

	    // Método para mostrar el menú y gestionar la selección del usuario
	    public void mostrarMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("1. Ver Información de Carpeta");
	            System.out.println("2. Ver Información de Fichero");
	            System.out.println("3. Volver al Menú Principal");
	            System.out.print("Seleccione una opción: ");
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer del escáner

	            switch (opcion) {
	                case 1:
	                    System.out.print("Introduzca el nombre de la carpeta: ");
	                    String nombreCarpeta = scanner.nextLine();
	                    mostrarInformacionCarpeta(nombreCarpeta);
	                    break;
	                case 2:
	                    System.out.print("Introduzca el nombre del fichero: ");
	                    String nombreFichero = scanner.nextLine();
	                    mostrarInformacionFichero(nombreFichero);
	                    break;
	                case 3:
	                    System.out.println("Regresando al menú principal...");
	                    break;
	                default:
	                    System.out.println("Opción no válida");
	            }
	        } while (opcion != 3);
	    }
	}


