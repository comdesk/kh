-- sample15.sql


-- ------------------------------------------------------
-- 8. 데이터 사전(Data Dictionary View) 3종류 (누구에게 제공하느냐가 다름.)
-- ------------------------------------------------------
-- (1) DBA_XXXX : 데이터베이스 관리자(SYS 계정)만 접근가능한 객체 등의 정보조회
-- (2) ALL_XXXX : 자신계정 소유 또는 권한을 부여받은 다른 계정의 객체 등에 관한 정보조회
-- (3) USER_XXXX: 자신의 계정이 소유한 객체 등에 관한 정보조회
-- ------------------------------------------------------

-- ------------------------------------------------------
-- * 데이터 사전(Data Dictionary View)에 저장되는 정보 *
-- ------------------------------------------------------
--  가. DB의 물리적 구조 또는 객체의 논리적 구조
--  나. Oracle 사용자와 스키마 객체명
--  다. 각 사용자에게 부여된 권한과 롤(role)
--  라. 무결성 제약조건
--  마. 컬럼 기본값
--  바. 스키마 객체에 할당된 영역의 크기와
--      현재 사용중인 영역의 크기
--  사. DB 이름/버전/생성날짜/시작모드/인스턴스명 같은 일반정보
-- ------------------------------------------------------



