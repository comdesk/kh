-- sample1.sql


-- ******************************************************
-- SELECT 문의 기본구조와 각 절의 실행순서
-- ******************************************************
--  - Clauses -                 - 실행순서 -
--
-- SELECT clause                    (5)
-- FROM clause                      (1)
-- WHERE clause                     (2)
-- GROUP BY clause                  (3)
-- HAVING clause                    (4)
-- ORDER BY clause                  (6)
-- ******************************************************
-- SELECT문을 작성할 때 optional한 절도 있고, 필수 절도 있음.
-- SELECT, FROM 절은 필수.

-- ------------------------------------------------------
--        *** SELECT 문의 기본문법 구조 ***
-- ------------------------------------------------------
-- SELECT [DISTINCT] { *, column [AS] [alias], ... }
-- FROM <테이블명>
-- ------------------------------------------------------
-- FROM 절은 테이블에서 레코드를 하나씩 뽑아내서 그 다음 순서 절에 준다.
-- 지금은 SELECT한테 준다.

-- SELECT 절은 뽑아서 준 레코드 중에 어떤 Column을 선택할지 결정
-- *: 모든 Column 선택
-- column: 컬럼 이름 기재
-- [AS][alias]: 컬럼의 별칭을 지어주는 것 (컬럼 이름이 출력결과로서 마음에 안 들 때)
--              alias를 쓸 때는 AS 키워드를 붙여야 함. (AS 빼도 허용)
-- ,...: 여러 컬럼 기재할 때 쉼표 찍고 다음 컬럼 이름 기재

-- ------------------------------------------------------
-- 1. To project all columns of the table
-- ------------------------------------------------------
-- SELECT *
-- FROM table;
-- ------------------------------------------------------
SELECT *
FROM employees;

SELECT *
FROM departments;

-- ------------------------------------------------------
-- 2. To project only the specified columns of the table
-- ------------------------------------------------------
-- SELECT column1[, column2, ..., columnN]
-- FROM table;
-- ------------------------------------------------------
SELECT
    employee_id,    -- 사원 번호
    last_name,      -- 이름
    hire_date,      -- 채용일자
    SALARY          -- 월급여
FROM
    employees;      -- 사원정보

--지정한 컬럼순서대로 결과 돌려줌.
-- ------------------------------------------------------
-- 3. 산술연산자의 활용 ( +, - , *, / )
-- ------------------------------------------------------
-- SELECT column1 + column2 FROM table;
-- SELECT column1 - column2 FROM table;
-- SELECT column1 * column2 FROM table;
-- SELECT column1 / column2 FROM table;
-- ------------------------------------------------------
SELECT
    salary,
    salary + 100
FROM employees;

SELECT
    salary,
    salary - 100
FROM
    employees;

SELECT
    salary,
    salary * 100  -- 곱셈과 와일드 카드의 기호가 같다.
FROM
    employees;

SELECT
    salary,
    salary / 100 AS "크게 감액된 월급여",
    salary / 100 AS "aaaaaa"
FROM
    employees;
-- 별칭은 한글도 가능
-- 그런데 구두점이 들어갈 땐 “”로 문자열구분
-- ""를 사용하면 대소문자 구분 가능

SELECT
    last_name,
    salary,
    salary * 12
FROM
    employees;

-- ------------------------------------------------------
-- 4. About SYS.DUAL table
-- ------------------------------------------------------
-- SYS account owns this DUAL table.
-- If you don't need a table, the DUAL table needed.
-- ------------------------------------------------------
SELECT
    245 * 567 
FROM
    dual;          -- 참고로, MySQL/Mariadb/Postgresql 에서는 생략가능!
                   -- dual: dummy table

DESC sys.dual;  -- owner.<db객체명>: 데이터베이스의 객체의 소유자(계정명)을 기재한다.
DESC dual;      -- 모든 계정이 사용할 수 있으니 그냥 dual도 가능


SELECT
    *
FROM
    dual;

SELECT
    * 
FROM
    sys.dual;