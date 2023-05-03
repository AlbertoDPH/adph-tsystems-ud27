 -- Elimina y la BBDD en el caso de que exista
 -- DROP DATABASE IF EXISTS loscientificos;

 -- Creamos la BBDD
 -- CREATE DATABASE loscientificos;

 -- USE loscientificos;
 
 DROP table IF EXISTS asignado_a;
 DROP table IF EXISTS proyecto;
 DROP table IF EXISTS cientificos;
 -- DROP table IF EXISTS usuario;



-- Creamos la tabla cientificos, almacena informacion de los cientificos
CREATE TABLE cientificos (
    dni VARCHAR(9) PRIMARY KEY, -- PRIMARY KEY del cientifico
    nom_apel NVARCHAR(255) NOT NULL
);

-- Creamos la tabla Proyecto, almacena informacion de los proyectos
CREATE TABLE proyecto (
	id VARCHAR(4) PRIMARY KEY, -- PRIMARY KEY del proyecto
    Nombre NVARCHAR(255) NOT NULL, 
    Horas INT NOT NULL 
);

-- Creamos la tabla asignado_a, relaciona cientificos con proyectos
CREATE TABLE asignado_a (
    dni VARCHAR(9) NOT NULL, -- FK, referencia al dni del cientifico
    id_proyecto CHAR(4) NOT NULL, -- FK, referencia al Id del proyecto

    PRIMARY KEY (dni, id_proyecto), -- PK, Combinamos las dos FK

    FOREIGN KEY (dni) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE,
        
    FOREIGN KEY (id_proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*CREATE TABLE usuario (
    id INT auto_increment,
    username nvarchar(100) UNIQUE,
    password nvarchar(255),
    role nvarchar(50),
    primary key (id)
);*/		

-- Insertamos datos en la tabla cientificos
INSERT INTO cientificos (dni, nom_apel) VALUES ('12345678A', 'Juan Perez');
INSERT INTO cientificos (dni, nom_apel) VALUES ('23456789B', 'Maria Rodriguez');
INSERT INTO cientificos (dni, nom_apel) VALUES ('34567890C', 'Carlos Gomez');
INSERT INTO cientificos (dni, nom_apel) VALUES ('45678901D', 'Sonia Fernandez');
INSERT INTO cientificos (dni, nom_apel) VALUES ('56789012E', 'Laura Ramirez');

-- Insertamos datos en la tabla proyecto
INSERT INTO proyecto (id, Nombre, Horas) VALUES ('P001', 'Proyecto A', 100);
INSERT INTO proyecto (id, Nombre, Horas) VALUES ('P002', 'Proyecto B', 150);
INSERT INTO proyecto (id, Nombre, Horas) VALUES ('P003', 'Proyecto C', 200);
INSERT INTO proyecto (id, Nombre, Horas) VALUES ('P004', 'Proyecto D', 50);
INSERT INTO proyecto (id, Nombre, Horas) VALUES ('P005', 'Proyecto E', 300);

-- Insertamos datos en la tabla asignado_a
INSERT INTO asignado_a (dni, id_proyecto) VALUES ('12345678A', 'P001');
INSERT INTO asignado_a (dni, id_proyecto) VALUES ('23456789B', 'P001');
INSERT INTO asignado_a (dni, id_proyecto) VALUES ('34567890C', 'P002');
INSERT INTO asignado_a (dni, id_proyecto) VALUES ('45678901D', 'P003');
INSERT INTO asignado_a (dni, id_proyecto) VALUES ('56789012E', 'P004');

INSERT INTO Usuario (username, password, role) VALUES
('admin', '$2a$12$9ZtlxtT/DcVXrTEP7CD5G.iQEB1zB5Xza32IWpQZNS4NJ8KvVqhCi', 'admin'),
('alberto', '$2a$12$xP79bu.7SwdkeyYHi4kvMOpP9umurJ0DN7c4WbZ1csqXToPs6oG9K', 'user'),	
('usuario2', '$2a$12$AgmM8WDLiFnkbqmrXWhcie0rlpm3DC./0pnicHHnQE/CayuUQnMiq', 'user2');

