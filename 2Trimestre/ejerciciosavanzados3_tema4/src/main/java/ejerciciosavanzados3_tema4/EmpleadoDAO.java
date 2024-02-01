package ejerciciosavanzados3_tema4;


import ejerciciosavanzados3_tema4.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    void agregarEmpleado(Empleado empleado);
    Empleado obtenerEmpleado(int id);
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(int id);
    List<Empleado> obtenerTodosLosEmpleados();
}

