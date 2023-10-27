package acceso_datos_27_10_23_ejercicio1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class VerInformacion {
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/tienda3";

	public static void main(String[] args) throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,login,password);
				if (conn != null) {
	                System.out.println("Conexion a BBDD " + url + "... Ok");
	                DatabaseMetaData meta = conn.getMetaData();
	                System.out.println("version del driver JDBC " + meta.getDriverVersion());
	                System.out.println("Nombre " + meta.getDatabaseProductName());
	                System.out.println("version " + meta.getDatabaseProductVersion());
	                
	                // Aquí  obtengo las columnas de la tabla llamada "productos"
	                ResultSet columnas = meta.getColumns("tienda3", null, "productos", null); 
	                System.out.println("consulta realizada");
	                System.out.println("BBDD tienda3");
	                System.out.println("columna   tipo    tamaño");
	                while (columnas.next()) {
	                    System.out.println(columnas.getString("COLUMN_NAME") + "   " +
	                                       columnas.getString("TYPE_NAME") + "   " +
	                                       columnas.getInt("COLUMN_SIZE"));
	                }
	            }
	        } finally {
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
	}