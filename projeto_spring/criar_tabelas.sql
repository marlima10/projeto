DROP SCHEMA IF EXISTS projeto CASCADE;
CREATE SCHEMA projeto;
--------------------------------------------------------------------------------
CREATE TABLE projeto.medico (
   id 							INTEGER 		NOT NULL,
   nome			 				VARCHAR(200) 		NOT NULL,
   sexo							VARCHAR(200) 		NOT NULL,
   rg 							VARCHAR(200) 		NOT NULL,
   endereco						VARCHAR(200) 		NOT NULL,
   data_de_nascimento					VARCHAR(200) 		NOT NULL,
   telefone						VARCHAR(200) 		NOT NULL
);  

ALTER TABLE projeto.medico ADD CONSTRAINT pk_medico
                       PRIMARY KEY ( id );
                     
DROP SEQUENCE IF EXISTS projeto.Seq_medico;
CREATE SEQUENCE projeto.Seq_medico START 1 INCREMENT 1;
--------------------------------------------------------------------------------
CREATE TABLE projeto.paciente (
   id 							INTEGER 		NOT NULL,
   nome			 				VARCHAR(200) 		NOT NULL,
   sexo							VARCHAR(200) 		NOT NULL,
   rg 							VARCHAR(200) 		NOT NULL,
   endereco						VARCHAR(200) 		NOT NULL,
   data_de_nascimento					VARCHAR(200) 		NOT NULL,
   telefone						VARCHAR(200) 		NOT NULL
);  

ALTER TABLE projeto.paciente ADD CONSTRAINT pk_paciente
                       PRIMARY KEY ( id );
                     
DROP SEQUENCE IF EXISTS projeto.Seq_paciente;
CREATE SEQUENCE projeto.Seq_paciente START 1 INCREMENT 1;
--------------------------------------------------------------------------------
CREATE TABLE projeto.perfil (
   id 							INTEGER 		NOT NULL,
   tipo_perfil		 				INTEGER 		NOT NULL
);  

ALTER TABLE projeto.perfil ADD CONSTRAINT pk_perfil
                       PRIMARY KEY ( id );
                     
DROP SEQUENCE IF EXISTS projeto.Seq_perfil;
CREATE SEQUENCE projeto.Seq_perfil START 1 INCREMENT 1;
-----------------------------------------------------------------------------
CREATE TABLE projeto.usuario (
   id 							INTEGER 		NOT NULL,
   id_perfil		 				INTEGER 		NOT NULL,
   email						VARCHAR(200) 		NOT NULL,
   senha 						VARCHAR(200) 		NOT NULL
);  

ALTER TABLE projeto.usuario ADD CONSTRAINT pk_usuario
                       PRIMARY KEY ( id );

ALTER TABLE projeto.usuario ADD CONSTRAINT fk_perfil
          FOREIGN KEY ( id_perfil )
          REFERENCES projeto.perfil
          ON DELETE RESTRICT
          ON UPDATE RESTRICT;
                     
DROP SEQUENCE IF EXISTS projeto.Seq_usuario;
CREATE SEQUENCE projeto.Seq_usuario START 1 INCREMENT 1;
--------------------------------------------------------------------------------
CREATE TABLE projeto.exame (
   id 							INTEGER 		NOT NULL,
   id_paciente		 				INTEGER 		NOT NULL,
   id_medico 						INTEGER 		NULL,
   observacoes						VARCHAR(200) 		NOT NULL
);  

ALTER TABLE projeto.exame ADD CONSTRAINT pk_exame
                       PRIMARY KEY ( id );

ALTER TABLE projeto.exame ADD CONSTRAINT fk_paciente
          FOREIGN KEY ( id_paciente )
          REFERENCES projeto.paciente
          ON DELETE RESTRICT
          ON UPDATE RESTRICT;

ALTER TABLE projeto.exame ADD CONSTRAINT fk_medico
          FOREIGN KEY ( id_medico )
          REFERENCES projeto.medico
          ON DELETE RESTRICT
          ON UPDATE RESTRICT;
                     
DROP SEQUENCE IF EXISTS projeto.Seq_exame;
CREATE SEQUENCE projeto.Seq_exame START 1 INCREMENT 1;
--------------------------------------------------------------------------------
CREATE TABLE projeto.medicoes (
   id 							INTEGER 		NOT NULL,
   id_exame		 				INTEGER 		NOT NULL,
   pressao_sistolica					INTEGER 		NOT NULL,
   pressao_diastolica					INTEGER 		NOT NULL,
   data_hora						TIMESTAMP 		NOT NULL
);  

ALTER TABLE projeto.medicoes ADD CONSTRAINT pk_medicoes
                       PRIMARY KEY ( id );

ALTER TABLE projeto.medicoes ADD CONSTRAINT fk_exame
          FOREIGN KEY ( id_exame)
          REFERENCES projeto.exame
          ON DELETE RESTRICT
          ON UPDATE RESTRICT;

                     
DROP SEQUENCE IF EXISTS projeto.Seq_medicoes;
CREATE SEQUENCE projeto.Seq_medicoes START 1 INCREMENT 1;
--------------------------------------------------------------------------------

INSERT INTO projeto.perfil (ID,TIPO_PERFIL) VALUES (NEXTVAL('projeto.seq_perfil'),1);
INSERT INTO projeto.perfil (ID,TIPO_PERFIL) VALUES (NEXTVAL('projeto.seq_perfil'),2);

INSERT INTO projeto.paciente (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_paciente'),'Marcelo','Masculino','Rua X','34.285.107-x','10/05/1987','99116-9630');
INSERT INTO projeto.paciente (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_paciente'),'Rafael','Masculino','Rua Y','34.285.107-x','10/05/1987','99116-2312');
INSERT INTO projeto.paciente (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_paciente'),'Kaio','Masculino','Rua Z','34.285.107-x','10/05/1989','99116-4233');
INSERT INTO projeto.paciente (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_paciente'),'Lu','Feminino','Rua P','34.285.107-x','10/05/1980','99116-8756');
INSERT INTO projeto.paciente (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_paciente'),'Jessica','Feminino','Rua I','34.285.107-x','10/05/1991','99116-5663');

INSERT INTO projeto.medico (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_medico'),'Felipe','Masculino','Rua X','34.285.107-x','10/05/1987','99116-9630');
INSERT INTO projeto.medico (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_medico'),'Luis','Masculino','Rua Y','34.285.107-x','10/05/1987','99116-2312');
INSERT INTO projeto.medico (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_medico'),'Welligton','Masculino','Rua Z','34.285.107-x','10/05/1989','99116-4233');
INSERT INTO projeto.medico (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_medico'),'Juliana','Feminino','Rua P','34.285.107-x','10/05/1980','99116-8756');
INSERT INTO projeto.medico (id,nome,sexo,rg,endereco,data_de_nascimento,telefone) 
VALUES (NEXTVAL('projeto.seq_medico'),'Tamires','Feminino','Rua I','34.285.107-x','10/05/1991','99116-5663');

INSERT INTO projeto.usuario (id,email,senha,id_perfil)
VALUES (NEXTVAL('projeto.seq_medico'),'mar.lima10@gmail.com','123',1);
INSERT INTO projeto.usuario (id,email,senha,id_perfil)
VALUES (NEXTVAL('projeto.seq_medico'),'mar.lima10@hotmail.com','123',1);