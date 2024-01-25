package ejerciciosbasicos2_tema4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistroCategorias {

    public static void eliminarRegistro(int id) {
        String sqlEliminar = "DELETE FROM categorias_productos WHERE id=?";

        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sqlEliminar)) {

            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado con éxito.");
            } else {
                System.out.println("No se encontró el registro con ID: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        eliminarRegistro(2);
    }
}
