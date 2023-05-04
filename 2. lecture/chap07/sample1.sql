-- sample1.sql


-- ------------------------------------------------------
-- 1. INSERT 문
-- ------------------------------------------------------
--  가. 테이블에 데이터를 저장하기 위한 문장.
--  나. 구분:
--      (1) 단일 행 INSERT문: 한 번에 하나의 행을 테이블에 저장
--      (2) 다중 행 INSERT문: 한 번에 여러 행을 테이블에 저장
--  다. 테이블에 새로운 레코드(행)이 삽입 됨.
--  라. INTO 절에 명시한 컬럼은, VALUES 절에서 지정한 컬럼값과
--      일대일 대응되도록, 순서대로 입력해야 함.
--      So, INTO 절에 명시된 컬럼과 VALUES 절에 명시된 값의 
--      개수와 타입은 같아야 함.
--  마. INTO 절의 컬럼목록은 생략가능.
--      if 생략하면, 테이블 생성시 정의한 컬럼순서와 동일한 순서로
---     모든 컬럼값을 VALUES 절에 지정해야 한다.
--  바. 저장되는 데이터의 타입은, 컬럼의 데이터 타입과 일치해야 함
--  사. 저장되는 데이터의 크기는, 컬럼의 크기보다 같거나 작아야 함
--  아. 기본키(PK)(컬럼, unique+not null) 또는 UNIQUE컬럼은, 동일한 값을 저장할 수 없음.
--  자. INTO 절에서 생략된 컬럼은, 자동으로 널(NULL) 값이 저장됨.
--      따라서, NOT NULL 제약조건이 아닌 컬럼만 INTO절에서 생략가능.
--      (NOT NULL 컬럼은 NULL 값 허용 안 하는 컬럼)
-- ------------------------------------------------------
-- Basic Syntax) 단일 행 INSERT문
--
--  INSERT INTO 테이블명 [ (컬럼명1, 컬럼명2, ...) ] ->   컬럼 목록이 선택(생략되면 테이블이 현재 가지고 있는 스키마대로 값 준비)
--  VALUES ( 값1, 값2, ... ); ->  컬럼의 개수, 순서, 타입에 맞게 (일대일 대응)
-- ------------------------------------------------------
-- * Please refer to the chapter 07, page 07.
-- ------------------------------------------------------

DELETE FROM dept
WHERE
    deptno IN (50, 60, 70, 80);
COMMIT;

SELECT 
    *
FROM
    dept;

-- ------------------------------------------------------
-- 0. 자동커밋(Auto-Commit)이란? 
-- ------------------------------------------------------
-- 커밋(COMMIT)  : DML 문장에 의한 DB의 변경 내역을 영구적으로 DB 파일에 저장하는 기능 (저장시켜야 반영됨)
-- 롤백(ROLLBACK): DML 문에 의한 변경하기 이전 상태로 회귀시킴
-- DML 1개 문장이 실행 완료될 때마다, 자동으로 COMMIT문을 수행시키는 기능

SHOW AUTOCOMMIT;    -- 현재 DB연결 세션에서 자동커밋 설정을 보여줌.
SET AUTOCOMMIT ON;  -- 현재 DB연결 세션에 대해서, 자동커밋을 ON 시킴
SET AUTOCOMMIT OFF; -- 현재 DB연결 세션에 대해서, 자동커밋을 OFF 시킴

-- ------------------------------------------------------
-- 1-1. 단일 행 INSERT 문
-- ------------------------------------------------------

BEGIN       -- To begin a transaction

    -- 1. 컬럼목록을 명시한 INSERT 문
    INSERT INTO dept (deptno, dname, loc)
    VALUES (50, '개발', '서울');


    -- 2. 컬럼목록을 생략한 INSERT 문
    INSERT INTO dept
    VALUES (60, '인사', '경기');


    -- 3. 특정 컬럼에 묵시적으로 널(null, 결측치) 값 저장
    --  1) 묵시적 방법(Implicitly) -> 컬럼 목록을 생략하면 NULL 값이 들어감
    INSERT INTO dept (deptno, dname)    -- loc 지정x
    VALUES (70, '인사');


    -- 4. 특정 컬럼에 명시적으로 널(null, 결측치) 값 저장:
    --  2) 명시적 방법(Explicitly)
    INSERT INTO dept (deptno, dname, loc)
    VALUES (80, '인사', NULL);


    -- 5. TCL: COMMIT 또는 ROLLBACK 문으로 구성됨;
    COMMIT;         -- 영구적으로 위의 INSERT 문에 의한 변경을 저장 (***)
    -- ROLLBACK;    -- 위의 INSERT 문에 의한 변경이 발생하기 이전 상태로 회귀시킴 (***)

