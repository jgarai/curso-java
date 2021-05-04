DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(100)
);

DROP INDEX IF EXISTS usuarios_email_IDX;
CREATE UNIQUE INDEX usuarios_email_IDX ON usuarios (email);

DROP INDEX IF EXISTS usuarios_nombre_IDX;
CREATE INDEX usuarios_nombre_IDX ON usuarios (nombre);

INSERT INTO usuarios (email, password, nombre, apellidos) VALUES 
('javier@email.com', 'javier', 'Javier', 'Lete'),
('pepe@email.com', 'pepe', 'Pepe', 'Pérez'),
('juanes@email.com', 'juanes', 'Juanes', 'Teban');
