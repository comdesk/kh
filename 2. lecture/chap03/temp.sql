-- 현재 연결 세션의 날짜와 시간 포맷을 변경하고 싶다
-- 연결 세션마다 바꾸지 않고 전역설정하고 싶으면 glogin.sql파일에 넣으면 된다.

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';     -- Oracle SQL*Developer
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-RR';    -- Visual Source code

ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy/MM/dd - hh24:mi:ss';  
--자바의 심플데이터 포맷과 동일하게 하려고, sql은 MM 대소문자 구분 없지만 MM으로 함.

ALTER SESSION SET NLS_TIMESTAMP_TZ_FORMAT = 'yyyy/MM/dd - hh24:mi:ss';  

SELECT
    sysdate,
    sysdate + 9,            -- 일수를 더함.
    sysdate + 9/24,         -- 24시간으로 나눈 값이, 시간으로 더해짐.
    sysdate + 9/24/60,      -- 24시간/60분으로 나눈 값이, 분으로 더해짐
    sysdate + 9/24/60/60,   -- 24시간/60분/60초로 나눈 값이, 초로 더해짐
    systimestamp,

    current_date,           -- 현재 Timezone(Asia/Seoul)에 맞는 Local Date
    current_timestamp        -- 현재 Timezone(Asia/Seoul)에 맞는 Local Timestmp
FROM
    dual;