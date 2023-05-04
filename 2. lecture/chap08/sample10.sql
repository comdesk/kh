-- sample10.sql


-- ------------------------------------------------------
-- 3. Flashback Drop    윈도우의 휴지통 같은 개념
-- ------------------------------------------------------
-- 가. 삭제된 테이블을 복구하는 방법 (from Oracle10g)
-- 나. 테이블 삭제할 때, (DROP TABLE tablename;)
--     삭제된 테이블은 휴지통(RECYCLEBIN)이라는 특별한 객체에,
--     'BIN$' prefix가 붙은, 이름으로 저장됨.
-- 다. 삭제된 테이블을 다시 복구하고 싶을 때, Flashback Drop
--     복구기술을 이용하여, 휴지통(RECYCKEBIN) 객체에서, 삭제된
--     테이블을 복구할 수 있다.
-- ------------------------------------------------------

-- ------------------------------------------------------
-- * Flashback Drop Commands *
-- ------------------------------------------------------
SHOW RECYCLEBIN;               -- RECYCLEBIN 객체정보 조회


FLASHBACK TABLE[INDEX] tablename TO BEFORE DROP;   -- 삭제된 테이블[인덱스] 복구
FLASHBACK TABLE EMP03 TO BEFORE DROP;

DESC emp03;
SELECT * FROM emp03;
DROP TABLE emp03;

DROP TABLE tablename PURGE;                 -- 테이블 완전삭제(복구불가)
DROP TABLE emp03 PURGE;

PURGE RECYCLEBIN;                           -- RECYCLEBIN 객체정보 삭제(휴지통 비우기)
-- ------------------------------------------------------


SELECT * FROM tab;


-- 1. RECYCLEBIN 객체정보 조회
SHOW RECYCLEBIN;                -- Only Oracle SQL*Developer


-- 2. 삭제된 테이블 복구
FLASHBACK TABLE dept02 TO BEFORE DROP;


SELECT * FROM tab;


-- 3. 테이블 완전삭제(복구불가)
DROP TABLE dept02 PURGE;


-- 4. RECYCLEBIN 객체정보 삭제 (휴지통 비우기)
PURGE RECYCLEBIN;

-- 실험: 부모/자식 관계의 참조 무결성 관계에서,
--       자식 테이블 삭제 후, 다시 Flashback Drop 기능으로 되살렸을 때,
--       복구된 자식테이블의 제약 조건도 그대로 다시 복구되는가?
DROP TABLE emp02;       -- (1) 자식 테이블 삭제

FLASHBACK TABLE emp02 TO BEFORE DROP;   -- (2) 휴지통에서 삭제된 자식 테이블 복구

-- (3) 복구된 자식테이블의 모든 제약조건이 원상태로 복구되는지 확인
DESC USER_CONSTRAINTS;

SELECT
    table_name,
    constraint_type,
    constraint_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name IN ('dept02', 'emp02');
