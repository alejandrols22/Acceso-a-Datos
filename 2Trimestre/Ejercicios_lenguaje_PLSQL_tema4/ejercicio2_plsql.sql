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

SET SERVEROUTPUT ON SIZE UNLIMITED;

DECLARE
  -- Declarar una variable del tipo empleado1
  emp empleado1;
BEGIN
  -- Inicializar la variable emp con valores para id_empleado, nombre y apellido
  emp := empleado1(1, 'John', 'Doe');

  -- Acceder a los atributos del objeto emp y mostrarlos
  DBMS_OUTPUT.PUT_LINE('ID Empleado: ' || emp.id_empleado);
  DBMS_OUTPUT.PUT_LINE('Nombre: ' || emp.nombre);
  DBMS_OUTPUT.PUT_LINE('Apellido: ' || emp.apellido);

  -- Invocar la función get_id_empleado y mostrar el resultado
  DBMS_OUTPUT.PUT_LINE('ID Empleado desde la función: ' || emp.get_id_empleado());
END;
/

