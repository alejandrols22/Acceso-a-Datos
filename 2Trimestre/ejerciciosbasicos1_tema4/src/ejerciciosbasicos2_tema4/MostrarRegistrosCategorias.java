package ejerciciosbasicos2_tema4;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarRegistrosCategorias {

    public static void main(String[] args) {
        try (Connection conexion = CrearTablaCategorias.obtenerConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM categorias_de_productos");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Categoría: " + resultSet.getString("categoria") + ", Subcategoría: " + resultSet.getString("subcategoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

