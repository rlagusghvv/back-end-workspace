/*
 함수 : 전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
 
 - 단일행 함수 : N개의 값을 읽어서 N개의 결과값 리턴 (매 행마다 함수 실행 결과 반환)
 - 그룹 함수 : N개의 값을 읽어서 1개의 결과값 리턴 (그룹별로 함수 실행 결과 반환)
 
>> SELECT 절에 단일행 함수와 그룹 함수는 함께 사용 불가!
   WHY? -> 결과 행의 개수가 다르기 때문에!
   
>> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, (GROUP BY, HAVING) -> 이후에 배우게됨
   
*/

-- 단일행 함수

/*

  문자 처리 함수 
  
  LENGTH() : 해당 문자열값의 BYTE 길이 수 반환
  - 한글 한 글자 -> 3BYTE
  - 영문자, 숫자, 특수문자 한글자 -> 1BYTE
  CHAR_LENGTH : 해당 문자열값의 글자 수 반환
  
*/

SELECT LENGTH('데이터베이스'), -- 한글은 한 글자당 3BYTE -> 18 반환
CHAR_LENGTH('데이터베이스'), -- 글자 수 그대로 반환 -> 6 반환
LENGTH('database'),
CHAR_LENGTH('database'); -- 영어는 함수 상관없이 반환값 동일!

-- 사원명(emp_name), 사원명의 글자수, 이메일(email), 이메일의 글자수 조회
SELECT emp_name, CHAR_LENGTH(emp_name) "사원명의 글자수", email, CHAR_LENGTH(email) "이메일의 글자수"
FROM employee;

/*
  INSTR(컬럼 | '문자열', '찾으려는 문자열')
  - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
*/

SELECT INSTR('AABAACAABBAA', 'B'), INSTR('AABAACAABBAA', 'D'); -- 3, 0

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회

SELECT email, INSTR(email, '@')
FROM employee
WHERE email LIKE "%s%";

/*

  LPAD|RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
  - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 덧붙여서
    최종적으로 반환할 문자의 길이만큼 문자열 반환
    
*/
SELECT LPAD('hello', 10, '*'), RPAD('hello', 10, "+");
SELECT LPAD('hello', 10, 'world'), RPAD('hello', 10, "mysql");

/*

  TRIM(컬럼|'문자열') | TRIM([LEADING(앞)|TRAILING(뒤)|BOTH(양쪽) 제거하고자하는문자들 FROM 컬럼|'문자열')
  - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
  
*/
SELECT TRIM('     KH     '); -- 기본적으로 양쪽에 있는 공백 제거
SELECT TRIM(BOTH ' ' FROM '     K    H     ');

SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'); -- KHZZZ (앞쪽만 제거!) <-- 문자 제거는 LEADING
SELECT LTRIM('     KH     '); -- LTRIM : 앞쪽 공백만 제거

SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'); -- ZZZKH
SELECT RTRIM('     KH     '); -- RTRIM : 뒤쪽 공백만 제거

/*

  SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
  - 문자열에서 특정 문자열을 추출해서 반환
  
*/

SELECT SUBSTR('PROGRAMMING', 5, 2); -- RA
SELECT SUBSTR('PROGRAMMING', 1, 6); -- PROGRA
SELECT SUBSTR('PROGRAMMING', -8, 3); -- GRA

-- 여자 사원들의 이름(emp_name), 주민등록번호(emp_no) 조회
SELECT emp_name, emp_no
FROM employee
-- WHERE emp_no LIKE "%-2%" OR emp_no LIKE "%-4%";
WHERE SUBSTR(emp_no, 8, 1) IN (2,4);

SELECT emp_name, emp_no
FROM employee
-- WHERE SUBSTR(emp_no, 8, 1) IN (1,3);
WHERE SUBSTR(emp_no, INSTR(emp_no, '-') + 1, 1) IN (1,3); -- 함수 내에서 함수 사용 가능!

