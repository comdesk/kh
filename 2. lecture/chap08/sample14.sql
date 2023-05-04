-- sample14.sql


-- ------------------------------------------------------
-- 7. 제약조건 활성화/비활성화
-- ------------------------------------------------------
--  가. 기존 테이블의 제약조건을 필요에 의해 Enable/Disable 가능
--  나. 제약조건은 데이터의 무결성은 보장받을 수 있으나,
--      성능은 떨어뜨림
--  다. 예: 데이터의 무결성이 보장되는 방대한 데이터를, 테이블에
--          저장시 사용 
-- ------------------------------------------------------
-- Basic Syntax:
--
--  ALTER TABLE 테이블명
--  DISABLE | ENABLE CONSTRAINT 제약조건명 [CASCADE];
--
--  * ENABLE: 제약조건 활성화
--  * DISABLE: 제약조건 비활성화 (종속된 제약조건 있을 때 비활성화 안 됨.)
--  * CASCADE: 해당 제약조건과 관련된 모든 제약조건을 연쇄적으로 비활성화
-- ------------------------------------------------------

-- PK 제약조건 비활성화
-- ALTER TABLE emp05
-- DISABLE CONSTRAINT emp05_empno_pk;

ALTER TABLE dept
-- DISABLE CONSTRAINT pk_dept;  -- XX
DISABLE CONSTRAINT pk_dept CASCADE;


-- 데이터사전: PK 제약조건 비활성화 확인
SELECT
    table_name,
    constraint_type,
    constraint_name,
    status
FROM
    user_constraints
WHERE
    -- table_name IN ('EMP05');
    table_name IN ('DEPT', 'EMP');

-- ------------------------------------------------------

-- PK 제약조건 활성화
-- ALTER TABLE emp05
-- ENABLE CONSTRAINT emp05_empno_pk;

-- 실험결론: 비활성화된 제약조건의 활성화는 CASCADE 옵션을 사용할 수 없고, 각자 활성화시킴.
ALTER TABLE dept
-- ENABLE CONSTRAINT pk_dept;   -- OK: BUT 부모 PK만 활성화됨.
-- ENABLE CONSTRAINT pk_dept CASCADE;   -- XX: ENABLE에는 CASCADE 못 붙임.

ALTER TABLE EMP
ENABLE CONSTRAINT FK_DEPTNO;


-- 데이터사전: PK 제약조건 비활성화 확인
SELECT
    table_name,
    constraint_type,
    constraint_name,
    status
FROM
    -- user_constraints     -- OK
    -- ALL_CONSTRAINTS      -- OK
    DBA_CONSTRAINTS         -- XX
WHERE
    table_name IN ('EMP05');

