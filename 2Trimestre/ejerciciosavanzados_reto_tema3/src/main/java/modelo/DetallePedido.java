package modelo;

import javax.persistence.*;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cantidad;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public DetallePedido() {
    }

    public DetallePedido(int cantidad, double precio, Pedido pedido, Libro libro) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedido = pedido;
        this.libro = libro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", pedidoId=" + (pedido != null ? pedido.getId() : "Sin pedido") +
                ", libroTitulo=" + (libro != null ? libro.getTitulo() : "Sin libro") +
                '}';
    }
}
