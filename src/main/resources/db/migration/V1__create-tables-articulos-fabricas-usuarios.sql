
CREATE TABLE usuarios (
    id_usuario BINARY(16) NOT NULL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    rol ENUM('USER', 'ADMIN') DEFAULT 'USER'
);


CREATE TABLE fabricas (
    id_fabrica BINARY(16) NOT NULL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE articulos (
    id_articulo BINARY(16) NOT NULL PRIMARY KEY,
    nro_articulo INT NOT NULL AUTO_INCREMENT UNIQUE,
    nombre_articulo VARCHAR(255) NOT NULL,
    descripcion_articulo TEXT,
    fabrica_id BINARY(16),

    CONSTRAINT fk_fabrica
    FOREIGN KEY (fabrica_id) REFERENCES fabricas(id_fabrica)
);