-- sample9.sql


-- ------------------------------------------------------
-- 2. 테이블 삭제
-- ------------------------------------------------------
-- 가. 삭제되는 테이블에 저장된 모든 데이터/관련 인덱스/자식테이블의 외래키
--     제약조건을 제외한, 모든 제약조건이 같이 삭제된다.
-- 나. 자식테이블의 외래키 제약조건은 자동으로 삭제되지 않기 때문에, 자식 테이블
--     에서 부모테이블을 참조하는 상황에서, 부모 테이블을 삭제하면,
--     종속성에 의해서, 삭제가 안됨.
--
--     이 경우에 CASCADE CONSTRAINTS 옵션을 지정하여 삭제하면,
--     연쇄적으로 자식테이블의 외래키 제약조건도 함께 삭제되기 때문에, 부모 테이블 삭제가능
--     자식 테이블 자체가 삭제되는 게 아니라 외래키 제약 조건이 삭제되는 것. (FK 컬럼이 단순컬럼으로 돌아감.)
-- ------------------------------------------------------
-- Basic Syntax:
--
--  DROP TABLE 테이블명 [CASCADE CONSTRAINTS];
-- ------------------------------------------------------

-- 참조키에 의한 테이블 삭제불가.
-- 자식 테이블이 참조하는 상황에서, 부모 테이블 삭제시도

-- ORA-02449: unique/primary keys in table referenced by foreign keys
DROP TABLE dept02;  -- 부모테이블 삭제불가

-- ------------------------------------------------------

-- 자식 테이블에 설정된, 외래키 제약조건까지 연쇄적으로 삭제하기 위해,
-- CASCADE CONSTRAINTS 옵션 추가.

DROP TABLE dept02 CASCADE CONSTRAINTS;


-- 자식 테이블의 외래키 제약조건 삭제 확인
-- USER_CONSTRAINTS 데이터 사전
DESC user_constraints;


SELECT
    table_name,
    constraint_type,
    constraint_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name IN ('DEPT02', 'EMP02', 'EMP03');


-- Oracle 은 기존 제약조건을 수정하려면 => (1) 삭제 (2) 추가 하는 방식으로 함

-- 제약조건 추가
ALTER TABLE emp02 ADD CONSTRAINT emp02_deptno_fk FOREIGN KEY (deptno) REFERENCES dept02(deptno);

-- 기존 제약조건을 이름으로 지정하여 삭제
ALTER TABLE emp02 DROP CONSTRAINT emp02_deptno_fk;
-- 기존 제약조건을 이름으로 수정
ALTER TABLE emp02 ADD CONSTRAINT emp02_deptno_fk FOREIGN KEY (deptno) REFERENCES dept02(deptno)
ON DELETE SET NULL;

DROP TABLE emp02;