/*

  LOWER : 다 소문자로 변경한 문자열 반환
  UPPER : 다 대문자로 변경한 문자열 반환
  
*/

SELECT LOWER('Welcome To MySQL'), UPPER('Welcome To MySQL');
-- LOWER : welcome to mysql
-- UPPER : WELCOME TO MYSQL

/*

  REPLACE(컬럼|'문자열', '바꾸고 싶은 문자열', '바꿀 문자열')
  - 특정 문자열로 변경하여 반환 
  
*/

SELECT REPLACE('서울특별시 강남구 역삼동', '강남구', '서초구');

/*

  CONCAT : 문자열을 하나로 합친 후 결과 반환
  
*/

SELECT CONCAT('가나다라', 'ABCD', '1234'); -- 가나다라ABCE1234


-- 실습문자 ---

-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회

SELECT emp_name 이름, email 이메일, REPLACE(email, 'kh.or.kr', 'gmail.com') "변경 후 이메일"
FROM employee;

-- 2. 사원명과 주민등록번호(00000-0******)으로 조회
-- SELECT emp_name, REPLACE(emp_no, SUBSTR(emp_no, -6, 6), "******")
-- SELECT emp_name, CONCAT(SUBSTR(emp_no,1,8), "******")
SELECT emp_name, RPAD((SUBSTR(emp_no, 1, INSTR(emp_no, '-') + 1)), 14, '*')
FROM employee;

-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회 (@ 앞)
-- REPLACE
-- SELECT emp_name, email, REPLACE(email, '@kh.or.kr', '')
-- substr, instr
-- SELECT emp_name, email, substr(email, 1, INSTR(email,'@')-1)
-- TRIM
-- SELECT emp_name, email, trim(both '@kh.or.kr' from email)

SELECT emp_name, email, REPLACE(email, SUBSTR(email, INSTR(email,"@")), "")
FROM employee;


/*

 숫자 처리 함수
 
 ABS : 절대값 반환
 
*/

SELECT ABS(5.6), ABS(-10);


/*

 숫자 DIV 숫자 = 숫자 / 숫자
 숫자 MOD 숫자 = 숫자 % 숫자 = MOD(숫자, 숫자)
 
*/

SELECT 10/5, 10 DIV 5, -- DIV를 사용하면 정수값으로 반환
10 % 3, 10 MOD 3, MOD(10,3);

/*

  ROUND(숫자, [위치)] --> 위치 : 1(소수점 첫째자리), -1(10의 자리)
  - 반올림한 결과를 반환
  
*/

SELECT ROUND(123.567), ROUND(123.567, 1), ROUND(123.567, -1);


/*

  CEIL(숫자)
  - 올림 처리해서 반환
  FLOOR(숫자)
  - 버림 처리해서 반환
  
*/

SELECT CEIL(123.152), FLOOR(123.952);

/*

  TRUNCATE(숫자, 위치) --! 위치 지정이 필수! - 위치가 없다면 실행 x
  - 위치 지정하여 버림 처리
  
*/

SELECT TRUNCATE(123.456, 1), TRUNCATE(123.456, -1);


/*

  날짜 처리 함수
  NOW, CURRENT_TIMESTAMP : 현재 날짜와 시간 반환
  CURDATE, CURRENT_DATE : 현재 날짜 반환
  CURTIME, CURRENT_TIME : 현재 시간 반환
  
*/

SELECT NOW(), CURRENT_TIMESTAMP(), CURDATE(), CURRENT_DATE(), CURTIME(), CURRENT_TIME();

/*

 DAYOFYEAR : 날짜가 해당 연도에서 몇 번째 날인지 반환
 DAYOFMONTH : 날짜가 해당 월에서 몇 번쨰 날인지 반환
 DAYOFWEEK : 날짜가 해당 주에서 몇 번째 날인지 반환 (일요일 = 1, 토요일 7)
 
*/

