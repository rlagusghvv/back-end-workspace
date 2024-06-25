/*

  DML(Data Manipulation Language)
  - 테이블 조작 언어로 테이블에 값을 삽입(INSERT)하거나,
  수정(UPDATE)하거나, 삭제(DELETE)하는 구문

  INSERT
  - 테이블에 새로운 행을 추가하는 구문
  
  1) INSERT INTO 테이블명 VALUES (값, 값, ....);
     - 테이블에 모든 컬럼에 대한 값을 INSERT 하고자 할 때 사용한다.
     - 컬럼 순번을 지켜서 VALUES 값을 나열해야 한다. 
     
  2) INSERT INTO 테이블명(컬럼명, 컬럼명, ...) VALUES (값, 값, ...);
     - 테이블의 특정 컬럼에 대한 값만 INSERT 하고자 할 때 사용한다.
     - 선택 안된 컬럼들은 기본적으로 NULL값이 들어간다.
	 (* NOT NULL 조건이 걸려 있는 컬럼이 있는 경우 반드시 값을 입력해야 한다.)
     - 기본값(DEFAULT)이 지정되어 있는 경우 NULL이 아닌 기본값이 들어간다.
     
  3) INSERT INTO 테이블명 서브쿼리;
     - VALUES 대신 서브쿼리 조회한 결과값이 통쨰로 INSERT 한다.
     - 서브쿼리 결과값이 INSERT 문에 지정된 테이블 컬럼 개수와 같아야 한다.
*/

-- 사용할 테이블 생성
CREATE TABLE emp(
  emp_id INT PRIMARY KEY AUTO_INCREMENT,
  emp_name VARCHAR(30) NOT NULL,
  dept_title VARCHAR(30) DEFAULT '개발팀',
  hire_date DATE DEFAULT (current_date)
);

-- 1)
INSERT INTO emp
VALUES(1, '윤대훈', '서비스 개발팀', default);

-- 모든 컬럼값을 지정하지 않으면 에러가 발생!
INSERT INTO emp
VALUES ('이동엽', '개발 지원팀', default); -- Error Code: 1136. Column count doesn't match value count at row 1

-- 에러는 발생하지 않지만 데이터가 잘못 저장
INSERT INTO emp
VALUES (2, '개발 지원팀','이동엽', default);

-- 데이터 타입이 맞지 않아서 에러! emp_id 컬럼에는 자료형이 INT로 설정되어 있음!
INSERT INTO emp
VALUES ('개발 지원팀','이동엽','1', default); -- Error Code: 1366. Incorrect integer value: '개발 지원팀' for column 'emp_id' at row 1

-- 2)
INSERT INTO emp(emp_id, emp_name, dept_title, hire_date)
VALUES (3, '이준용', '보안팀', null); -- not NULL 조건이 있는게 아니기 때문에 null도 삽입 가능!

INSERT INTO emp(emp_name)
VALUES ('윤유진'); -- 기본값이 설정되어 있는 경우 해당 컬럼을 생략하고 데이터 삽입이 가능함!

INSERT INTO emp(dept_title, emp_name)
VALUES('인사팀', '윤유진'); -- 컬럼이 나열된 순서와 값의 순서를 매칭해서 값이 삽입됨!

INSERT INTO emp(dept_title)
VALUES('마케팅팀'); -- Error Code: 1364. Field 'emp_name' doesn't have a default value
-- NOT NULL 조건이 있는 emp_name에 대한 값이 들어가지 않았기 떄문에 오류 발생!

-- 3)
-- kh.employee 테이블에서 사번, 이름, 부서명, 입사일 가져오기
INSERT INTO emp 
SELECT emp_id, emp_name, dept_title, hire_date FROM kh.employee JOIN kh.department ON (dept_code = dept_id);
-- INSERT INTO 테이블명 서브쿼리

