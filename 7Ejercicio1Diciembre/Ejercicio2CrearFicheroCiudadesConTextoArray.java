package acceso_datos_1_12_23;



	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.IOException;

	public class Ejercicio2CrearFicheroCiudadesConTextoArray {
	    public static void main(String[] args) {
	        String ruta = "C:\\prueba1\\";
	        String nombreArchivo = "ciudades_andalucia.txt";
	        String[] contenido = {
	            "Almería", "Cádiz", "Córdoba", "Granada",
	            "Huelva", "Jaén", "Málaga", "Sevilla"
	        };

	        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
	            System.out.println("Archivo ciudades_andalucia.txt creado correctamente");
	            for (String ciudad : contenido) {
	                fw.write(ciudad + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Error al crear el archivo ciudades_andalucia.txt");
	        }
	    }
	}

