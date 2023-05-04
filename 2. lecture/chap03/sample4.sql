-- sample20.sql


-- ******************************************************
-- SELECT 문의 기본구조와 각 절의 실행순서
-- ******************************************************
--  - Clauses -                 - 실행순서 -
--
-- SELECT clause                        (5)
-- FROM clause                          (1)
-- [ WHERE clause ]                     (2)
-- [ GROUP BY clause ]                  (3)
-- [ HAVING clause ]                    (4)
-- [ ORDER BY clause ]                  (6)
-- ******************************************************


-- ------------------------------------------------------
-- 1. 단일(행) (반환)함수
-- ------------------------------------------------------
-- 단일(행) (반환)함수의 구분:
--
--  (1) 문자 (처리)함수 : 문자와 관련된 특별한 조작을 위한 함수
--  (2) 숫자 (처리)함수 : 
--  (3) 날짜 (처리)함수 :
--  (4) 변환 (처리)함수 : 숫자/문자/날짜 데이터 간의 형 변환 함수
--      a. TO_CHAR   - 숫자 데이터를 문자 데이터로 변환 또는
--                     날짜 데이터를 문자 데이터로 변환
--      b. TO_NUMBER - 문자 데이터를 숫자 데이터로 변환
--      c. TO_DATE   - 문자 데이터를 날짜 데이터로 변환
--  (5) 일반 (처리)함수 :
--
--  단일(행) (반환)함수는, 테이블의 행 단위로 처리됨!
-- ------------------------------------------------------

-- ------------------------------------------------------
-- Oracle Type Conversions (Chapter03 - page 52 참고)
-- ------------------------------------------------------
-- 1. 자동 형변환 (묵시적 형변환) - Promotion
--
--    <NUMBER> <--> <CHARACTER> <--> <DATE>
--
-- 2. 강제 형변환 (명시적 형변환) - Casting
--
-- (1) <NUMBER>     -- TO_CHAR      --> <CHARACTER>
--     <CHARACTER>  -- TO_NUMBER    --> <NUMBER>
-- (2) <CHARACTER>  -- TO_DATE      --> <DATE>
--     <DATE>       -- TO_CHAR      --> <CHARACTER>
-- (3) <NUMBER>     --    X         --> <DATE>
--     <DATE>       --    X         --> <NUMBER>
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (0) 자동 형변환 (Promotion) 예
-- ------------------------------------------------------
-- 문자타입(CHARACTER) --> 숫자타입(NUMBER)
-- ------------------------------------------------------
DESC employees;


SELECT
    last_name,
    salary
FROM
    employees
WHERE
    -- 자동형변환: 숫자 <-> 문자
    salary = '17000';  -- 숫자=문자 비교? (컬럼 타입에 맞춰줌)


-- ------------------------------------------------------
-- (4) 변환 (처리)함수 - TO_CHAR
-- ------------------------------------------------------
-- 1. 날짜 데이터를 문자 데이터로 변환
--    예: TO_CHAR( hire_date, 'YYYY' )
--
-- 2. 숫자 데이터를 문자 데이터로 변환
--    예: TO_CHAR( 123456, '999,999' )
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 1. 날짜 데이터를 문자 데이터로 변환
--    예: TO_CHAR( hire_date, 'YYYY' )
-- ------------------------------------------------------
SELECT
    -- sysdate, systimestamp (X) => current_date, current_timestamp
    -- to_char(current_date, 'YYYY/MM/DD (AM) DY HH24:MI:SS')
    to_char(current_date, 'YYYY/MM/DD HH24:MI:SS')
FROM
    dual;


SELECT
    last_name,
    hire_date,
    salary
FROM
    employees
WHERE
    -- 날짜 -> 문자 데이터로 강제 형변환
    to_char(hire_date, 'MM') = '09';


SELECT
    -- 날짜 -> 문자 데이터로 강제 형변환
    -- 포맷팅할 때 '' 안의 다국어 문자는 ""을 써야 한다.(컬럼 별칭 외에 유일하게 다른 곳에 쓰이는 "")
    to_char(current_date, ' YYYY "년" MM "월" DD "일" ') AS 날짜
    -- to_char(current_date, ' YYYY 년 MM 월 DD 일 ') AS 날짜   --XX
FROM
    dual;


-- ------------------------------------------------------
-- 2. 숫자 데이터를 문자 데이터로 변환
--    예: TO_CHAR( 123456, '999,999' )  한 자리에 9까지밖에 못 들어가므로 9로 포맷팅
-- ------------------------------------------------------

-- 1) 숫자 출력형식
SELECT
    to_char(1234, '99999')    AS "99999",    -- 9: 한 자리의 숫자 표현
    to_char(1234, '099999')   AS "099999",   -- 0: 앞부분을 0으로 표현
    to_char(1234, '$99999')   AS "$99999",   -- $: 달러 기호를 앞에 표현
    to_char(1234, '99999.99') AS "99999.99", -- .: 소수점을 표시
    to_char(1234, '99,999')   AS "99,999",   -- ,: 특정 위치에 , 표시
    to_char(1234, 'B9999.99') AS "B9999.99", -- B: 앞부분을 공백으로 표현
    to_char(1234, 'B99999')   AS "B99999",   -- B: 앞부분을 공백으로 표현
    to_char(1234, 'L99999')   AS "L99999"    -- L: 지역 통화(Local currency)
FROM
    dual;


-- 2) 화폐 출력형식
SELECT
    last_name,
    salary,
    to_char(salary, '$999,999') AS 달러,
    length(to_char(salary, '$999,999')) AS 길이,
    length('$') AS "달러길이",
    length(',') AS "쉼표길이",
    to_char(salary, 'L999,999') AS 원화   
FROM
    employees;
-- 왜 8 길이가 아니라 9길이가 나올까?

-- ------------------------------------------------------
-- (4) 변환 (처리)함수 - TO_NUMBER
-- ------------------------------------------------------
-- 문자 데이터를 숫자 데이터로 변환
-- ------------------------------------------------------

SELECT
    to_number('123') + 100,         -- 강제형변환 (Casting)   : *Recommended*
    '456' + 100,                    -- 자동형변환 (Promotion) :  Decommended (숫자에 맞춤) => 숫자
    to_char(123) || '456',          -- 강제형변환 (Casting)   : *Recommended*
    123 || '456',                   -- 자동형변환 (Promotion) :  Decommended
    123 + '100'                     -- 자동형변환 (Promotion) :  Decommended
FROM
    dual;


-- ------------------------------------------------------
-- (4) 변환 (처리)함수 - TO_DATE
-- ------------------------------------------------------
-- '날짜형태'의 문자 데이터를 날짜 데이터로 변환
-- ------------------------------------------------------

-- 1) To change Oracle's default date format
--    * Oracle SQL*Developer 에서도 수행해볼 것!
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';


ALTER SESSION SET NLS_DATE_FORMAT='YYYY/MM/DD HH24:MI:SS';


SELECT
    sysdate
FROM
    dual;


-- 2) to_date 응용
SELECT
    to_date('20170802181030', 'YYYYMMDDHH24MISS')   -- 문자열이 어떤 날짜 형식으로 구성됐는지 포맷기호로 알려줘야 date 함수로 바꿀 수 있음.
FROM
    dual;


SELECT
    current_date,
    current_date - to_date('20170101', 'YYYYMMDD') AS 일수
FROM
    dual;