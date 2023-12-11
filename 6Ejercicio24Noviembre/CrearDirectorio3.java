package accesodatos_24_11_23;

import java.io.File;

public class CrearDirectorio3 {
    public static void main(String[] args) {
        File directorio = new File("C:/usuario/DAM");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
    }
}
