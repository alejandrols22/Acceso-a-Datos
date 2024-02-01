CREATE TYPE empleado3 AS OBJECT (
  id_empleado NUMBER(4),
  nombre VARCHAR2(30),
  apellido VARCHAR2(40),
  MAP MEMBER FUNCTION get_id_empleado RETURN NUMBER
);
/

CREATE TYPE BODY empleado3 IS
  MAP MEMBER FUNCTION get_id_empleado RETURN NUMBER IS
  BEGIN
    RETURN id_empleado;
  END;
END;
/
CREATE TYPE departamento AS OBJECT (
  id_departamento NUMBER(4),
  nombre VARCHAR2(30),
  emp empleado3
);
/
SET SERVEROUTPUT ON SIZE UNLIMITED;

DECLARE
  -- Crear un objeto empleado3
  emp3 empleado3 := empleado3(5, 'Ana', 'Ruiz');
  
  -- Crear un objeto departamento con el objeto empleado3
  dep departamento := departamento(1, 'Administración', emp3);
BEGIN
  -- Mostrar información del empleado y su departamento
  DBMS_OUTPUT.PUT_LINE(dep.emp.nombre || ' ' || dep.emp.apellido);
  DBMS_OUTPUT.PUT_LINE('Departamento: ' || dep.nombre);
END;
/

