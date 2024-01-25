package ejerciciosbasicos2_tema4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarRegistrosCategorias {

    public static void mostrarRegistros() {
        String sqlConsultar = "SELECT * FROM categorias_productos";

        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sqlConsultar);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String categoria = resultSet.getString("categoria");
                String subcategoria = resultSet.getString("subcategoria");

                System.out.println("ID: " + id + ", Categoría: " + categoria + ", Subcategoría: " + subcategoria);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        mostrarRegistros();
    }
}
