-- 
select now(), sysdate() from dual;

-- now()는 쿼리가 실행되는 시간, sysdate()는 이 명령어가 호출 된 시간 그래서 다름
select now(), sleep(2), sysdate() from dual;

-- date_format