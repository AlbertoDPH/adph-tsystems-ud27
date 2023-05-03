-- drop database if exists granalmacen;
-- create database granalmacen;
-- Use	granalmacen;

DROP table IF EXISTS venta CASCADE CONSTRAINTS;
DROP table IF EXISTS cajeros CASCADE CONSTRAINTS;
DROP table IF EXISTS productos CASCADE CONSTRAINTS;
DROP table IF EXISTS maquina_registradoras CASCADE CONSTRAINTS;


/*DROP table IF EXISTS venta;
DROP table IF EXISTS cajeros;
DROP table IF EXISTS productos;
DROP table IF EXISTS maquina_registradoras;
*/
create table cajeros(
	codigo int AUTO_INCREMENT,
    nom_apelis nvarchar(255)NOT NULL, 
    PRIMARY KEY(codigo)
);
create table productos(
	codigo int AUTO_INCREMENT,
    nombre nvarchar(100)NOT NULL,
    precio int NOT NULL,
    PRIMARY KEY(codigo)
);
create table maquina_registradoras(
	codigo int AUTO_INCREMENT,
    piso int NOT NULL,
    PRIMARY KEY(codigo)
);
create table venta(
	id int AUTO_INCREMENT,
	id_cajero int NOT NULL,
    id_maquina int NOT NULL,
    id_producto int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT venta_fk1 FOREIGN KEY(id_cajero) REFERENCES cajeros(codigo)ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT venta_fk2 FOREIGN KEY(id_maquina) REFERENCES maquina_registradoras(codigo)ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT venta_fk3 FOREIGN KEY(id_producto) REFERENCES productos(codigo)ON UPDATE CASCADE ON DELETE CASCADE
);

-- Insertar tabla cajeros
INSERT INTO cajeros (nom_apelis) VALUES ('Maria Lopez');
INSERT INTO cajeros (nom_apelis) VALUES ('Carlos Perez');
INSERT INTO cajeros (nom_apelis) VALUES ('Ana Rodriguez');
INSERT INTO cajeros (nom_apelis) VALUES ('Pedro Fernandez');
INSERT INTO cajeros (nom_apelis) VALUES ('Isabel Ramirez');

-- Insertar tabla productos
INSERT INTO productos (nombre, precio) VALUES ('Manzanas', 2);
INSERT INTO productos (nombre, precio) VALUES ('Platanos', 3);
INSERT INTO productos (nombre, precio) VALUES ('Naranjas', 2);
INSERT INTO productos (nombre, precio) VALUES ('Leche', 1);
INSERT INTO productos (nombre, precio) VALUES ('Pan', 1);

-- Insertar maquina_registradoras
INSERT INTO maquina_registradoras (piso) VALUES (1);
INSERT INTO maquina_registradoras (piso) VALUES (1);
INSERT INTO maquina_registradoras (piso) VALUES (2);
INSERT INTO maquina_registradoras (piso) VALUES (2);
INSERT INTO maquina_registradoras (piso) VALUES (3);

-- Insertar venta
INSERT INTO venta (id_cajero, id_maquina, id_producto) VALUES (1, 1, 1);
INSERT INTO venta (id_cajero, id_maquina, id_producto) VALUES (1, 2, 2);
INSERT INTO venta (id_cajero, id_maquina, id_producto) VALUES (2, 3, 3);
INSERT INTO venta (id_cajero, id_maquina, id_producto) VALUES (3, 4, 4);
INSERT INTO venta (id_cajero, id_maquina, id_producto) VALUES (4, 5, 5);

INSERT INTO Usuario (username, password, role) VALUES
('admin', '$2a$12$9ZtlxtT/DcVXrTEP7CD5G.iQEB1zB5Xza32IWpQZNS4NJ8KvVqhCi', 'admin'),
('alberto', '$2a$12$xP79bu.7SwdkeyYHi4kvMOpP9umurJ0DN7c4WbZ1csqXToPs6oG9K', 'user'),	
('usuario3', '$2a$12$XpSsEe7T5ewSNiKRSmyB0OIfCHGk4DnoTzFcW8dHw8RG09b45kF12', 'user3');


