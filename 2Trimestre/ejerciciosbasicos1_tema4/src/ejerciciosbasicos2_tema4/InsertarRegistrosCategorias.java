package ejerciciosbasicos2_tema4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarRegistrosCategorias {

    public static void insertarRegistro(int id, String categoria, String subcategoria) {
        String sqlInsertar = "INSERT INTO categorias_productos (id, categoria, subcategoria) VALUES (?, ?, ?)";

        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sqlInsertar)) {

            conexion.setAutoCommit(false);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, categoria);
            preparedStatement.setString(3, subcategoria);
            preparedStatement.executeUpdate();

            conexion.commit();
            System.out.println("Registro insertado con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertarRegistro(1, "Informática", "Portátiles");
        insertarRegistro(2, "Alimentación", "Monitor");
    }
}
