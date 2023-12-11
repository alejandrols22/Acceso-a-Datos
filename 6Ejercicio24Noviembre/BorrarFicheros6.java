package accesodatos_24_11_23;

import java.io.File;

public class BorraFicheros6 {
    public static void main(String[] args) {
        File directorio = new File("C:/usuario/DAM");
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    archivo.delete();
                }
            }
        }
    }
}
