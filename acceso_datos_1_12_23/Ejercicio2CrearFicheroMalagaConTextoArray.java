package acceso_datos_1_12_23;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaConTextoArray {
    public static void main(String[] args) {
        String ruta = "C:\\prueba1\\";
        String nombreArchivo = "productos.txt";
        String[] contenido = {"Portatil", "Monitor", "Móvil", "Altavoces"};

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo productos.txt creado correctamente");
            for (String content : contenido) {
                fw.write(content + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo productos.txt");
        }
    }
}
