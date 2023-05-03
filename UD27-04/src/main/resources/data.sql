 -- drop database if exists losinvestigadores;
 -- create database losinvestigadores;
 -- use losinvestigadores;

DROP table IF EXISTS reserva;
DROP table IF EXISTS equipos;
DROP table IF EXISTS investigadores;
DROP table IF EXISTS facultad;
-- DROP table IF EXISTS Usuario;

create table facultad(
	id int NOT NULL AUTO_INCREMENT,
    nombre nvarchar(100),
    PRIMARY KEY(id)
);
create table investigadores(
	id VARCHAR(8) NOT NULL,
    nom_apels nvarchar(255),
    id_facultad int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT inves_fk1 FOREIGN KEY(id_facultad) REFERENCES facultad(id)ON UPDATE CASCADE ON DELETE CASCADE
);
create table equipos(
	id char(4) NOT NULL,
    nombre nvarchar(100),
    id_facultad int NOT NULL,
    PRIMARY KEY(id),	
    CONSTRAINT equipos_fk1 FOREIGN KEY(id_facultad) REFERENCES facultad(id)ON UPDATE CASCADE ON DELETE CASCADE
);
create table reserva(
	id int NOT NULL AUTO_INCREMENT,
	comienzo date,
    fin date,
    PRIMARY KEY(id),   
    id_investigador varchar(8),
	id_equipo varchar(4),
    CONSTRAINT reserva_fk1 FOREIGN KEY(id_investigador) REFERENCES investigadores(id)ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT reserva_fk2 FOREIGN KEY(id_equipo) REFERENCES equipos(id)ON UPDATE CASCADE ON DELETE CASCADE
);

-- Insertar datos en la tabla facultad
INSERT INTO facultad (nombre) VALUES ('Facultad de Ciencias');
INSERT INTO facultad (nombre) VALUES ('Facultad de Ingenieria');
INSERT INTO facultad (nombre) VALUES ('Facultad de Artes');
INSERT INTO facultad (nombre) VALUES ('Facultad de Humanidades');
INSERT INTO facultad (nombre) VALUES ('Facultad de Economia');

-- Insertar datos en la tabla investigadores
INSERT INTO investigadores (id, nom_apels, id_facultad) VALUES ('12345678', 'Alberto del Pozo', 1);
INSERT INTO investigadores (id, nom_apels, id_facultad) VALUES ('23456789', 'Tamy Morales', 2);
INSERT INTO investigadores (id, nom_apels, id_facultad) VALUES ('34567890', 'Hugo del Pozo', 1);
INSERT INTO investigadores (id, nom_apels, id_facultad) VALUES ('45678901', 'Laura Ramirez', 3);
INSERT INTO investigadores (id, nom_apels, id_facultad) VALUES ('56789012', 'Pedro Gonzalez', 4);

-- Insertar datos en la tabla equipos
INSERT INTO equipos (id, nombre, id_facultad) VALUES ('E001', 'Equipo 1', 1);
INSERT INTO equipos (id, nombre, id_facultad) VALUES ('E002', 'Equipo 2', 2);
INSERT INTO equipos (id, nombre, id_facultad) VALUES ('E003', 'Equipo 3', 1);
INSERT INTO equipos (id, nombre, id_facultad) VALUES ('E004', 'Equipo 4', 3);
INSERT INTO equipos (id, nombre, id_facultad) VALUES ('E005', 'Equipo 5', 4);

-- Insertar datos en la tabla reserva
INSERT INTO reserva (comienzo, fin, id_investigador, id_equipo) VALUES ('2023-05-01', '2023-05-07', '12345678', 'E001');
INSERT INTO reserva (comienzo, fin, id_investigador, id_equipo) VALUES ('2023-05-08', '2023-05-14', '23456789', 'E002');
INSERT INTO reserva (comienzo, fin, id_investigador, id_equipo) VALUES ('2023-05-15', '2023-05-21', '34567890', 'E003');
INSERT INTO reserva (comienzo, fin, id_investigador, id_equipo) VALUES ('2023-05-22', '2023-05-28', '45678901', 'E004');
INSERT INTO reserva (comienzo, fin, id_investigador, id_equipo) VALUES ('2023-05-29', '2023-06-04', '56789012', 'E005');

-- Insertar datos en la tabla Usuario
INSERT INTO Usuario (username, password, role) VALUES
('admin', '$2a$12$9ZtlxtT/DcVXrTEP7CD5G.iQEB1zB5Xza32IWpQZNS4NJ8KvVqhCi', 'admin'),
('alberto', '$2a$12$xP79bu.7SwdkeyYHi4kvMOpP9umurJ0DN7c4WbZ1csqXToPs6oG9K', 'user'),	
('usuario3', '$2a$12$XpSsEe7T5ewSNiKRSmyB0OIfCHGk4DnoTzFcW8dHw8RG09b45kF12', 'user3');




