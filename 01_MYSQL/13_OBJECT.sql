/*

  인덱스(INDEX)
  - SQL 명령문의 처리 속도를 향상시키기 위해 행들의 위치 정보를 가지고 있다.

  * 데이터 검색 방식
  TABLE FULL SCAN : 테이블 데이터를 처음부터 끝까지 검색하여 원하는 데이터를 찾는 방식
  INDEX SCAN : 인덱스를 통해 데이터를 찾는 방식
  
  기본키(PRIMARY KEY)는 테이블의 각 행을 고유하게 식별한다.
  실제 테이블 데이터가 모두 인덱스 구조로 저장된다.
  
*/
-- 테이블에서 인덱스 조회
SHOW INDEX FROM employee;

-- 특정 스키마에 있는 인덱스를 한꺼번에 조회
SELECT *
FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'kh';

/*

  INDEX 생성
  
  CREATE INDEX 인덱스명
  ON 테이블명(컬럼, 컬럼, .....);
  
*/
SELECT *
FROM sakila.payment
WHERE amount = 0.99;

CREATE INDEX idx_amount
ON sakila.payment(amount); -- 비고유 인덱스 생성

CREATE INDEX idx_amount_id
ON sakila.payment(amount, payment_id); -- 결합 인덱스 생성

SELECT * FROM sakila.payment;
SHOW INDEX FROM sakila.payment;

/*

  INDEX 삭제
  
  DROP INDEX 인덱스명
  ON 테이블명;
  
*/

DROP INDEX idx_amount ON sakila.payment;
DROP INDEX idx_amount_id ON sakila.payment;


/*

  프로시저(PROCEDURE)
  - SQL문을 저장하여 필요할 때마다 다시 입력할 필요 없이
    간단하게 호출해서 사용 가능하게 하는 코드 블록
  
  DELIMITER // 
  
  CREATE PROCEDURE 프로시저명(매개변수)
  BEGIN 
       저장할 SQL문
  END //
  
  DELIMITER ;
*/

CREATE TABLE emp_copy
SELECT * FROM employee;

-- emp_copy 테이블의 모든 데이터를 삭제하는 프로시저 생성

DELIMITER //

  CREATE PROCEDURE del_emp_copy()
  BEGIN 
  DELETE FROM emp_copy;
  END //
  
  DELIMITER ;

-- 만들어진 프로시저 확인
SHOW PROCEDURE STATUS;

SELECT * FROM emp_copy;

-- del_emp_copy 프로시저 호출
CALL del_emp_copy();

-- 프로시저 삭제
DROP PROCEDURE del_emp_copy;