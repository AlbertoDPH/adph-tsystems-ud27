-- drop database if exists piezasproveedores;
-- create database piezasproveedores;
-- use piezasproveedores;

DROP table IF EXISTS suministra;
DROP table IF EXISTS piezas;
DROP table IF EXISTS proveedores;
DROP table IF EXISTS usuario;

/*Creamos la primera tabla que no tiene ninguna clave foránea*/
CREATE TABLE proveedores(
id INT auto_increment,
nombre nvarchar(100),
primary key(id)
);

/*Creamos la segunda tabla que no tiene ninguna clave foránea*/
CREATE TABLE piezas(
id INT auto_increment,
nombre nvarchar(100),
primary key(id)
);

/*Creamos la tercera tabla que tiene clave foránea que no deje eliminar
pero que si actualizada en cascata*/
CREATE TABLE suministra(
id INT auto_increment,  
id_pieza int,
id_proveedor int,
precio int,
primary key (id),

CONSTRAINT suministra_fk1 foreign key(id_pieza) references piezas(id) on delete cascade on update cascade,
CONSTRAINT suministra_fk2 foreign key(id_proveedor) references proveedores(id) on delete cascade on update cascade
);

CREATE TABLE usuario (
    id INT auto_increment,
    username nvarchar(100) UNIQUE,
    password nvarchar(255),
    role nvarchar(50),
    primary key (id)
);

-- registros tabla proveedores
INSERT INTO proveedores (nombre) VALUES ('Proveedor 1');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 2');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 3');

-- registros tabla piezas
INSERT INTO piezas (nombre) VALUES ('Tornillo');
INSERT INTO piezas (nombre) VALUES ('Tuerca');
INSERT INTO piezas (nombre) VALUES ('Arandela');
INSERT INTO piezas (nombre) VALUES ('Clavo');

-- registros tabla suministra
INSERT INTO suministra (id_pieza, id_proveedor, precio) VALUES (3, 2, 10);
INSERT INTO suministra (id_pieza, id_proveedor, precio) VALUES (2, 3, 8);
INSERT INTO suministra (id_pieza, id_proveedor, precio) VALUES (3, 1, 5);

INSERT INTO Usuario (username, password, role) VALUES
('admin', '$2a$12$9ZtlxtT/DcVXrTEP7CD5G.iQEB1zB5Xza32IWpQZNS4NJ8KvVqhCi', 'admin'),
('alberto', '$2a$12$xP79bu.7SwdkeyYHi4kvMOpP9umurJ0DN7c4WbZ1csqXToPs6oG9K', 'user');


