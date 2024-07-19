drop Table person;

CREATE Table person(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
age INT,
addr VARCHAR(50)
);

SELECT *
FROM member;

SELECT name
FROM member 
Where id = "damas1110" && password = "rlagusgh0329";

desc member;

CREATE Table member(
id VARCHAR(30) UNIQUE,
password VARCHAR(30),
name VARCHAR(20)
);

drop TABLE member;

CREATE TABLE bank (
 name varchar(20),
 balance Int
);

insert into bank VALUES ("김현호", 200000000);
INSERT INTO bank VALUES ("김호현", 300000000);

SELECT * FROM bank;

SELECT * FROM bank WHERE name = "호현";