END;        -- To end a transaction




-- ------------------------------------------------------
-- **(주의)** INSERT 문장 수행 시, 오류 발생 예 
-- ------------------------------------------------------

-- 1) INTO 절에 명시된 컬럼의 갯수와 VALUES 절에 명시된 값의 개수가 틀린 경우
INSERT INTO dept (deptno, dname, loc)
VALUES (11, '인사');    -- ORA-00947: not enough values


-- 2) INTO 절에서 컬럼목록을 생략한 경우: VALUES절에서 테이블의 모든 컬럼값을 누락하지 말아야 함.
INSERT INTO dept
VALUES (12, '인사');    -- ORA-00947: not enough values


-- 3) INTO 절의 컬럼 데이터 타입과 VALUES 절의 값의 데이터 타입이
--    일치하지 않는 경우
DESC dept;


INSERT INTO dept (deptno, dname, loc)
VALUES ('개발', 13, '인사');    -- ORA-01722: invalid number


-- 4) VALUES 절의 컬럼값 지정시, 반드시 리터럴 형식에 맞게 설정해야 함;
--
-- ------------------------------------------------------
--   * 리터럴(Literal) 규칙:
-- ------------------------------------------------------
--      a. 문자와 날짜 리터럴: 반드시, '' 로 묶어야 함.
--         만일, ''를 누락하면, 리터럴(값)이 아닌, 식별자로 인식
--      b. 수치 리터럴: '' 없이 사용해야 함.
-- ------------------------------------------------------
INSERT INTO dept (deptno, dname, loc)
VALUES ('개발', 14, 인사);  --  ORA-00984: column not allowed here (인사를 컬럼명으로 인식(컬럼명은 따옴표 안에 안쓰므로))


-- ------------------------------------------------------
-- 1-2. 복수 행 INSERT 문
-- ------------------------------------------------------
-- 가. 하나의 INSERT 문장으로, 한번에 여러 행(0개 이상) 저장
-- 나. VALUES 절 대신에, 서브쿼리(= 부속질의) 사용  => 서브쿼리의 결과셋이 들어가는 것.
-- 다. 서브쿼리를 사용하여, 기존 테이블의 데이터를 복사한 후에,
--     INSERT 문으로 새로운 행 생성.
-- 라. (*주의할 점*) 
--     INTO 절에서 지정한 컬럼의 개수와 타입에 맞추어,
--     서브쿼리의 수행결과가 반드시 동일해야 함.
-- ------------------------------------------------------
-- Basic Syntax)  INSERT SELECT문
--
-- INSERT INTO 테이블명 [ (컬럼명1, 컬럼명2, ..., 컬럼n) ]
-- Subquery;
--
-- ------------------------------------------------------
-- Please refer to the chap07, page17.
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (1) 기존 테이블을 이용하여, 새로운 테이블 생성 (CTAS)
-- ------------------------------------------------------
-- * CTAS: 기존 테이블 스키마 복사 시, NOT NULL 제약조건만 복사되고, 
--         그 외 제약조건(NULL, PK, FK, UNIQUE)은 복사되지 않음.
-- ------------------------------------------------------
-- Basic Syntax) 
--
--  CREATE TABLE 테이블명 [(컬럼명,컬럼명2, ...)]
--  AS
--  Subquery;
-- ------------------------------------------------------
DROP TABLE mydept;  -- DDL (Data Definition Language): 테이블 삭제

-- CTAS 기법을 이용하여, 새로운 테이블 생성
CREATE TABLE mydept
AS
SELECT * FROM dept
WHERE 1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외), TRUE가 불가능한 조건식을 지정해서 행은 선택하지 않고, 열만 복사하는 것.


DESC mydept;
SELECT * FROM mydept;

-- ------------------------------------------------------
-- (2) 복수 행 INSERT 문 수행 -> CTAS 아님. 새로운 테이블 생성이 아닌, 생성된 테이블에 데이터 insert 하는 것. INSERT SELECT문임.
-- ------------------------------------------------------
INSERT INTO mydept
SELECT
    deptno,
    dname,
    loc
FROM
    dept;


SELECT
    *
FROM
    mydept;


