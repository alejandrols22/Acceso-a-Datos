package clientes;

import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
    private Connection conn;

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public ClienteModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    // Método para obtener todos los clientes de la base de datos y devolverlos como una lista
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM clientes");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("Id_CLIENTES");  
            String nif = rs.getString("CIF_NIF");  
            String nombre = rs.getString("NOMBRE");  
          
            String edad = "";  

            clientes.add(new Cliente(id, nif, nombre, edad));
        }

        stmt.close();
        rs.close();
        return clientes;
    }

    // Método para cerrar la conexión a la base de datos
    public void close() throws SQLException {
        conn.close();
    }
}