package simulacro_10_11_23;

import java.sql.*;

public class InvocarProcedimiento {

    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection("jdbc:mysql://localhost/simulacro", "root", "");

            // Invocar el procedimiento almacenado
            cstmt = conn.prepareCall("{CALL ObtenerClientes()}");
            rs = cstmt.executeQuery();

            // Procesar los resultados si los hay
            while (rs.next()) {
               
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet, CallableStatement y Connection
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
