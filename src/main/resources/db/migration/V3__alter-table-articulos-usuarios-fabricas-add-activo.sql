
alter table usuarios add activo tinyint;
update usuarios set activo = 1;

alter table fabricas add activo tinyint;
update fabricas set activo = 1;

alter table articulos add activo tinyint;
update articulos set activo = 1;

