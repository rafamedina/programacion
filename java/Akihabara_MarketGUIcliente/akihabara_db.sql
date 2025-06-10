CREATE DATABASE IF NOT EXISTS akihabara_db;

USE akihabara_db;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(100),
    precio DECIMAL(10, 2),
    stock INT
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único y auto incremental
    nombre VARCHAR(255) NOT NULL, -- Nombre del cliente, no puede ser nulo
    email VARCHAR(255) NOT NULL UNIQUE, -- Email del cliente, único y no nulo
    telefono VARCHAR(20), -- Teléfono del cliente, opcional
    fecha_registro DATE -- UTILIZAR CURDATE() -- Fecha de registro, con valor por defecto como la fecha actual
);

select * from productos;