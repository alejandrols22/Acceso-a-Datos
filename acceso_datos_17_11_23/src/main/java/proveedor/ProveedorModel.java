package proveedor;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorModel {
    private Connection conn;

    public ProveedorModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public List<Proveedor> getAllProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM proveedores");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int idProveedor = rs.getInt("id_proveedor");
            String nombreProveedor = rs.getString("nombre_proveedor");
            String tlfProveedor = rs.getString("tlf_proveedor");

            proveedores.add(new Proveedor(idProveedor, nombreProveedor, tlfProveedor));
        }

        stmt.close();
        rs.close();
        return proveedores;
    }

    public void close() throws SQLException {
        conn.close();
    }
}
