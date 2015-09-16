Enter file contents here-- Table T_Pacientes
CREATE TABLE T_Pacientes (
   ID_Paciente int    NOT NULL ,
   Nombres char(20)    NOT NULL ,
   Apellidos char(30)    NOT NULL ,
   Sexo int    NOT NULL ,
   Direccion varchar(60)    NULL ,
   Telefono bigint    NULL ,
   FechaNacimiento date    NOT NULL ,
   ID_Ciudad int    NOT NULL ,
   CONSTRAINT T_Pacientes_pk PRIMARY KEY (ID_Paciente)
);
CREATE INDEX T_Pacientes_IDX_Sexo ON T_Pacientes (Sexo);
CREATE  UNIQUE INDEX T_Pacientes_IDX_ID ON T_Pacientes (ID_Paciente);


-- Table T_Ciudad
CREATE TABLE T_Ciudad (
   ID_Ciudad int IDENTITY (0,1) NOT NULL ,
   Ciudad char(20)    NOT NULL ,
   CONSTRAINT T_Ciudad_pk PRIMARY KEY (ID_Ciudad)
);
INSERT INTO T_Ciudad (Ciudad) VALUES ('BOGOTA');
INSERT INTO T_Ciudad (Ciudad) VALUES ('MEDELLIN');
INSERT INTO T_Ciudad (Ciudad) VALUES ('CALI');
INSERT INTO T_Ciudad (Ciudad) VALUES ('BUCARAMANGA');
INSERT INTO T_Ciudad (Ciudad) VALUES ('CARTAGENA');
INSERT INTO T_Ciudad (Ciudad) VALUES ('BARRANQUILLA');
INSERT INTO T_Ciudad (Ciudad) VALUES ('SANTA MARTHA');

-- Table T_Visitas
CREATE TABLE T_Visitas (
   ID_Visita int IDENTITY(0,1) NOT NULL ,
   ID_Paciente int    NOT NULL ,
   FechaVisita datetime   NOT NULL ,
   CONSTRAINT T_Visitas_pk PRIMARY KEY (ID_Visita)
);
CREATE INDEX T_Visitas_IDX_ID_Cliente ON T_Visitas (ID_Visita);

-- Table T_Tratamiento
CREATE TABLE T_Tratamiento (
   ID_Tratamiento int IDENTITY(0,1)    NOT NULL ,
   ID_Visita int    NOT NULL ,
   ID_Paciente int    NOT NULL ,
   Observaciones varchar(2000)    NOT NULL ,
   FechaTratamiento datetime    NOT NULL ,      
   CONSTRAINT T_Tratamiento_pk PRIMARY KEY (ID_Tratamiento)
);


-- Reference:  T_Pacientes_T_Ciudad (table: T_Pacientes)
	ALTER TABLE T_Pacientes 
	ADD CONSTRAINT T_Pacientes_T_Ciudad FOREIGN KEY (ID_Ciudad)
	REFERENCES T_Ciudad (ID_Ciudad)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;
   
	ALTER TABLE T_Tratamiento 
	ADD CONSTRAINT T_Tratamiento_T_Visitas FOREIGN KEY (ID_Visita)
	REFERENCES T_Visitas (ID_Visita)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;
	
-- Reference:  T_Visitas_T_Pacientes (table: T_Visitas)
	ALTER TABLE T_Visitas ADD CONSTRAINT T_Visitas_T_Pacientes FOREIGN KEY (ID_Paciente)
	REFERENCES T_Pacientes (ID_Paciente)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;
