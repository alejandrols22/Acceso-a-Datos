package ventas;


import java.sql.Date;

public class Ventas {
    private int idVentas;
    private int idProductos;
    private int idClientes;
    private String fechaDeVenta;
    private int unidades;
    private Date femision;

    // Constructor
    public Ventas(int idVentas, int idProductos, int idClientes, String fechaDeVenta, int unidades, Date femision) {
        this.idVentas = idVentas;
        this.idProductos = idProductos;
        this.idClientes = idClientes;
        this.fechaDeVenta = fechaDeVenta;
        this.unidades = unidades;
        this.femision = femision;
    }

    // Getters
    public int getIdVentas() {
        return idVentas;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public String getFechaDeVenta() {
        return fechaDeVenta;
    }

    public int getUnidades() {
        return unidades;
    }

    public Date getFemision() {
        return femision;
    }
}
