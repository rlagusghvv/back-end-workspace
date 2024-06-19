-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT *
FROM actor
Where first_name LIKE "A%";

-- 2. film_list 테이블에서 category가 Sci-Fi 또는 Family면서
-- rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회

SELECT title
FROM film_list
WHERE category IN ("Sci-Fi", "Family") AND rating = "PG" AND title LIKE "%GO%";

-- 3. film_list 테이블에서 fid가 7 이하면서 4, 6은 아닌 fid, title 조회
SELECT fid, title
FROM film_list
WHERE fid < 7 AND fid NOT IN (4,6);
-- fid가 7인 행이 있음

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나 Animation이고 
-- 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회 
SELECT title
FROM film_list
WHERE price BETWEEN 2 AND 4 AND category IN ("Documentary", "Animation") AND actors LIKE "%BOB%";

-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회
/*

  SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
  - 문자열에서 특정 문자열을 추출해서 반환
  
*/
/*
  INSTR(컬럼 | '문자열', '찾으려는 문자열')
  - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
*/
SELECT SUBSTR(address, INSTR(address, " ")+1, char_length(address) - INSTR(address, " ")) "address", district ""
FROM address
WHERE district IS NOT NULL AND district != ''
ORDER BY 2,1 DESC
LIMIT 10;

-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회
SELECT ID, name
FROM customer_list
ORDER BY 1
LIMIT 5, 10;

-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
/*

  CONCAT : 문자열을 하나로 합친 후 결과 반환
  
*/
/*

  TRIM(컬럼|'문자열') | TRIM([LEADING(앞)|TRAILING(뒤)|BOTH(양쪽) 제거하고자하는문자들 FROM 컬럼|'문자열')
  - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
  
*/
SELECT CONCAT(TRIM(first_name),TRIM(last_name)) 이름, char_length(CONCAT(TRIM(first_name),TRIM(last_name))) 글자수
FROM actor
WHERE CONCAT(TRIM(first_name),TRIM(last_name)) LIKE "J%"
ORDER BY 글자수 DESC
LIMIT 10;

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
/*

  SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
  - 문자열에서 특정 문자열을 추출해서 반환
  
*/
/*
  INSTR(컬럼 | '문자열', '찾으려는 문자열')
  - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
*/
/*

  DISTINCT
  - 컬럼에 중복된 값들을 한번씩만 표시하고자 할 때 사용!
  
*/
SELECT DISTINCT(SUBSTR(description, 1, INSTR(description, " of"))) "of 이전 문장"
FROM film
ORDER BY 1 DESC
LIMIT 10;

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
SELECT MIN(replacement_cost) 최소비용, MAX(replacement_cost) 최대비용
FROM film;