package accesodatos_24_11_23;

import java.io.File;

public class BorrarFicherosCarpetas8 {
    public static void borrarContenido(File archivo) {
        if (archivo.isDirectory()) {
            File[] archivos = archivo.listFiles();
            if (archivos != null) {
                for (File hijo : archivos) {
                    borrarContenido(hijo);
                }
            }
        }
        archivo.delete();
    }

    public static void main(String[] args) {
        File directorio = new File("C:/usuario/DAM");
        borrarContenido(directorio);
    }
}
