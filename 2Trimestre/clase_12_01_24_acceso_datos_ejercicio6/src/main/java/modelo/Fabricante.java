package modelo;
import java.sql.Date;
import javax.persistence.*;
 
@Entity
@Table(name = "fabricante")

public class Fabricante {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "codigo")
 private int codigo;

    @Column(name = "nombre")
    private String nombre;
      
    // Constructor por defecto requerido por Hibernate
    public Fabricante() {
    }

    // Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad especficos
    public Fabricante(String nombre) {
        this.nombre = nombre;
                
    }

    // Getter y setter para el atributo id
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = id;
    }

    // Getter y setter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
 // Mtodo para imprimir informacin del objeto fabricante
    @Override
    public String toString() {
        return "Alumno{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

