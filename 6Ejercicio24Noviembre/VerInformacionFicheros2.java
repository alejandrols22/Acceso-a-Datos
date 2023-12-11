package accesodatos_24_11_23;

import java.io.File;

public class VerInformacionFicheros2 {
    public static void main(String[] args) {
        File directorio = new File("C:/usuario/DAM");
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                System.out.println("Nombre: " + archivo.getName());
                System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
                System.out.println("Tamaño: " + archivo.length());
                System.out.println("Es directorio: " + archivo.isDirectory());
                System.out.println("Es fichero: " + archivo.isFile());
                System.out.println("Última modificación: " + archivo.lastModified());
                System.out.println("-----");
            }
        }
    }
}
