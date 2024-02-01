CREATE TYPE empleado1 AS OBJECT (
  id_empleado NUMBER(4),
  nombre VARCHAR2(30),
  apellido VARCHAR2(40),
  MAP MEMBER FUNCTION get_id_empleado RETURN NUMBER
);
/

CREATE TYPE BODY empleado1 AS
  MAP MEMBER FUNCTION get_id_empleado RETURN NUMBER IS
  BEGIN
    RETURN id_empleado;
  END;
END;
/

CREATE OR REPLACE PROCEDURE ejecutar_bloque_plsql(p_output OUT VARCHAR2) AS
  emp empleado1;
BEGIN
  -- Inicializar la variable empleado
  emp := empleado1(1, 'Alberto', 'Ruiz');

  -- Acceder a los atributos del objeto
  p_output := 'ID Empleado: ' || emp.id_empleado || CHR(10) ||
              'Nombre: ' || emp.nombre || CHR(10) ||
              'Apellido: ' || emp.apellido || CHR(10) ||
              'ID Empleado desde la función: ' || emp.get_id_empleado();
END;
/