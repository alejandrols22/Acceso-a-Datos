
-- Ahora, conectarse a la base de datos `empleados` y ejecutar:
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    departamento VARCHAR(255),
    salario NUMERIC(10, 2)
);