-- 컬럼명을 명시 ==> 순서 상관 X
INSERT INTO emp(emp_name, dept_title, hire_date)
SELECT emp_name, dept_title, hire_date FROM kh.employee JOIN kh.department ON (dept_code = dept_id);
SELECT * FROM emp;

-- 테이블 구조만 복사
CREATE TABLE emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE 1 = 0;

CREATE TABLE emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE 1 = 0;

-- emp_dept 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일 추가하고
-- emp_manager 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 관리자 사번 추가

INSERT INTO emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE dept_code = 'D1';

INSERT INTO emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE dept_code = 'D1';

SELECT * FROM emp_dept;
SELECT * FROM emp_manager;


/*

  UPDATE
  - 테이블에 기록된 데이터를 수정하는 구문
  
  UPDATE 테이블명
  SET 컬럼명 = 변경하려는 값, 
      컬럼명 = 변경하려는 값, ...
  WHERE 조건;

  - SET 절에서 여러 개의 컬럼을 콤마(,)로 나열해서 값을 동시에 변경할 수 있다.
  !! WHERE 절을 생략하면 모든 행의 데이터가 변경된다. (MYSQL 방지)
  - 사실 서브쿼리 사용 가능! 잘 쓰이지도 않고, 버전마다 상황이 다름.
  
*/

DESC dept_copy;
SELECT * FROM dept_copy;
SELECT * FROM emp_salary;

START TRANSACTION;
rollback;
-- emp_salary에서 이태림 사원의 급여를 3000000원으로, 보너스를 0.4로 변경
UPDATE emp_salary
SET salary = 3000000,
    bonus = 0.4
WHERE emp_name = '이태림';
commit;

-- 모든 사원의 급여를 기존 급여에서 10프로 인상한 금액 (기존 급여 * 1.1)으로 변경
UPDATE emp_salary
SET salary = salary * 1.1;

-- 사번이 201인 사원의 사원번호를 NULL로 변경
DESC emp_salary;
ALTER TABLE emp_salary DROP PRIMARY KEY;
SELECT TABLE_SCHEMA, TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'sample' AND TABLE_NAME = 'emp_salary';
UPDATE emp_salary
SET emp_id = NULL
WHERE emp_id = 201;
-- >> emp_id 주요키(primary key) 제약조건 위배 (NOT NULL 위배!)

-- 아시아 지역에 근무하는 직원들의 보너스를 0.3으로 변경
UPDATE emp_salary
SET bonus = 0.3
WHERE emp_id IN (SELECT emp_id
FROM kh.location 
JOIN kh.department ON (local_code = location_id) 
JOIN kh.employee ON (dept_code = dept_id) 
WHERE local_name LIKE "%ASIA%");

SELECT * FROM emp_salary
left JOIN kh.department ON (dept_code = dept_id)
left JOIN kh.location ON (local_code = location_id);


/*

  DELETE
  - 테이블에 기록된 데이터를 삭제하는 구문
  DELETE FROM 테이블명
  WHERE 조건식;
  
  - WHERE 절을 제시하지 않으면 전체 행이 삭제된다!

*/

-- emp_salary에서 dept_code가 D5인 직원들을 삭제
DELETE FROM emp_salary
WHERE dept_code = 'D5';

SELECT * FROM emp_salary;

/*
  TRUNCATE
  - 테이블 전체 행을 삭제할 때 사용하는 구문
  - DELETE 보다 수행 속도가 빠르다는 장점!
  - 별도의 조건 제시 불가! ROLLBACK이 불가!
  
  TRUNCATE TABLE 테이블명;
  
*/

START transaction;

DELETE FROM emp_salary;
DELETE FROM dept_copy;

SELECT * FROM emp_salary;
SELECT * FROM dept_copy;

ROLLBACK; -- DELETE는 ROLLBACK 가능!

TRUNCATE TABLE emp_salary;
TRUNCATE TABLE dept_copy;

ROLLBACK;

SELECT * FROM emp_salary;
SELECT * FROM dept_copy;