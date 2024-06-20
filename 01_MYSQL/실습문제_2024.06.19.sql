
-- 실습 문제 ---
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의 사번, 직원명, 직급명, 부서명, 근무지역, 급여 조회
SELECT emp_id, emp_name, job_name, dept_title, local_name, FORMAT(salary, 0)
FROM employee
FULL JOIN department ON (dept_code = dept_id)
JOIN job USING (job_code)
LEFT JOIN location ON (location_id=local_code)
WHERE job_name = "대리" AND local_name LIKE "%ASIA%";


-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 직원명, 주민번호, 부서명, 직급명 조회      
SELECT emp_name, emp_no, dept_title, job_name
FROM employee
FULL JOIN department ON (dept_code = dept_id)
JOIN job USING (job_code)
WHERE emp_no LIKE "7%" AND emp_name LIKE "전%";
                                         
-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회
SELECT emp_name, bonus, salary * 12, dept_title, local_name
FROM employee
FULL JOIN department ON (dept_code = dept_id)
JOIN location ON (location_id=local_code)
WHERE bonus IS NOT NULL;

-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무국가 조회
SELECT emp_name, dept_title, local_name, national_code
FROM employee
FULL JOIN department ON (dept_code = dept_id)
JOIN location ON (location_id=local_code)
WHERE national_code IN ("JP", "KO");


-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여 조회
SELECT dept_title, FORMAT(AVG(IFNULL(salary,0)),0) "평균급여"
FROM employee
FULL JOIN department ON (dept_code = dept_id)
GROUP BY dept_title;

-- 6. 각 부서별 총 급여의 합이 1,000만원 이상인 부서명, 급여 합 조회
SELECT dept_title, FORMAT(SUM(salary),0) "급여총계"
FROM employee
FULL JOIN department ON (dept_code = dept_id)
GROUP BY dept_title
HAVING SUM(salary) >= 10000000
ORDER BY 급여총계 DESC;

-- 7. 사번, 직원명, 직급명, 급여 등급, 구분 조회
-- 이때 구분에 해당하는 값은 아래 참고!
-- 급여 등급이 S1, S2인 경우 '고급'
-- 급여 등급이 S3, S4인 경우 '중급'
-- 급여 등급이 S5, S6인 경우 '초급'
/*

  3. 비등가 조인 (NON EQUAL JOIN)
  - 매칭시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하지 않는 조인문
  - 값의 범위에 포함되는 행들을 연결하는 방식
  - ANSI 구문으로는 JOIN ON만 사용 가능! (USING 사용 불가)
  
*/
SELECT IFNULL(emp_id,0), IFNULL(emp_name,0), IFNULL(job_name,0), IFNULL(sal_level,0), CASE WHEN sal_level IN ("S1","S2") THEN "고급" WHEN sal_level IN ("S3","S4") THEN "중급" WHEN sal_level IN ("S5", "S6") THEN "초급" END 구분
FROM employee
JOIN job USING (job_code)
JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal)
ORDER BY 5;

-- 9. 보너스를 받지 않은 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여 조회
SELECT emp_name, job_name, FORMAT(salary,0), bonus, job_code
FROM employee
LEFT JOIN department ON (dept_code = dept_id)
JOIN job USING (job_code)
WHERE bonus IS NULL AND job_code IN ("J4", "J7");

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명 조회
SELECT emp_name, job_name, dept_code, dept_title
FROM employee
LEFT JOIN department ON (dept_code = dept_id)
JOIN job USING (job_code)
WHERE dept_title LIKE "해외%";

-- 11. 이름에 "형"자가 들어있는 직원들의 사번, 직원명, 직급명 조회
SELECT emp_id, emp_name, job_name
FROM employee
JOIN job USING (job_code)
WHERE emp_name LIKE "%형%";

-- 12. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회
-- 참고로 employee, job, department, location, national, sal_grade
SELECT emp_id, emp_name, dept_title, job_name, local_name, national_name, sal_level
FROM employee
JOIN department ON (ifNULL(dept_id,0) = IFNULL(dept_code,0))
JOIN job USING (job_code)
JOIN location ON (IFNULL(location_id,0)=IFNULL(local_code,0))
JOIN national USING(IFNULL(national_code,0))
JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal);


SELECT emp_id, emp_name, dept_title, job_name, local_name, national_name, sal_level
FROM employee
LEFT JOIN department ON (dept_id = dept_code)
JOIN job USING (job_code)
LEFT JOIN location ON (location_id = local_code)
LEFT JOIN national USING (national_code)
JOIN sal_grade ON (min_sal <= salary AND salary <= max_sal);


