CREATE TABLE empleado (
  id INTEGER PRIMARY KEY,
  nombre varchar(255),
  departamento varchar(255),
  telefono varchar(255)
);

INSERT INTO empleado (id, nombre, departamento, telefono) values(1, 'Juan Perez', 'Logística', '5742130');
INSERT INTO empleado (id, nombre, departamento, telefono) values(2, 'Pedro Soto', 'RRHH', '5234120');

--agregar identity by column