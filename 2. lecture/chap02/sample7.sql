-- sample7.sql


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


-- ------------------------------------------------------
--        *** SELECT 문의 기본문법 구조 ***
-- ------------------------------------------------------
-- SELECT [DISTINCT] { *, column [AS] [alias], ... }
-- FROM <테이블명>
-- WHERE <predicates>
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 1. LIKE Operators (패턴매칭연산자)
-- ------------------------------------------------------
-- WHERE column LIKE <패턴>
-- ------------------------------------------------------
-- <패턴>에 사용가능한 Wildcard 문자들:
--  (1) %       ( x >= 0,     x: 문자개수 ) 아무런 문자가 나오지 않아도 매칭
--  (2) _       ( x == 1,     x: 문자개수 ) x는 사실 반복수(어떤 문자가 몇 번 반복돼도 상관x)
-- ------------------------------------------------------
SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE 'J%';        -- % : x >= 0 (x: 문자개수)
-- J문자 다음에 아무런 문자가 나오지 않아도 매칭. 수백 개 나와도 모두 매칭.
-- (All or nothing) => 사원의 이름이 대문자 J로만 시작한다면 OK

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%ai%';      -- % : x >= 0 (x: 문자개수)
-- 문자열에서 어느 위치건 ai가 붙어있기만 하면 됨.

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%in';       -- % : x >= 0 (x: 문자개수)


-- ------------------------------------------------------

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '_b%';       -- % : x >= 0, _ : x == 1 (x: 문자개수)
-- 두 번째 문자가 b인 이름.


-- ------------------------------------------------------


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '_____d';    -- _ : x == 1 (x: 문자개수)
-- 6번째 문자가 d이면서, d로 끝나는 이름

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%d';        -- % : x >= 0 (x: 문자개수)

-- ------------------------------------------------------


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%_%'; -- Any name

    --  '%_%' '_'  '%%' '%';  -- % : x >= 0, _ : x == 1 (x: 문자개수)


SELECT
    employee_id,
    last_name,
    salary,
    job_id
FROM
    employees
WHERE
    -- 탈출문자(Escape Character):
    -- 오른쪽에 있는 특수한 의미를 가지는 기호의 기능을 없애는 문자(그냥 문자로서, 데이터로서 바꿔버림.)
    -- 를 "탈출문자"라고 함.
    job_id LIKE '%$_%' ESCAPE '$';      -- % : x >= 0, _ : x == 1 (x: 문자개수)
    -- 직무가 중간에 '_'를 가지고 있는 직원

SELECT
    employee_id,
    last_name,
    salary,
    job_id
FROM
    employees
WHERE
    job_id LIKE '%E___' ESCAPE 'E';     -- % : x >= 0, _ : x == 1 (x: 문자개수)
-- %_2글자
