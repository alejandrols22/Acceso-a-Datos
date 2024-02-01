SET SERVEROUTPUT ON SIZE UNLIMITED;
DECLARE
  Interes NUMBER(5,3) := 0.000; -- Inicializado a cero, puedes cambiarlo al valor que desees
  Descripcion VARCHAR2(50) := 'inicial';
  Fecha_max DATE := SYSDATE; -- Inicializado a la fecha actual
  Contabilizado BOOLEAN := TRUE;
  PI CONSTANT REAL := 3.14159;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Interes: ' || TO_CHAR(Interes, 'FM999.999'));
  DBMS_OUTPUT.PUT_LINE('Descripcion: ' || Descripcion);
  DBMS_OUTPUT.PUT_LINE('Fecha_max: ' || TO_CHAR(Fecha_max, 'DD-MON-YYYY'));
  DBMS_OUTPUT.PUT_LINE('Contabilizado: ' || CASE WHEN Contabilizado THEN 'TRUE' ELSE 'FALSE' END);
  DBMS_OUTPUT.PUT_LINE('PI: ' || TO_CHAR(PI));
END;
/
