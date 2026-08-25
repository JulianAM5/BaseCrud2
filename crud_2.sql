CREATE DATABASE IF NOT EXISTS agenda_2;

-- INTRODUCIR TU USUARIO EN USUARIO1
GRANT ALL PRIVILEGES ON agenda_2.* TO 'usuario1'@'localhost';
FLUSH PRIVILEGES;
USE agenda_2;

-- Create Direcciones table
CREATE TABLE IF NOT EXISTS Direcciones (
    id INT(11) NOT NULL AUTO_INCREMENT,
    direccion VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create Personas table
CREATE TABLE IF NOT EXISTS Personas (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create Personas_Direcciones
CREATE TABLE IF NOT EXISTS Personas_Direcciones (
    personaId INT(11) NOT NULL,
    direccionId INT(11) NOT NULL,
    INDEX (personaId),
    INDEX (direccionId),
    FOREIGN KEY (personaId) REFERENCES Personas(id) ON DELETE CASCADE,
    FOREIGN KEY (direccionId) REFERENCES Direcciones(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create Telefonos table
CREATE TABLE IF NOT EXISTS Telefonos (
    id INT(11) NOT NULL AUTO_INCREMENT,
    personaId INT(11) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    INDEX (personaId),
    FOREIGN KEY (personaId) REFERENCES Personas(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
