package gestorarchivos;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivos {

    private Scanner scanner = new Scanner(System.in);

    // Método principal para interactuar con el usuario
    public void interactuarConUsuario() {
        System.out.print("Ingrese el nombre de una carpeta o fichero: ");
        String nombre = scanner.nextLine();

        File archivo = new File(nombre);
        // Si el archivo tiene directorio se muestra la informacion
        if (archivo.isDirectory()) {
            System.out.println("Se ha detectado una carpeta.");
            mostrarInformacionArchivo(nombre);
           
        } else if (archivo.isFile()) {
            System.out.println("Se ha detectado un fichero.");
            mostrarInformacionArchivo(nombre);
        } else {
            System.out.print("No existe. ¿Desea crear un fichero? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                try {
                    crearArchivo(nombre);
                    System.out.print("¿Desea introducir información en el fichero? (s/n): ");
                    respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        System.out.print("Ingrese el contenido del fichero: ");
                        String contenido = scanner.nextLine();
                        escribirEnArchivo(nombre, contenido);
                    }
                } catch (IOException e) {
                    System.out.println("Error al crear el archivo: " + e.getMessage());
                }
            }
        }
    }

    // Método para crear un archivo
    public void crearArchivo(String nombre) throws IOException {
        File archivo = new File(nombre);
        if (archivo.createNewFile()) {
            System.out.println("Archivo creado: " + archivo.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    // Método para escribir en un archivo
    public void escribirEnArchivo(String nombre, String contenido) throws IOException {
        FileWriter escritor = new FileWriter(nombre);
        escritor.write(contenido);
        escritor.close();
        System.out.println("Información escrita en el archivo.");
    }

    // Método para mostrar información de un archivo
    public void mostrarInformacionArchivo(String nombre) {
        File archivo = new File(nombre);
        if (archivo.exists()) {
            System.out.println("Nombre del archivo/carpeta: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño del archivo/carpeta: " + archivo.length() + " bytes");
        } else {
            System.out.println("El archivo/carpeta no existe.");
        }
    }

    public static void main(String[] args) {
        GestorArchivos gestor = new GestorArchivos();
        gestor.interactuarConUsuario();
    }
}