-- ------------------------------------------------------
-- 1-3. 다중 테이블, 복수 행 INSERT 문 (= INSERT ALL 문)
-- ------------------------------------------------------
--  가. 하나의 INSERT 문장으로, 한번에 한 개 이상의 테이블에,
--      여러 개의 행을 저장하는 문장.
--  나. INSERT ALL 문장이라고 부름.
--  다. 서브쿼리의 실행결과가 INTO절에 지정한 테이블(1..N)에
--      자동으로 INSERT 됨.
--  라. ** WHEN 절은 생략가능 ** (= 무조건 INSERT ALL 문)
--  마. WHEN절이 있는 경우, 조건식이 참일 때에만, 지정된 테이블에
--      서브쿼리의 결과가 INSERT 됨.
--      (이땐, "조건 INSERT ALL 문" 이라고 부름)
--  바. (**주의사항**) VALUES 절에 사용된 컬럼명과 Subquery에서
--      사용된 컬럼명이 반드시 동일해야 함.
--  사. 구분:
--      (1) 무조건(조건x) INSERT ALL문 : WHEN 절이 생략된 경우.
--      (2) 조건 INSERT ALL문   : 
--          WHEN 절의 조건식의 참일 경우에만, INSERT 수행.
--          여러 WHEN 절이 중복되어 참인 경우에는,
--          각 테이블에 모두 해당 행이 INSERT 됨. 
--      (3) 조건 INSERT FIRST문 :
--          WHEN 절에 지정된 조건이 중복되어 참인 경우에, 
--          처음조건에 일치하는 테이블에만 해당 행이 저장되고,
--          이후 조건이 일치해도, 해당 테이블에 저장하지 않는 문장.
-- ------------------------------------------------------
-- Basic Syntax)
--
-- INSERT ALL
--  [WHEN 조건식1 THEN]
--  INTO 테이블1 VALUES (컬럼명1, 컬럼명2, ..., 컬럼명n)
--  [WHEN 조건식2 THEN]
--  INTO 테이블2 VALUES (컬럼명1, 컬럼명2, ..., 컬럼명n)
--  ..
--  [WHEN 조건식n THEN]
--  INTO 테이블n VALUES (컬럼명1, 컬럼명2, ..., 컬럼명n)
-- Subquery;
--
-- ------------------------------------------------------
-- Please refer to the chap07, page21.
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 1-3-1. 무조건 INSERT ALL 문
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (1) 기존 테이블을 이용하여, 새로운 테이블 생성 (CTAS)
-- ------------------------------------------------------
-- * CTAS: 기존 테이블 스키마 복사 시, NOT NULL 제약조건을 제외
--         한, 그 외 제약조건은 복사되지 않음.
-- ------------------------------------------------------
-- Basic Syntax) 
--
--  CREATE TABLE 테이블명 [(컬럼명,컬럼명2)]
--  AS
--  Subquery;
-- ------------------------------------------------------
DROP TABLE myemp_hire;


CREATE TABLE myemp_hire AS    -- 1st. Table creation.
SELECT
    empno,
    ename,
    hiredate,
    sal
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_hire;    -- empno가 NOT NULL인데도 제약조건이 복제되지 않는 이유는 PK라서임.
DESC USER_CONSTRAINTS;      -- 제약조건 확인할 수 있는 테이블
DESC USER_CONS_COLUMNS;

-- ------------------------------------------------------

DROP TABLE myemp_mgr;


CREATE TABLE myemp_mgr AS      -- 2nd. Table creation.
SELECT
    empno,
    ename,
    mgr
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_mgr;


-- ------------------------------------------------------
-- (2) 무조건 INSERT ALL 문장 수행
-- ------------------------------------------------------
-- (**주의사항**) VALUES 절에 사용된 컬럼명과 Subquery에서
--      사용된 컬럼명이 반드시 동일해야 함.
-- 컬럼의 개수는 동일하지 않아도 됨.
-- ------------------------------------------------------
INSERT ALL
    INTO myemp_hire VALUES (empno, ename, hiredate, sal)
    INTO myemp_mgr  VALUES (empno, ename, mgr)

    SELECT
        empno,
        ename,
        hiredate,
        sal,
        mgr
    FROM
        emp;

-- ------------------------------------------------------

SELECT
    *
FROM
    myemp_hire;


SELECT
    *
FROM
    myemp_mgr;