SELECT DAYOFYEAR(NOW()), DAYOFMONTH(NOW()), DAYOFWEEK(NOW());

/*

  PERIOD_DIFF(날짜, 날짜) : 두 기간의 차이를 숫자로 반환
  DATEDIFF(날짜, 날짜) : 두 날짜 사이의 일수를 숫자로 반환
  TIMEDIFF(날짜, 날짜) : 두 시간의 차이를 날짜 형식으로 반환
  TIMESTAMPDIFF(날짜단위, 날짜, 날짜) : 두 날짜 사이의 기간을 날짜단위에 따라 변환
  
  * 날짜단위 : YEAR(연도), QUARTER(분기), MONTH(월), WEEK(주), DAY(일)
             HOUR(시간), MINUTE(분), SECOND(초)
             
*/

SELECT PERIOD_DIFF(202406, 202411), PERIOD_DIFF(202412, 202406); -- -5, 6
SELECT DATEDIFF('2024-12-31', NOW()), TIMEDIFF('2025-01-01 00:00:00', NOW()); 

-- 직원명, 입사일, 근무 일 수 , 근무 개월 수 , 근무 년수 조회
SELECT emp_name, hire_date, DATEDIFF(NOW(), hire_date) "근무 일 수" , TIMESTAMPDIFF(MONTH, hire_date , NOW()) "근무 개월 수", TIMESTAMPDIFF(YEAR, hire_date, NOW()) "근무 년수"
FROM employee
ORDER BY 3 DESC;


/*

 ADDDATE(날짜, INTERVAL 숫자 날짜단위)
 ADDTIME(날짜, 시간정보)
 - 특정 날짜에 입력받은 정보만큼 더한 날짜를 반환
 
 SUBDATE(날짜, INTERVAL 숫자 날짜단위)
 SUBDTIME(날짜, 시간정보)
 - 특정 날짜에 입력받은 정보만큼 뺀 날짜를 반환
 

*/

SELECT NOW(), ADDDATE(NOW(), INTERVAL 1 HOUR), SUBDATE(NOW(), INTERVAL 1 HOUR), ADDTIME(NOW(), "01:00:00"), SUBTIME(NOW(), "01:00:00");

-- 직원명(emp_name), 입사일(hire_date), 입사 후 6개월이 된 날짜를 조회
SELECT emp_name, hire_date, ADDDATE(hire_date, INTERVAL 6 month)  "입사 후 6개월"
FROM employee
ORDER BY 2;

/*

  LAST_DAY : 해당 월의 마지막 날짜를 반환

*/

SELECT LAST_DAY(NOW());


/*

  YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
  - 특정 날짜에 연도, 월, 일, 시간, 분, 초 정보를 각각 추출해서 반환

*/

SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());


-- 연도별 오래된 순으로 직원명, 입사년도, 입사월, 입사일 조회
SELECT emp_name 이름, YEAR(hire_date) 입사년도, MONTH(hire_date) 입사월, DAY(hire_date) 입사일
FROM employee
-- ORDER BY hire_date; 
ORDER BY 입사년도, 입사월, 입사일;

/*

  FORMAT(숫자, 위치) : 숫자에 3단위씩 콤마 추가해서 반환 - 화폐 단위 표시할때 사용!
  DATE_FORMAT(날짜, 포맷형식) : 날짜 형식을 변경해서 반환

*/

SELECT salary, FORMAT(salary, 0)
FROM employee;

SELECT hire_date
FROM employee;

SELECT NOW(), DATE_FORMAT(now(), '%Y.%m.%d'), -- %Y : 년도, %m : 월, %d : 일
DATE_FORMAT(NOW(), '%Y.%m.%d %h/%'); -- %T : 시간 전체, %H : 시, %i : 분, %s : 초

