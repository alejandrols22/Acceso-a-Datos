package acceso_datos_1_12_23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4LeerFicheros {
	public static void main(String[] args) {
		try {
			// Creamos el archivo malaga.txt
			File archivo = new File("C:\\prueba1\\ciudades_andalucia.txt");
			// Verificamos si el archivo existe antes de intentar leerlo
			if (!archivo.exists()) {
				System.out.println("El archivo ciudades_andalucia.txt no existe.");
				return; // Salimos del programa si el archivo no existe
			}

			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			// Leemos el contenido del fichero malaga.txt
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			// Cerramos los recursos
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error al leer el archivo ciudades_andalucia.txt");
		}
	}
}
