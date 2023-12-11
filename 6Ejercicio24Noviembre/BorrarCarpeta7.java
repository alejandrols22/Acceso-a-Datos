package accesodatos_24_11_23;

import java.io.File;

public class BorrarCarpeta7 {
    public static void borrarDirectorio(File directorio) {
        File[] archivos = directorio.listFiles();
        if (archivos != null) { // Si el directorio está vacío, listFiles() retorna null
            for (File archivo : archivos) {
                borrarDirectorio(archivo);
            }
        }
        directorio.delete();
    }

    public static void main(String[] args) {
        File directorio = new File("C:/usuario/DAM");
        borrarDirectorio(directorio);
    }
}
