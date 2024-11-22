

ALTER TABLE usuarios
ADD COLUMN id_imagen BINARY(16);

ALTER TABLE usuarios
ADD CONSTRAINT fk_usuarios_imagen
FOREIGN KEY (id_imagen)
REFERENCES imagenes (id_imagen);