
create table imagenes(
id_imagen BINARY(16) not null primary key,
nombre varchar(255),
contenido LONGBLOB
);



ALTER TABLE articulos
ADD COLUMN id_imagen BINARY(16);



ALTER TABLE articulos
ADD CONSTRAINT fk_articulos_imagen
FOREIGN KEY (id_imagen)
REFERENCES imagenes (id_imagen);