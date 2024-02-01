-- Crear el tipo de objeto 'producto'
CREATE OR REPLACE TYPE producto AS OBJECT (
  id_producto NUMBER(4),
  nombre VARCHAR2(30),
  precio VARCHAR2(10),
  unidades NUMBER(4),
  MEMBER FUNCTION get_id_producto RETURN NUMBER
);
/

-- Crear el cuerpo del tipo de objeto 'producto'
CREATE OR REPLACE TYPE BODY producto AS
  MEMBER FUNCTION get_id_producto RETURN NUMBER IS
  BEGIN
    RETURN id_producto;
  END;
END;
/

-- Crear el tipo de objeto 'categoria'
CREATE OR REPLACE TYPE categoria AS OBJECT (
  id_categoria NUMBER(4),
  categoria_nombre VARCHAR2(30),
  subcategoria_nombre VARCHAR2(20),
  pro1 producto,
  pro2 producto,
  MEMBER FUNCTION get_id_categoria RETURN NUMBER
);
/

-- Crear el cuerpo del tipo de objeto 'categoria'
CREATE OR REPLACE TYPE BODY categoria AS
  MEMBER FUNCTION get_id_categoria RETURN NUMBER IS
  BEGIN
    RETURN id_categoria;
  END;
END;
/

-- Bloque anónimo PL/SQL para crear instancias y mostrar los datos
SET SERVEROUTPUT ON SIZE UNLIMITED;

DECLARE
  -- Crear dos instancias de 'producto'
  p1 producto := producto(1234, 'Producto 1', '100.50', 20);
  p2 producto := producto(5678, 'Producto 2', '200.30', 15);

  -- Crear una instancia de 'categoria'
  c1 categoria := categoria(1001, 'Electrónica', 'Smartphones', p1, p2);
BEGIN
  -- Imprimir detalles de la categoría
  DBMS_OUTPUT.PUT_LINE('ID Categoria: ' || c1.get_id_categoria());
  DBMS_OUTPUT.PUT_LINE('Categoria: ' || c1.categoria_nombre);
  DBMS_OUTPUT.PUT_LINE('Subcategoria: ' || c1.subcategoria_nombre);
  
  -- Imprimir detalles del producto 1
  DBMS_OUTPUT.PUT_LINE('Producto 1 ID: ' || c1.pro1.get_id_producto());
  DBMS_OUTPUT.PUT_LINE('Producto 1 Nombre: ' || c1.pro1.nombre);
  DBMS_OUTPUT.PUT_LINE('Producto 1 Precio: ' || c1.pro1.precio);
  DBMS_OUTPUT.PUT_LINE('Producto 1 Unidades: ' || c1.pro1.unidades);
  
  -- Imprimir detalles del producto 2
  DBMS_OUTPUT.PUT_LINE('Producto 2 ID: ' || c1.pro2.get_id_producto());
  DBMS_OUTPUT.PUT_LINE('Producto 2 Nombre: ' || c1.pro2.nombre);
  DBMS_OUTPUT.PUT_LINE('Producto 2 Precio: ' || c1.pro2.precio);
  DBMS_OUTPUT.PUT_LINE('Producto 2 Unidades: ' || c1.pro2.unidades);
END;
/
