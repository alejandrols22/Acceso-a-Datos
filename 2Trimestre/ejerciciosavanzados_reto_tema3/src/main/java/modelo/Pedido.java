package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;
    private double total;
    private double descuento; // Campo añadido para manejar descuentos

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private Set<DetallePedido> detallePedidos;

    public Pedido() {
    }
    
    public Pedido(Date fecha, double total, Cliente cliente) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                ", descuento=" + descuento +
                '}';
    }
}
