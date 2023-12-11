import java.sql.*;

public class VerInformacion {
    // Declarando las credenciales de inicio de sesión y la URL para la conexión a la base de datos
    static String login = "root";
    static String password = ""; // La contraseña no es visible en la imagen
    static String url = "jdbc:mysql://localhost/phoneLand";
    
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            // Intentando establecer una conexión a la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            
            // Si la conexión fue exitosa, imprimir un mensaje de confirmación
            if (conn != null) {
                System.out.println("Conexión a la base de datos '" + "Ok'");
                
                // Recuperando metadatos de la base de datos
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Nombre del servidor: " + meta.getDatabaseProductName());
                System.out.println("Versión del servidor: " + meta.getDatabaseProductVersion());
                
                // Ejecutando una consulta para recuperar metadatos de la tabla 'ventas'
                ResultSet rs = conn.getMetaData().getColumns(null, null, "ventas", null);
                System.out.println("Lista de columnas: ");
                while (rs.next()) {
                    String columnName = rs.getString("COLUMN_NAME");
                    String columnType = rs.getString("TYPE_NAME");
                    int columnSize = rs.getInt("COLUMN_SIZE");
                    
                    // Imprimiendo los detalles de cada columna
                    System.out.println(columnName + " " + columnType + "(" + columnSize + ")");
                }
            }
        } catch (SQLException e) {
            // Si hubo un error, imprimir el mensaje de error
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Asegurando que la conexión a la base de datos se cierre
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    }
}