-- 직원명, 입사일(EX) 2024년 06월 19일 14시 05분 30초) 조회
SELECT emp_name, DATE_FORMAT(hire_date, '%Y년 %m월 %d일 %H시 %i분 %s초') "입사일시"
FROM employee
ORDER BY 입사일시;


/*

  null 처리 함수
  
  COALESCE | IFNULL (값, 값이 NULL일 경우 반환할 값)
  

*/

SELECT emp_name, COALESCE(bonus, 0), IFNULL(bonus, 1)
FROM employee;

-- 전 사원의 직원명, 보너스, 보너스 포함 연봉((salary + salary * bonus) * 12) 조회
SELECT emp_name, bonus, (salary + salary * IFNULL(bonus, 0)) * 12 "보너스포함연봉"
FROM employee
ORDER BY 3;

-- 직원명, 부서코드(dept_code) 조회 (부서코드가 없으면 '부서없음')
SELECT emp_name, IFNULL(dept_code, '"부서없음"')
FROM employee;

/*

  NULLIF(값1, 값2)
  - 두 개의 값이 동일하면 null 반환, 두 개의 값이 동일하지 않으면 값1 반환

*/

SELECT NULLIF('123','123'), NULLIF('1234','123'); -- null, 1234


/*

  IF(값1, 값2, 값3) || IF(조건, 조건이 TRUE인 경우, 조건이 False인 경우)
  - 값1이 null이 아니면, 값2 반환, null이면 값3 반환
  값1 = NOT null : 값2 반환
  값1 = null : 값3 반환 
  - 조건에 해당하면 두번째 값 반환, 해당하지 않으면 마지막 값 반환

*/

SELECT emp_name, bonus, if(bonus, bonus, "해당없음") -- bonus가 있으면 bonus값 반환 / null이면 "해당없음" 반환
FROM employee;

-- 직원명, 부서코드가 있으면 '부서있음', 없으면 '부서없음' 조회
SELECT emp_name, dept_code, if(dept_code IS NULL, '부서없음', '부서있음') -- 값이 숫자가 아닌경우 컬럼만으로 null을 판단하지 못하는 경우가 있음!! 해당 경우에는 조건 걸기!
FROM employee;


-- 사번, 사원명 주민번호(emp_no), 성별(남, 여) - emp_no 활용해서! 조회
SELECT emp_id, emp_name, emp_no, IF(SUBSTR(emp_no, INSTR(emp_no, "-") +1, 1) IN ("1","3") , "남성", "여성") "성별"
FROM employee
ORDER BY 성별;

-- 사원명, 직급코드(job_code), 기존급여(salary), 기존급여(salary), 인상된 급여 조회
-- 정렬 : 직급코드 J1부터, 인상된 급여 높은 순서대로
-- 직급코드가 J7인 사원은 급여를 10% 인상
-- 직급코드가 J6인 사원은 급여를 15% 인상
-- 직급코드가 J5인 사원은 급여를 20% 인상
-- 그 외의 직급의 사원은 급여를 5%만 인상

SELECT emp_name, job_code, salary, FORMAT(floor(IF(job_code = "J7", salary*1.1, IF(job_code = "J6", salary*1.15, IF(job_code = "J5", salary*1.2, salary*1.05)))),0) "인상급여"
FROM employee
ORDER BY job_code, 인상급여 DESC;
-- 여러개의 조건을 IF를 통해 거는 경우 FALSE 값에 다시 조건을 걸어주면 됨!

/*

  CASE WHEN 조건식 1 THEN 결과값 1
       WHEN 조건식 2 THEN 결과값 2
       ....
       ELSE 결과값 N
       END

--> if ~ else if ~ else 문과 유사

*/

SELECT emp_name, job_code, salary, FORMAT
(CASE WHEN job_code = "J7" THEN salary*1.1 
WHEN job_code = "J6" THEN salary*1.15 
WHEN job_code = "J5" THEN salary*1.2 
ELSE salary*1.05 
END
,0) "인상급여"
FROM employee
ORDER BY job_code, 인상급여 DESC;

