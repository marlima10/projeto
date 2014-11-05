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
   id_paciente 						INTEGER 		NULL,
   id_medico 						INTEGER 		NULL,
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

ALTER TABLE projeto.usuario ADD CONSTRAINT fk_paciente
          FOREIGN KEY ( id_paciente )
          REFERENCES projeto.paciente
          ON DELETE RESTRICT
          ON UPDATE RESTRICT;

ALTER TABLE projeto.usuario ADD CONSTRAINT fk_medico
          FOREIGN KEY ( id_medico )
          REFERENCES projeto.medico
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