DROP DATABASE IF EXISTS TiendaLibros;
CREATE DATABASE IF NOT EXISTS TiendaLibros;

USE TiendaLibros;

CREATE TABLE IF NOT EXISTS Autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    biografia TEXT
);

CREATE TABLE IF NOT EXISTS Categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS Libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    precio DOUBLE
);

CREATE TABLE IF NOT EXISTS Autor_Libro (
    autor_id INT,
    libro_id INT,
    PRIMARY KEY (autor_id, libro_id),
    FOREIGN KEY (autor_id) REFERENCES Autor(id),
    FOREIGN KEY (libro_id) REFERENCES Libro(id)
);

CREATE TABLE IF NOT EXISTS Categoria_Libro (
    categoria_id INT,
    libro_id INT,
    PRIMARY KEY (categoria_id, libro_id),
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id),
    FOREIGN KEY (libro_id) REFERENCES Libro(id)
);

CREATE TABLE IF NOT EXISTS Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    direccion TEXT
);

CREATE TABLE IF NOT EXISTS Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    total DOUBLE,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE IF NOT EXISTS DetallePedido (
    pedido_id INT,
    libro_id INT,
    cantidad INT,
    precio DOUBLE,
    PRIMARY KEY (pedido_id, libro_id),
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
    FOREIGN KEY (libro_id) REFERENCES Libro(id)
);
