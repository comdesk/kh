-- sample1.sql


-- ------------------------------------------------------
-- 1. To change the password of the specified user
-- ------------------------------------------------------
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호>;
-- ------------------------------------------------------
ALTER USER hr IDENTIFIED BY hr;
ALTER USER hr IDENTIFIED BY oracle12345678;


-- ------------------------------------------------------
-- 2. To lock the specified user
-- ------------------------------------------------------
-- ALTER USER <사용자명> ACCOUNT LOCK;
-- ------------------------------------------------------

-- HR 계정 본인이 자신에게 LOCK을 걸 수는 없다.
-- 일반적으로 SYS 계정이나 Cloud에서는 Admin 계정이 수행할 수 있다.
ALTER USER hr ACCOUNT LOCK;

DESC dba_users;

SELECT username, account_status FROM dba_users;


-- ------------------------------------------------------
-- 3. To unlock the specified user
-- ------------------------------------------------------
-- ALTER USER <사용자명> ACCOUNT UNLOCK;
-- ------------------------------------------------------
ALTER USER hr ACCOUNT UNLOCK;

-- Oracle SQL*Plus의 명령어로, 뒤에 지정되는 테이블의 명세를 출력
DESC dba_users;
DESCRIBE dba_users;

SELECT username, account_status FROM dba_users;
SELECt username, account_status FROM dba_users;


-- ------------------------------------------------------
-- 4. To change the password and [un]lock 
--    of the specified user 
-- ------------------------------------------------------
-- 두 개의 순서가 바뀌어도 된다.
-- ALTER USER <사용자명> ACCOUNT LOCK   IDENTIFIED BY <비밀번호>;
-- ALTER USER <사용자명> ACCOUNT UNLOCK IDENTIFIED BY <비밀번호>;
--
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호> ACCOUNT LOCK ;
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호> ACCOUNT UNLOCK ;
-- ------------------------------------------------------
ALTER USER hr ACCOUNT LOCK IDENTIFIED BY oracle;
ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY oracle;

ALTER USER hr IDENTIFIED BY oracle ACCOUNT LOCK;
ALTER USER hr IDENTIFIED BY oracle ACCOUNT UNLOCK;

DESC dba_users;

SELECT username, password, account_status FROM dba_users;