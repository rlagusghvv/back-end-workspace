/*

   뷰(VIEW)
   - SELECT문을 저장할 수 있는 객체
   - 가상 테이블 (실제 데이터가 담겨 있는 건 X => 논리적인 테이블!)
   - DML(INSERT, UPDATE, DELETE) 작업 가능!
   
   * 사용 목적
   - 편리성 : SELECT문의 복잡도 완화!
   - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우

*/

SELECT * FROM employee;

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (local_code = location_id)
JOIN national USING (national_code)
WHERE national_name = '한국';

-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (local_code = location_id)
JOIN national USING (national_code)
WHERE national_name = '러시아';


-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (local_code = location_id)
JOIN national USING (national_code)
WHERE national_name = '일본';

/*

   1. VIEW 생성
   CREATE [OR REPLACE] VIEW 뷰명 
   AS 서브쿼리;
   
   - OR REPLACE : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성,
                  기존 중복된 이름의 뷰가 있다면 해당 뷰 수정
                  
*/

CREATE OR REPLACE VIEW vw_employee
AS SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
JOIN department ON (dept_code = dept_id)
JOIN location ON (local_code = location_id)
JOIN national USING (national_code);

SELECT * FROM vw_employee
WHERE national_name = '한국';

SELECT * FROM vw_employee
WHERE national_name = '러시아';

SELECT * FROM vw_employee
WHERE national_name = '일본';

/*

  2. 뷰 컬럼에 별칭 부여
  - 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정!

*/
-- 사원의 사번, 사원명, 직급명, 성별(남/녀), 근무년수를 조회할 수 있는
-- SELECT 문을 뷰(vw_emp_job) 생성
CREATE OR REPLACE VIEW vw_emp_job
AS SELECT emp_id 사번, emp_name 사원명, job_name 직급명, 
if(SUBSTR(emp_no, 8, 1) = 1, '남', '녀') 성별, 
TIMESTAMPDIFF(year, hire_date, current_date) 근속년수
FROM employee
JOIN job USING (job_code);

SELECT * FROM vw_emp_job
ORDER BY 근속년수 DESC;

-- 성별이 남자인 사원의 사원명과 직급명 조회
SELECT 사원명, 직급명 FROM vw_emp_job
WHERE 성별 = '남';

-- 근무년수가 20년 이상인 사원 조회
SELECT * FROM vw_emp_job
Where 근속년수 >= 20;

/*

 3. VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용
 - 뷰를 통해 조작하게 되면 실제 데이터가 담겨 있는 테이블에 반영됨!

*/

CREATE OR REPLACE VIEW vw_job
as SELECT job_code, job_name
FROM job;

-- VIEW를 통해 INSERT
INSERT INTO vw_job VALUES ('J8', '인턴');

-- VIEW를 통해 UPDATE
UPDATE vw_job
SET job_name = '노예'
WHERE job_code = 'J6';

-- VIEW를 통해 DELETE
DELETE FROM vw_job
Where job_code = 'J8';

SELECT * FROM vw_job; -- 논리적인 테이블 (실제 데이터가 담겨있지 X)
SELECT * FROM job; -- 베이스 테이블 (실제 데이터가 담겨있음)

/*

  4. DML 구문으로 VIEW 조작이 불가능한 경우!

*/
-- 1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW vw_job
AS SELECT job_code FROM job;

INSERT INTO vw_job(job_code, job_name)
VALUE ('D18', '낙하산'); -- Error Code: 1054. Unknown column 'job_name' in 'field list'
-- 해당 뷰 내에 추가하고자 하는 컬럼이 존재하지 않아서 에러 발생!

INSERT INTO vw_job(job_code)
VALUE ('j9'); -- 뷰 내에 존재하는 컬럼이기 때문에 실행 가능!

UPDATE vw_job
SET job_name = '백수'
WHERE job_code = 'j9'; -- Error Code: 1054. Unknown column 'job_name' in 'field list'
-- 해당 뷰 내에 추가하고자 하는 컬럼이 존재하지 않아서 에러 발생!

DELETE FROM vw_job
WHERE job_name = null; -- Error Code: 1054. Unknown column 'job_name' in 'where clause'
-- 해당 뷰 내에 추가하고자 하는 컬럼이 존재하지 않아서 에러 발생!


-- 2) 뷰에 포함되지 않는 컬럼 중에 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW vw_job
AS SELECT job_name FROM job;

INSERT INTO vw_job
VALUES('인턴'); -- Error Code: 1423. Field of view 'kh.vw_job' underlying table doesn't have a default value
-- job_code에 걸려있는 프라이머리키의 NOT NULL 제약 조건 때문에 job_code 값 없이 job_name 값 만을 가진 행을 생성할 수 없음!

UPDATE vw_job
SET job_name = '인턴'
WHERE job_name = '사원';

DELETE FROM vw_job
WHERE job_name = '인턴'; -- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`kh`.`employee`, CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`job_code`) REFERENCES `job` (`job_code`))
-- 부모 값으로 설정되어 있기 때문에 'J7'을 포함한 해당 행은 삭제될 수 없음.
-- 자식 데이터가 존재하지 않는 경우만 삭제 가능!  


