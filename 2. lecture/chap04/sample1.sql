-- sample1.sql


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
-- 2. 그룹 (처리)함수 (집계함수)
-- ------------------------------------------------------
-- 그룹 (처리)함수의 구분:
--
--  (1) SUM     - 해당 열의 총합계를 구한다
--  (2) AVG     - 해당 열의 평균을 구한다
--  (3) MAX     - 해당 열의 총 행중에 최대값을 구한다
--  (3) MIN     - 해당 열의 총 행중에 최소값을 구한다
--  (4) COUNT   - 행의 개수를 카운트한다    **주의
--
--  * 그룹 (처리)함수는, 1) 여러 행 또는 2) 테이블 전체에 대해, 
--    함수가 적용되어, 하나의 결과를 반환!
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (1) 그룹 (처리)함수 - SUM
-- ------------------------------------------------------
-- 해당 열의 총합계를 구한다 (** NULL 값 자동으로 제외하고 **)
-- ------------------------------------------------------
-- 문법) SUM( [ DISTINCT | ALL ] column )
--          DISTINCT : excluding duplicated values.
--          ALL : including duplicated values.
--                (if abbreviated, default)
-- ------------------------------------------------------
SELECT
    sum(DISTINCT salary),   -- 중복값을 제거
    sum(ALL salary),        -- 중복값도 포함
    sum(salary)             -- Ditto(상동). Default: ALL
FROM
    employees;


-- ------------------------------------------------------
-- (2) 그룹 (처리)함수 - AVG (산술평균 = Mean)
-- ------------------------------------------------------
-- 해당 열의 평균을 구한다 (** NULL 값 자동으로 제외하고 **)
-- ------------------------------------------------------
-- 문법) AVG( [ DISTINCT | ALL ] column )
--          DISTINCT : excluding duplicated values.
--          ALL : including duplicated values.
--                (if abbreviated, default)
-- ------------------------------------------------------
SELECT
    sum(salary),            -- 총 월 급여액
    -- 월 평균 급여액을 구하자
    avg(DISTINCT salary),   -- 중복 급여 제거
    avg(ALL salary),        -- 중복 급여 포함
    avg(salary)             -- Ditto. (ALL)
FROM
    employees;


-- ------------------------------------------------------
-- (3) 그룹 (처리)함수 - (** NULL 값 자동으로 제외하고 **)
--      MAX : 해당 열의 총 행중에 최대값을 구한다
--      MIN : 해당 열의 총 행중에 최소값을 구한다
-- ------------------------------------------------------
-- 문법) MAX( [ DISTINCT | ALL ] column )
--      MIN( [ DISTINCT | ALL ] column )
--          DISTINCT : excluding duplicated values.
--          ALL : including duplicated values.
--                (if abbreviated, default)
-- ------------------------------------------------------
SELECT
    max(salary),
    min(salary),
    max(COMMISSION_PCT) AS MAX_COMM_PCT,
    min(COMMISSION_PCT) AS MIN_COMM_PCT
FROM
    employees;      -- 그룹처리함수가 테이블에 적용


SELECT
    min( hire_date ),   -- 과거
    max( hire_date )    -- 최근
FROM
    employees;


-- ------------------------------------------------------
-- (4) 그룹 (처리)함수 - COUNT
-- ------------------------------------------------------
-- 행의 개수를 카운트한다(* 컬럼명 지정하는 경우, NULL값 자동으로 제외 *)
-- ------------------------------------------------------
-- 문법) COUNT( { [[ DISTINCT | ALL ] column] | * } )
--          DISTINCT : excluding duplicated values.
--          ALL : including duplicated values.
--                (if abbreviated, default)
-- ------------------------------------------------------
SELECT
    count(last_name),       -- 107
    count(commission_pct)   -- 35 (Null값 제외됨)
FROM
    employees;


SELECT
    count(job_id),          -- 전체 직원 수를 카운트
    count(DISTINCT job_id)  -- 고유한 직무의 개수를 카운트
FROM
    employees;


-- 해당 테이블의 전체 레코드 개수 구하기 (*주의필요*)
SELECT
    -- 모든 컬럼으로 카운트하는 순간, 모든 행의 모든 컬럼의 값을 Oracle의
    -- 메모리 영역(SGA)에 로딩하기 때문에, 메모리 부하가 큼.
    -- 때문에, 실전에서는 그룹의 구성행수를 구할 때 이 방법은 절대 사용 안 함.
    count(*),               -- (wildcard(*) = all columns) Decommended
    count(commission_pct),  -- *Causion (removed all NULLs)

    -- 실전에서 가장 권장하는 방법으로 아래 주석대로 2개의 조건을 만족시키는
    -- 컬럼으로 카운트 해야 한다.
    -- (** 어떤 컬럼을 사용해야 할까?
    --     중복이 없고 + 고유하고 + 결측치가 없는 컬럼 **)
    count(employee_id)      -- *Recommended (Primary Key = Unique + Not NULL)
FROM
    employees;