-- 사원명, 급여, 급여 등급(1 ~ 4등급) 조회
-- salary 값이 500만원 초과일 경우 1등급
-- salary 값이 500만원 이하 350만원 초과일 경우 2등급
-- salary 값이 350만원 이하 200만원 초과일 경우 3등급
-- 그 외의 경우 4등급

SELECT emp_name 이름, FORMAT(salary,0) 연봉, 
CASE WHEN salary > 5000000 THEN "1등급"
WHEN salary > 3500000 THEN "2등급"
WHEN salary > 2000000 THEN "3등급"
-- WHEN salary BETWEEN 3500001 and 5000000 THEN "2등급"
-- WHEN salary BETWEEN 2000001 and 3500000 THEN "3등급"
ELSE "4등급"
END "연봉등급"
FROM employee
ORDER BY salary DESC; 


/*

  그룹함수 --> 결과값 1개!
  - 대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들
  - 모든 그룹 함수는 NULL 값을 자동으로 제외하고 값이 있는 것들만 계산!
  
  SUM : 해당 컬럼 값들의 총 합계 반환

*/

SELECT SUM(salary) -- 행별 salary의 컬럼값은 쓸 수 없음!
FROM employee;

-- 부서코드가 D5인 사원들의 총 연봉(급여*12) 조회
SELECT FORMAT(SUM(salary*12),0)
FROM employee
WHERE dept_code = "D5";

SELECT FORMAT(SUM(case WHEN dept_code = 'D5' THEN salary * 12 END), 0)
FROM employee;


/*

  AVG
  - 해당 컬럼 값들의 평균값을 반환
  - 모든 그룹 함수는 NULL 값을 자동으로 제외하기 때문에
    AVG 함수를 사용할 때는 COALESCE 또는 IFNULL 함수와 함께 사용하는 걸 권장

*/
-- 전체 사원의 평균 급여, 평균 보너스율 조회
SELECT 
avg(salary), avg(bonus),
avg(ifnull(salary,0)), avg(ifnull(bonus,0)) -- null 값이 없는 salary는 값이 동일하지만, null이 있는 bonus는 값이 상이 - 정확한 평균을 위해서는 null 값을 0으로 치환해주어야함.
FROM employee;


/*

   MIN : 해당 컬럼 값들 중에 가장 작은 값 반환
   MAX : 해당 컬럼 값들 중에 가장 큰 값 반환
   
   수가 아닌 문자는 (a-z, 가-하)순으로!

*/


SELECT 
     min(emp_name), min(salary), min(hire_date),
	 max(emp_name), max(salary), max(hire_date)
FROM employee;


/*


  COUNT 
  - 컬럼 또는 행의 개수를 세서 반환

  * : 조회 결과에 해당하는 모든 행 개수를 반환
  컬럼 : 해당 컬럼값이 NULL이 아닌 행 개수 반환
  distinct 컬럼 : 해당 컬럼값의 중복을 제거한 행 개수 반환 (카테고리 개수 확인 가능!)
*/

-- 전체 사원 수 조회
SELECT count(*)
FROM employee;

-- 보너스를 받은 사원 수 조회 (보너스 값이 NULL이 아닌 사원 수)
SELECT COUNT(bonus)
FROM employee;

SELECT COUNT(bonus)
FROM employee
WHERE bonus IS NOT NULL;

-- 현재 사원들이 속해있는 부서 수 조회
SELECT count(distinct dept_code)
FROM employee;

-- 퇴사한 직원의 수 조회
SELECT count(*)
FROM employee
WHERE ent_date IS NOT NULL;

SELECT count(*)
FROM employee
WHERE ent_yn = "Y";

SELECT count(ent_date) -- NULL 값은 제외하고 수를 세기 때문에 따른 조건 없이도 가능!
FROM employee;