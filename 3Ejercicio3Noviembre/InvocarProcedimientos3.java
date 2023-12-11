package acceso_datos_3_11_23_ejercicio1;


import java.sql.*;

public class InvocarProcedimientos3 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "password");
             CallableStatement cstmt = conn.prepareCall("{CALL ProcedimientoDos(?)}")) {
            
            cstmt.setInt(1, 123); 
            cstmt.execute();
            System.out.println("Procedimiento invocado correctamente con el parámetro de entrada.");

        } catch (SQLException e) {
            System.out.println("Error al invocar Procedimiento : " + e.getMessage());
        }
    }
}
