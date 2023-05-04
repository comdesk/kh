-- sample21.sql


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
--  (5) 조건 (처리)함수 : if 조건문, switch 다중 조건문을 함수형태로 제공
--      a. DECODE 함수  - if 다중 조건문 제공
--      b. CASE 문      - switch 문 제공
--
--  * 단일(행) (반환)함수는, 테이블의 행 단위로 처리됨!
-- ------------------------------------------------------
-- (Chapter03 - page 60 참고)
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (5) 조건 (처리)함수 - DECODE
-- ------------------------------------------------------
-- 조건이 반드시 일치하는 경우에 사용하는 함수
-- 즉, 동등비교연산자(=)가 사용가능한 경우에만 사용가능
-- ------------------------------------------------------
-- 문법) DECODE(
--          column, 
--          비교값1, 결과값1,   -- if
--          비교값2, 결과값2,   -- else if
--          ...
--          비교값n, 결과값n,   -- else if
--          기본결과값          -- else
--      )
-- ------------------------------------------------------
SELECT
    salary,
    decode(                         -- if
        salary,                     --   column
            1000, salary * 0.1,     -- if (salary = 1000):
            2000, salary * 0.2,     -- else if (salary  = 2000):
            3000, salary * 0.3,     -- else if (salary = 3000):
            salary*0.4              -- else:
    ) AS 인센티브
FROM
    employees;


-- 월급여액 별, 보너스 계산하기
SELECT 
    last_name,
    salary,
    decode(
        salary, 
            24000, salary * 0.3, 
            17000, salary * 0.2, 
            salary  -- 보너스가 급여 1개월치
    ) AS 보너스
FROM
    employees
ORDER BY
    salary desc;


-- 입사년도별, 사원들의 인원수 구하기
SELECT
    count(*) AS "총인원수", -- FROM 절의 총 레코드 수 카운트하는 함수
    sum( decode( to_char(hire_date, 'YYYY'), 2001, 1, 0) ) AS "2001",
    sum( decode( to_char(hire_date, 'YYYY'), 2002, 1, 0) ) AS "2002",
    sum( decode( to_char(hire_date, 'YYYY'), 2003, 1, 0) ) AS "2003",
    sum( decode( to_char(hire_date, 'YYYY'), 2004, 1, 0) ) AS "2004",
    sum( decode( to_char(hire_date, 'YYYY'), 2005, 1, 0) ) AS "2005",
    sum( decode( to_char(hire_date, 'YYYY'), 2006, 1, 0) ) AS "2006",
    sum( decode( to_char(hire_date, 'YYYY'), 2007, 1, 0) ) AS "2007",
    sum( decode( to_char(hire_date, 'YYYY'), 2008, 1, 0) ) AS "2008"
FROM
    employees;


-- ------------------------------------------------------
-- (6) 조건 (처리)함수 - CASE
-- ------------------------------------------------------
-- 조건이 반드시 일치하지 않아도,
-- 범위 및 비교가 가능한 경우에 사용하는 함수
-- ------------------------------------------------------
-- 문법1) 조건이 반드시 일치하는 경우 (값을 생성하므로 switch expression과 비슷)
--      CASE column
--          WHEN 비교값1 THEN 결과값1   --case1
--          WHEN 비교값2 THEN 결과값2   --case2
--          ...
--          ELSE 결과값n                --default
--      END
-- ------------------------------------------------------
SELECT
    salary,
    CASE salary
        WHEN 1000 THEN salary * 0.1
        WHEN 2000 THEN salary * 0.2
        WHEN 3000 THEN salary * 0.3
        ELSE salary * 0.4
    END AS 인센티브1,
    decode(
        salary,
        1000, salary * 0.1,
        2000, salary * 0.2,
        3000, salary * 0.3,
        salary * 0.4
    ) AS 인센티브2
FROM
    employees;


-- ------------------------------------------------------
-- 문법2) 조건이 반드시 일치하지 않는 경우
--      CASE 
--          WHEN 조건1 THEN 결과값1
--          WHEN 조건2 THEN 결과값2
--          ...
--          ELSE 결과값n
--      END
-- ------------------------------------------------------
SELECT min(salary), max(salary)
FROM employees;


SELECT
    salary,
    -- CASE 
    --     WHEN salary > 1000 THEN salary * 0.1    -- 이 조건식에 모든 사원의 급여가 걸려서 밑의 조건을 판단 못한다.
    --     WHEN salary > 2000 THEN salary * 0.2
    --     WHEN salary > 3000 THEN salary * 0.3
    --     ELSE salary * 0.4
    -- END AS 인센티브
    CASE    -- 자바 switch문과 비슷(범위 못 만듦)
        WHEN (salary > 3000) AND (salary < 6000) THEN salary + 100    
        WHEN salary > 2000 THEN salary + 200
        WHEN salary > 1000 THEN salary + 300
        ELSE salary + 1000
    END AS 인센티브
FROM
    employees;
-- decode문으로 하면 중첩해야 해서 복잡해짐.(decode는 무조건 동등비교만 하므로)


-- CASE 함수 (동등조건)
SELECT
    last_name,
    salary,

    CASE salary
        WHEN 24000 THEN salary * 0.3
        WHEN 17000 THEN salary * 0.2
        ELSE salary --(* 1.0)
    END AS 보너스
FROM
    employees
ORDER BY
    salary desc;


-- CASE 함수 (부등조건)
SELECT
    last_name,
    salary,

    CASE
        WHEN salary >= 20000 THEN 1000
        WHEN salary >= 15000 THEN 2000
        WHEN salary >= 10000 THEN 3000
        ELSE 4000
    END AS 보너스
FROM
    employees
ORDER BY
    2 desc;


SELECT
    last_name,
    salary,

    CASE
        WHEN salary BETWEEN 20000 AND 25000 THEN '상'
        WHEN salary BETWEEN 10000 AND 19999 THEN '중'
        ELSE '하'
    END AS 등급
FROM
    employees
ORDER BY
    salary desc;


SELECT
    last_name,
    salary,

    CASE
        -- WHEN salary IN (24000, 17000 , 14000) THEN '상'
        WHEN salary BETWEEN 14000 AND 24000 THEN '상'   -- full-closed
        WHEN salary IN (13500, 13000) THEN '중'
        ELSE '하'
    END AS 등급
FROM
    employees
ORDER BY
    salary desc;