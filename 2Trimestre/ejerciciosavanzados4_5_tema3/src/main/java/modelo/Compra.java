package modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompras")
    private int idcompras;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(name = "unidades")
    private Integer unidades;

    public Compra() {
    }

    public int getIdcompras() {
        return idcompras;
    }

    public void setIdcompras(int idcompras) {
        this.idcompras = idcompras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idcompras=" + idcompras +
                ", fecha=" + fecha +
                ", producto=" + (producto != null ? producto.getNombre() : "Sin producto") +
                ", unidades=" + unidades +
                '}';
    }
}

