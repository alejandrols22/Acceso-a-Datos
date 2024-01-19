package modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_fabricante")
    private int codigo;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Productos> productos = new HashSet<>();

    public Fabricante() {
    }

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Productos> getProductos() {
        return productos;
    }

    public void setProductos(Set<Productos> productos) {
        this.productos = productos;
    }

    public void addProducto(Productos producto) {
        productos.add(producto);
        producto.setFabricante(this);
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


