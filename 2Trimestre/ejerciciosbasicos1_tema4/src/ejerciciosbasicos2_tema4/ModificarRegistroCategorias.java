package ejerciciosbasicos2_tema4;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarRegistroCategorias {

    public static void main(String[] args) {
        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE categorias_de_productos SET subcategoria=? WHERE id=?")) {

            // Modificar el registro con id=2
            preparedStatement.setString(1, "Verduras"); // Nueva subcategoría
            preparedStatement.setInt(2, 2); // ID del registro a modificar
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro modificado con éxito.");
            } else {
                System.out.println("No se encontró el registro con ID: 2");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

