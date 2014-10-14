DROP DATABASE IF EXISTS address_book_db;

CREATE DATABASE address_book_db DEFAULT CHARACTER SET 'utf8' DEFAULT COLLATE 'utf8_unicode_ci';

USE address_book_db;

CREATE TABLE person(
    person_id INT NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(30) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	middle_name VARCHAR(30) NOT NULL,
	PRIMARY KEY(person_id)
	)ENGINE=INNODB;

CREATE TABLE contact(
    contact_id INT NOT NULL AUTO_INCREMENT,
	person_id INT NOT NULL,
	phone_number VARCHAR(30) NOT NULL,
	email VARCHAR(30) NOT NULL,
	PRIMARY KEY(contact_id)
	)ENGINE=INNODB;

CREATE INDEX Ref1 ON contact(person_id);

ALTER TABLE contact ADD CONSTRAINT RefPERSON1
    FOREIGN KEY(person_id)
	REFERENCES person(person_id);