-- ------------------------------------------------------
-- 1-3-2. 조건 INSERT ALL 문
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (1) 기존 테이블을 이용하여, 새로운 테이블 생성 (CTAS)
-- ------------------------------------------------------
-- * CTAS: 기존 테이블 스키마 복사 시, NOT NULL 제약조건을 제외
--         한, 그 외 제약조건은 복사되지 않음.
-- ------------------------------------------------------
-- Basic Syntax) 
--
--  CREATE TABLE 테이블명 [(컬럼명,컬럼명2)]
--  AS
--  Subquery;
-- ------------------------------------------------------
DROP TABLE myemp_hire2;


CREATE TABLE myemp_hire2 AS   -- 1st. Table creation.
SELECT
    empno,
    ename,
    hiredate,
    sal
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_hire2;

-- ------------------------------------------------------

DROP TABLE myemp_mgr2;


CREATE TABLE myemp_mgr2 AS    -- 2nd. Table creation.
SELECT
    empno,
    ename,
    mgr
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_mgr2;


-- ------------------------------------------------------
-- (2) 조건 INSERT ALL 문장 수행
-- ------------------------------------------------------
-- (**주의사항**) VALUES 절에 사용된 컬럼명과 Subquery에서
--      사용된 컬럼명이 반드시 동일해야 함.
-- ------------------------------------------------------
DELETE myemp_hire2;
DELETE myemp_mgr2;

INSERT ALL
    WHEN sal > 500 THEN
        INTO myemp_hire2  VALUES (empno, ename, hiredate, sal)

    WHEN sal > 1000 THEN
        INTO myemp_mgr2   VALUES (empno,ename,mgr)

    -- WHEN mgr = 7698 THEN
    --     INTO myemp_mgr2   VALUES (empno,ename,mgr)

    SELECT
        empno,
        ename,
        hiredate,
        sal,
        mgr
    FROM
        emp;

-- ------------------------------------------------------

SELECT
    *
FROM
    myemp_hire2;


SELECT
    *
FROM
    myemp_mgr2;


-- ------------------------------------------------------
-- 1-3-3. 조건 INSERT FIRST 문
-- ------------------------------------------------------

-- ------------------------------------------------------
-- (1) 기존 테이블을 이용하여, 새로운 테이블 생성 (CTAS)
-- ------------------------------------------------------
-- * CTAS: 기존 테이블 스키마 복사 시, NOT NULL 제약조건을 제외
--         한, 그 외 제약조건은 복사되지 않음.
-- ------------------------------------------------------
-- Basic Syntax) 
--
--  CREATE TABLE 테이블명 [(컬럼명,컬럼명2)]
--  AS
--  Subquery;
-- ------------------------------------------------------
DROP TABLE myemp_hire3;


CREATE TABLE myemp_hire3 AS    -- 1st. Table creation.
SELECT
    empno,
    ename,
    hiredate,
    sal
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_hire3;

-- ------------------------------------------------------

DROP TABLE myemp_mgr3;


CREATE TABLE myemp_mgr3 AS     -- 2nd. Table creation.
SELECT
    empno,
    ename,
    mgr
FROM
    emp
WHERE
    1 = 2;        -- 기존 테이블의 스키마만 복사(데이터 제외)


DESC myemp_mgr3;


-- ------------------------------------------------------
-- (2) 조건 INSERT *FIRST* 문장 수행
-- ------------------------------------------------------
-- (**주의사항**) VALUES 절에 사용된 컬럼명과 Subquery에서
--      사용된 컬럼명이 반드시 동일해야 함.
-- ------------------------------------------------------
INSERT FIRST
    -- sal = 800 인 사원은, 아래 두 WHEN 절의 조건식을 모두 만족.
    -- 이때, 첫번째 WHEN절에서만 INSERT가 수행되고,
    --      두번째 WHEN절은 설령 조건이 참이어도, INSERT 수행되지 않음.
    WHEN sal = 800 THEN     -- 1st. condition
        INTO myemp_hire3 VALUES (empno, ename, hiredate, sal)

    WHEN sal < 2500 THEN    -- 2nd. condition
        INTO myemp_mgr3  VALUES (empno, ename, mgr)

    SELECT
        empno,
        ename,
        hiredate,
        sal,
        mgr
    FROM
        emp;

-- ------------------------------------------------------

SELECT
    *
FROM
    myemp_hire3;


SELECT
    *
FROM
    myemp_mgr3;

INSERT INTO myemp_hire3 (empno)
VALUES (NULL);
DESC emp;
