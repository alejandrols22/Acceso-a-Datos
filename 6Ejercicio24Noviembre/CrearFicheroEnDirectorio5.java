package accesodatos_24_11_23;

import java.io.File;
import java.io.IOException;

public class CrearFicheroEnDirectorio5 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("C:/usuario/DAM");
        File fichero = new File(directorio, "nuevoFichero.txt");

        if (directorio.exists() && directorio.isDirectory()) {
            fichero.createNewFile();
        }
    }
}
