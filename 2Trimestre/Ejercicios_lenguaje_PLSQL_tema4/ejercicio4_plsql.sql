SET SERVEROUTPUT ON SIZE UNLIMITED;

DECLARE
  profesor VARCHAR2(100) := 'Cristina Perez';
  asignatura VARCHAR2(100) := 'Acceso a datos';
BEGIN
  DBMS_OUTPUT.PUT_LINE(profesor);
  DBMS_OUTPUT.PUT_LINE('Asignatura: ' || asignatura);
END;
/
