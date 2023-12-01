package acceso_datos_1_12_23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class EjercicioLeerTodosLosFicheros {

    public static void main(String[] args) {
        String[] ciudades = {"Malaga.txt", "Cordoba.txt", "Cadiz.txt"};

        for (String ciudad : ciudades) {
            try (BufferedReader br = new BufferedReader(new FileReader(Paths.get("C:\\prueba1\\" + ciudad).toString()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("Fichero " + ciudad + " localizado y leído.");
            } catch (IOException e) {
                System.out.println("No se pudo leer el fichero " + ciudad);
            }
        }
    }
}
