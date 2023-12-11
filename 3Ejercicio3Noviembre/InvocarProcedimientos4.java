package acceso_datos_3_11_23_ejercicio1;


import java.sql.*;

public class InvocarProcedimientos4 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "password");
             CallableStatement cstmt = conn.prepareCall("{CALL Procedimiento(?)}")) {
            
            cstmt.setString(1, "parametro"); // Suponiendo que el procedimiento espera un VARCHAR como parámetro.
            boolean hasResults = cstmt.execute();

            if (hasResults) {
                try (ResultSet rs = cstmt.getResultSet()) {
                    while (rs.next()) {
                        // Procesar los resultados aquí
                        System.out.println(rs.getString(1)); // Asumiendo que el resultado es un VARCHAR.
                    }
                }
            }
            System.out.println("Procedimiento  invocado correctamente con el parámetro de entrada y se procesaron los resultados.");

        } catch (SQLException e) {
            System.out.println("Error al invocar Procedimiento : " + e.getMessage());
        }
    }
}
