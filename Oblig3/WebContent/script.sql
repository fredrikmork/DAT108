create schema oblig3;
set search_path to oblig3;
CREATE TABLE person 
(
   mobil				varchar,
   fornavn			varchar,
   etternavn			varchar,
   passord			varchar,
   kjonn				varchar,
   PRIMARY KEY (mobil)
);