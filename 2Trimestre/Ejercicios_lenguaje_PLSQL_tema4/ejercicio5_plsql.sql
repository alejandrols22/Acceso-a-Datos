SET SERVEROUTPUT ON SIZE UNLIMITED;

DECLARE
  id_cliente NUMBER := 1;
  nombre_cliente VARCHAR2(100) := 'Alberto';
  apellido_cliente VARCHAR2(100) := 'Ruiz';
  facturacion_cliente NUMBER := 5000.00;
BEGIN
  DBMS_OUTPUT.PUT_LINE('ID cliente: ' || id_cliente);
  DBMS_OUTPUT.PUT_LINE('Nombre: ' || nombre_cliente);
  DBMS_OUTPUT.PUT_LINE('Apellido: ' || apellido_cliente);
  DBMS_OUTPUT.PUT_LINE('Facturacion: ' || TO_CHAR(facturacion_cliente, '9999990.00'));
  DBMS_OUTPUT.PUT_LINE('ID cliente desde la función: ' || id_cliente);
END;
/