-- 3. 산술표현식 또는 함수식으로 정의된 경우
-- 사번, 사원명, 급여, 연봉(salary * 12)을 조회한 SELECT 문으로 vw_emp_sal 뷰 정의
CREATE OR REPLACE VIEW vw_emp_sal
AS SELECT emp_id 사번, emp_name 이름, emp_no 주민번호, salary 급여, salary * 12 연봉
FROM employee;

-- 산술연산식으로 정의된 컬럼은 데이터 추가 불가!
INSERT INTO vw_emp_sal
VALUES (300, '홍길동', 3000000, 36000000); -- Error Code: 1348. Column '연봉' is not updatable

-- 왜? 산술연산식이 컬럼에 같이 들어간 경우도 데이터 추가 불가능!!
INSERT INTO vw_emp_sal(사번, 이름, 주민번호, 급여)
VALUE (301, '홍길동', '000000-0000000', 3000000); 

-- 산술연산으로 정의된 컬럼은 데이터 변경 불가능!
UPDATE vw_emp_sal
SET 연봉 = 80000000
WHERE emp_id = 200; -- Error Code: 1348. Column '연봉' is not updatable

UPDATE vw_emp_sal
SET salary = 7000000
WHERE emp_id = 200;

UPDATE vw_emp_sal
SET 급여 = 8000000
WHERE 사번 = 200; -- 산술연산과 무관한 컬럼은 데이터 변경 가능!

-- DELETE 가능!
DELETE FROM vw_emp_sal
WHERE 연봉 = 72000000;

DELETE FROM vw_emp_sal
WHERE salary * 12 = 46800000;

SELECT * FROM vw_emp_sal;
SELECT * FROM employee;

SELECT * FROM vw_job;
SELECT * FROM job;

-- 4. 그릅함수나 GROUP BY 절을 포함한 경우
-- 부서별 급여의 합계 평균을 조회한 SELECT문을 vw_groupdeft에 뷰로 정의
CREATE OR REPLACE VIEW vw_groupdeft
AS SELECT dept_code 부서, sum(salary) 합계, avg(salary) 평균
FROM employee
GROUP BY dept_code;

SELECT * FROM vw_groupdeft;

-- INSERT (에러)
INSERT INTO vw_groupdeft
VALUES ('D11', 80, 40);

-- UPDATE (에러)
UPDATE vw_groupdeft
SET 합계 = 800
WHERE dept_code = 'D1';

-- DELETE (에러)
DELETE FROM vw_groupdeft
WHERE dept_code = 'D1';

-- 5. DISTINCT 구문이 포함된 경우
-- employee 테이블로 job_code만 중복 없이 조회한 SELECT 문을 vw_dt_job 뷰 정의
CREATE OR REPLACE VIEW vw_dt_job
AS SELECT DISTINCT job_code 
FROM employee;

-- INSERT (에러)
INSERT INTO vw_dt_job
VALUE ('J8');

-- UPDATE (에러)
UPDATE vw_dt_job
SET job_code = 'J8'
WHERE job_code = 'J7';

-- DELETE (에러)
DELETE FROM vw_dt_job
WHERE job_code = 'J7';

SELECT * FROM vw_dt_job;
-- 6. JOIN을 이용해서 여러 테이블을 연결한 경우
-- 사원들의 사번, 사원명, 주민번호, 부서명 조회한 SELECT 문을 vw_joinemp 뷰 정의
CREATE OR REPLACE VIEW vw_joinemp
AS SELECT emp_id, emp_name, emp_no, dept_title 
FROM employee
left JOIN department ON (dept_code = dept_id);

SELECT * FROM vw_joinemp;

-- INSERT (에러)
INSERT INTO vw_joinemp
VALUE (300, '김현호', '971110-1056516', '부부'); -- 조인된 컬럼에 값을 추가하려고 하면 오류가 발생!

INSERT INTO vw_joinemp(emp_id, emp_name, emp_no)
VALUE (300, '김현호', '971110-1056516'); -- 조인되지 않은 employee가 원래 가지고 있던 컬럼은 추가 가능!

-- UPDATE (가능!!)
UPDATE vw_joinemp
SET dept_title = '부서'
WHERE emp_id = 200;
-- 조인된 컬럼의 값을 변경하는 것도 가능! BUT 해당 값을 함께 사용하는 모든 행의 값이 같이 변경됨!

-- DELETE (에러)
DELETE FROM vw_joinemp
WHERE emp_id = 220;

-- 7. VIEW 옵션
-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 에러 발생!
-- 급여가 3000000원 이상인 사원들만 조회한 SELECT문을 vw_emp 뷰 정의
CREATE OR REPLACE VIEW vw_emp
AS SELECT *
FROM employee
WHERE salary >= 3000000;


-- 200번 사원의 급여를 200만원으로 변경
UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 200;

-- WITH CHECK OPTION 사용!
CREATE OR REPLACE VIEW vw_emp
AS SELECT *
FROM employee
WHERE salary >= 3000000
WITH CHECK OPTION;

-- 202번 사원의 급여를 200만원으로 변경
UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 202; -- Error Code: 1369. CHECK OPTION failed 'kh.vw_emp'
-- WITH CHECK OPTION을 넣으면 조건에 부합하지 않으면 에러 발생!

UPDATE vw_emp
SET salary = 4000000
WHERE emp_id = 202; 
-- 조건 충족! 정상 작동!


SELECT * FROM vw_emp;
SELECT * FROM employee;

