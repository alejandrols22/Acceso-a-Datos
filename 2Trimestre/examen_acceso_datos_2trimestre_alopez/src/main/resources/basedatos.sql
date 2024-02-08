CREATE DATABASE IF NOT EXISTS HospitalApp;
USE HospitalApp;

CREATE TABLE IF NOT EXISTS pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    edad INT,
    historial TEXT
);

CREATE TABLE IF NOT EXISTS medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    especialidad VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS citas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_paciente BIGINT,
    id_medico BIGINT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_medico) REFERENCES medicos(id)
);

INSERT INTO pacientes (nombre, apellidos, ciudad, direccion, telefono, edad, historial) VALUES
('Juan', 'Pérez', 'Madrid', 'Calle Falsa 123', '123456789', 30, 'Historial médico de Juan'),
('Laura', 'García', 'Barcelona', 'Avenida Siempre Viva 456', '987654321', 25, 'Historial médico de Laura');


INSERT INTO medicos (nombre, apellidos, especialidad) VALUES
('Carlos', 'Sánchez', 'Cardiología'),
('Ana', 'Martín', 'Dermatología');

INSERT INTO citas (id_paciente, id_medico, fecha, hora) VALUES
(1, 1, '2024-02-10', '09:00:00'),
(2, 2, '2024-02-11', '10:30:00');


