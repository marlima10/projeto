CREATE TABLE projeto.strategy (
   id 							INTEGER 		NOT NULL,
   type			 				VARCHAR(200) 		NOT NULL,
   name							VARCHAR(200) 		NOT NULL
);  

ALTER TABLE projeto.strategy ADD CONSTRAINT pk_strategy
                       PRIMARY KEY ( id );
                     
DROP SEQUENCE IF EXISTS projeto.Seq_strategy;
CREATE SEQUENCE projeto.Seq_strategy START 1 INCREMENT 1;