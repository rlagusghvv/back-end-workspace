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
Where id = "damas1110";

desc member;

CREATE Table member(
id VARCHAR(30) UNIQUE,
password VARCHAR(30),
name VARCHAR(20)
);

drop TABLE member;


