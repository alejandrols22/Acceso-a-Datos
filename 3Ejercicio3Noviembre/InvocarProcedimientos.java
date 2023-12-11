package acceso_datos_3_11_23_ejercicio1;


import java.sql.*;

public class InvocarProcedimiento {
    // Punto de entrada principal de la aplicación.
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            // Establecer conexión con la base de datos.
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "password");

            // Preparar la llamada al procedimiento almacenado llamado 'ObtenerClientes'.
            cstmt = conn.prepareCall("{call ObtenerClientes()}");

            // Ejecutar el procedimiento almacenado.
            cstmt.execute();

            // Obtener los resultados si el procedimiento devuelve algún conjunto de resultados.
            rs = cstmt.getResultSet();
            while (rs.next()) {
                // Obtener los datos de cada columna del conjunto de resultados.
                int id = rs.getInt("id");
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                // Imprimir los datos de cada cliente.
                System.out.println("Id: " + id + ", NIF: " + nif + ", Nombre: " + nombre + ", Edad: " + edad);
            }

            // Indicar que el procedimiento ha sido invocado con éxito.
            System.out.println("Procedimiento invocado");

        } catch (SQLException e) {
            // Manejar cualquier error que pueda ocurrir durante la conexión o la ejecución del procedimiento.
            System.out.println("SQLException: " + e.getMessage());
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("SQLException al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
