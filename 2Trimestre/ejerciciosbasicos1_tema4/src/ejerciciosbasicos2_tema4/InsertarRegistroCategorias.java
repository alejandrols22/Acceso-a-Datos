package ejerciciosbasicos2_tema4;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertarRegistroCategorias {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "1234");
             PreparedStatement stmtInsertar = conn.prepareStatement("INSERT INTO categorias_de_productos (id, categoria, subcategoria) VALUES (?, ?, ?)");
             PreparedStatement stmtMostrar = conn.prepareStatement("SELECT * FROM categorias_de_productos")) {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn.setAutoCommit(false);

            // Insertar registros
            stmtInsertar.setInt(1, 1);
            stmtInsertar.setString(2, "Informática");
            stmtInsertar.setString(3, "portátiles");
            stmtInsertar.executeUpdate();

            stmtInsertar.setInt(1, 2);
            stmtInsertar.setString(2, "Alimentación");
            stmtInsertar.setString(3, "Monitor");
            stmtInsertar.executeUpdate();

            // Mostrar registros
            ResultSet rs = stmtMostrar.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Categoría: " + rs.getString("categoria") + " | Subcategoría: " + rs.getString("subcategoria"));
            }

            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


