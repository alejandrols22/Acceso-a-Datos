package acceso_datos_1_12_23;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaConTexto {
    public static void main(String[] args) {
        String ruta = "C:\\prueba1\\";
        String nombreArchivo = "malaga.txt";
        String contenido = "Málaga es lo mejor del mundo";
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo malaga.txt creado correctamente.");
            fw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo malaga.txt");
        }
    }
}
