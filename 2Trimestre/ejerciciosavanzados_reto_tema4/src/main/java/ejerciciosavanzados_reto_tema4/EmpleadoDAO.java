package ejerciciosavanzados_reto_tema4;


import ejerciciosavanzados_reto_tema4.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    void agregar(Empleado empleado);
    Empleado obtener(Long id);
    void actualizar(Empleado empleado);
    void eliminar(Long id);
    List<Empleado> obtenerTodos();
}
