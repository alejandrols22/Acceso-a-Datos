package acceso_datos_3_11_23_ejercicio1;


import java.sql.*;

public class InvocarProcedimientos2 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "password");
             CallableStatement cstmt = conn.prepareCall("{CALL ProcedimientoUno()}")) {

            cstmt.execute();
            System.out.println("Procedimiento invocado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al invocar Procedimiento: " + e.getMessage());
        }
    }
}
