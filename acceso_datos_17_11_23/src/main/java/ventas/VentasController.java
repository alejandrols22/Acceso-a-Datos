package ventas;



import java.sql.SQLException;
import java.util.List;

public class VentasController {
    private VentasModel model;
    private VentasView view;

    public VentasController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new VentasModel(dbURL, dbUser, dbPassword);
        view = new VentasView();
    }

    public void mostrarVentas() throws SQLException {
        List<Ventas> ventas = model.getAllVentas();
        view.mostrarVentas(ventas);
    }

    public void cerrarConexion() throws SQLException {
        model.close();
    }
}
