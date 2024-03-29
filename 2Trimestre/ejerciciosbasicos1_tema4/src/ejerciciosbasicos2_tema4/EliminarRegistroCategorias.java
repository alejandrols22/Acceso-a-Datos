package ejerciciosbasicos2_tema4;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistroCategorias {

    public static void main(String[] args) {
        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM categorias_de_productos WHERE id=?")) {

            // Eliminar el registro con id=2
            preparedStatement.setInt(1, 2);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro con ID 2 eliminado con éxito.");
            } else {
                System.out.println("No se encontró el registro con ID: 2");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

