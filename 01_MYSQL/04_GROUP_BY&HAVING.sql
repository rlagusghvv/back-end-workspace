/*

  GROUP BY
  - 그룹 기준을 제시할 수 있는 구문
  - 여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용

*/

-- 각 부서별 조회
SELECT dept_code, 
       COUNT(*) "사원 수",
       FORMAT(sum(salary), 0) "총 급여",
       FORMAT(avg(salary), 0) "평균 급여",
       min(salary) "최소 급여",
       MAX(salary) "최대 급여"
FROM employee
GROUP BY dept_code;

-- 직급 코드(job_code)별 사원 수 조회
SELECT job_code, COUNT(*) 사원
FROM employee
GROUP BY job_code;
-- GROUP BY 사용시 SELECT에 오는 컬럼은 GROUP BY에 사용된 컬럼만 올 수 있음!

-- 성별(남자/여자) 별 사원 수 조회
-- SELECT COUNT(*) "성별별 사원 수"
-- FROM employee
-- GROUP BY IF(SUBSTR(emp_no, INSTR(emp_no, "-") +1, 1) IN ("1","3") , "남성", "여성");

SELECT if(SUBSTR(emp_no, 8, 1)=1, '남자', '여자') 성별, COUNT(*) 사원수
FROM employee
GROUP BY 성별;


/*

 HAVING 
 - 그룹에 대한 조건을 제시할 떄 사용하는 구문
 
 SELECT  * | 조회하고자 하는 컬럼명, 별칭 | 함수
 FROM    조회하고자 하는 테이블 명
 WHERE   조건식 (연산자들 가지고 기술)
 GROUP BY  그룹 기준에 해당하는 컬럼명 | 함수
 HAVING  조건식 (그룹 함수를 가지고 기술)
 ORDER BY 컬럼명 | 컬럼순번 | 별칭 [ASC(default) | DESC];
 
*/

-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
SELECT dept_code, FORMAT(AVG(salary), 0) 평균급여
FROM employee
GROUP BY dept_code
HAVING AVG(salary) >= 3000000
ORDER BY 평균급여 DESC;

SELECT dept_code, FORMAT(AVG(salary), 0) 평균급여
FROM employee
GROUP BY dept_code
HAVING 평균급여 >= FORMAT(3000000, 0)
ORDER BY 평균급여 DESC;

-- 직급별 총 급여의 합이 1000만원 이상인 직급만 조회
SELECT job_code 부서, FORMAT(SUM(salary),0) 급여총계
FROM employee
GROUP BY job_code
HAVING SUM(salary) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT dept_code 
FROM employee
GROUP BY dept_code
HAVING SUM(bonus) IS NULL;
-- COUNT(bonus) = 0;


-- 부서별 보너스를 받는 사원들만 조회
SELECT if(dept_code IS null, "부서미배정", dept_code) 부서, COUNT(*) "보너스 수령인 수" -- 보너스가 null이 아닌 경우에 대한 조건!
FROM employee
WHERE bonus IS NOT NULL
GROUP by dept_code;

SELECT dept_code, Count(bonus)
FROM employee
GROUP BY dept_code
HAVING COUNT(bonus) != 0;


/*

  rollup|cube(컬럼1, 컬럼2) (cube는 MYSQL X) - 실제 볼일은 없는 집계 함수
  - 그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수
  - rollup : 컬럼1을 가지고 다시 중간집계를 내는 함수
  - cube : 컬럼1을 가지고 중간집계도 내고, 컬럼2를 가지고 중간집계를 냄

  MYSQL에서의 rollup
  컬럼1, 컬럼2 with rollup
  
  grouping : rollup이나 cube에 의해 산출된 값이 해당 컬럼 집합의 산출물이면 0, 아니면 1
  -> 집계된 값인지, 아닌지 정도만 구분
  
  SQLD 자격증 시험에서 꼭 이상하게 나오기도 하나, 실제로 쓰이는 일은 없음!!
  
*/

-- 부서별, 직급별 급여 합 조회
SELECT job_code, dept_code, SUM(salary)
FROM employee
GROUP BY job_code, dept_code with rollup; -- 각 job 코드 별 합계를 보여줌!


/*

   집합 연산자
   - 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
   - 여러 개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야 사용할 수 있다.
   
   주의! ORDER BY 절은 쓰려면 마지막(마지막 쿼리문!)에만 기술 가능 !!
   
   UNION (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 (중복되는 행 제거)
   UNION ALL (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 (중복되는 행 제거 X)
   INTERSECT (교집합) : 두 쿼리문을 수행한 결과값에 중복된 결과값만을 추출 (MYSQL X)
   MINUS (차집합) : 선행 쿼리문의 결과값에서 후행 쿼리문의 결과값을 뺀 나머지 결과값만 추출 (MYSQL X)

*/

-- 1. UNION
-- (1) 부서 코드가 D5인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE dept_code = "D5"
UNION 
-- (2) 급여가 300만원 초과인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000;

-- 2. UNION ALL
-- (1) 부서 코드가 D5인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE dept_code = "D5"
UNION ALl
-- (2) 급여가 300만원 초과인 사원들의 사번, 사원명, 부서코드, 급여 조회
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000
ORDER BY emp_id;
-- 위 쿼리문 대신 WHERE 절에 OR 연산자를 사용해서 처리하는 편이 간단
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE dept_code = "D5" or salary > 3000000;