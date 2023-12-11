package accesodatos_24_11_23;

import java.io.File;

public class VerInformacionDirectorios1 {
    public static void main(String[] args) {
        // Crear un objeto File que apunta al directorio deseado.
        File direc = new File("C:\\Directorio\\Ficheros");

        // Imprimir información general sobre el directorio.
        System.out.println("INFORMACION SOBRE EL DIRECTORIO:");

        // Verificar si el directorio existe.
        if (direc.exists()) {
            System.out.println("Nombre del directorio : " + direc.getName());
            System.out.println("Ruta                : " + direc.getPath());
            System.out.println("Ruta absoluta       : " + direc.getAbsolutePath());
            System.out.println("Lectura             : " + direc.canRead());
            System.out.println("Escritura           : " + direc.canWrite());
            System.out.println("Tamaño              : " + direc.length() + " K");
            System.out.println("Directorio          : " + direc.isDirectory());
            System.out.println("Fichero             : " + direc.isFile());
            System.out.println("Nombre del directorio padre: " + direc.getParent());

            // Si es un directorio, listar los archivos y directorios que contiene.
            if (direc.isDirectory()) {
                String[] archivos = direc.list();
                System.out.println("Contenido del directorio:");
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            }
        } else {
            System.out.println("El directorio no existe.");
        }
    }
}
