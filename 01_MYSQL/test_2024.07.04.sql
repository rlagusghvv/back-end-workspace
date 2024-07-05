INSERT INTO employee(emp_id, emp_name, emp_no) VALUES(300, '전지우', '700101-1234567');


desc employee;
SELECT *
FROM employee;

SELECT emp_name, emp_no, dept_code, salary, email
FROM employee
WHERE (dept_code = 'D6' OR dept_code = 'D9')
AND salary >= 3000000
AND email LIKE '___\_%';

SELECT * FROM employee WHERE bonus IS null;