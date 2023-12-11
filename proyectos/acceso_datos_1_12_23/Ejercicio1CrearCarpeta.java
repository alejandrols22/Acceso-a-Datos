package acceso_datos_1_12_23;

import java.io.File;

public class Ejercicio1CrearCarpeta {
    public static void main(String[] args) {
        String ruta = "c:\\prueba1\\";
        File fichero = new File(ruta);

        if (fichero.mkdirs()) {
            System.out.println("Carpeta creada");
        } else {
            // Manejar errores
            System.err.println("No se pudo crear la carpeta");
            if (fichero.exists()) {
                System.err.println("La carpeta ya existe");
            } else if (!fichero.getParentFile().canWrite()) {
                System.err.println("No se tienen permisos de escritura en la carpeta padre");
            } else if (!fichero.getParentFile().exists()) {
                System.err.println("La ruta de la carpeta padre no existe");
            }
        }
    }
}
