package accesodatos_24_11_23;

import java.io.File;
import java.io.IOException;

public class CrearDirectorioYFicheros4 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("C:/usuario/DAM");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Crear algunos ficheros en el directorio
        for (int i = 1; i <= 3; i++) {
            File fichero = new File(directorio, "fichero" + i + ".txt");
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
        }
    }
}
