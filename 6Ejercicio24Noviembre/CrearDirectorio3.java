package accesodatos_24_11_23;

import java.io.File;

public class CrearDirectorio3 {
    public static void main(String[] args) {
        String ruta = ".\\src\\ficheros\\";
        String carpeta = "ejercicio1";
        File directorio = new File(ruta + carpeta);

        if (directorio.exists()) {
            System.out.println("La carpeta existe.");
        } else {
            boolean wasDirectoryMade = directorio.mkdir();
            if(wasDirectoryMade) {
                System.out.println("Carpeta creada");
            } else {
                System.out.println("No se pudo crear la carpeta");
            }
        }
    }
}