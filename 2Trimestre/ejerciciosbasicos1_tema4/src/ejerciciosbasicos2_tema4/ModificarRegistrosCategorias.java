package ejerciciosbasicos2_tema4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarRegistrosCategorias {

    public static void modificarRegistro(int id, String nuevaSubcategoria) {
        String sqlActualizar = "UPDATE categorias_productos SET subcategoria=? WHERE id=?";

        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sqlActualizar)) {

            preparedStatement.setString(1, nuevaSubcategoria);
            preparedStatement.setInt(2, id);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro actualizado con éxito.");
            } else {
                System.out.println("No se encontró el registro con ID: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        modificarRegistro(2, "Verduras");
    }
}
