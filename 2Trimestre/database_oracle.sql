CREATE TABLE IF NOT EXISTS departamento (
    id_depart NUMBER(10) PRIMARY KEY,
    nombre_depart VARCHAR2 (50)
);

CREATE TABLE IF NOT EXISTS empresa (
    id_empresa NUMBER(10) PRIMARY KEY,
    nombre VARCHAR2 (40),
    pais VARCHAR2 (30)
);
    