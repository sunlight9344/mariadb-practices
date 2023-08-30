-- 
select now(), sysdate() from dual;

-- now()는 쿼리가 실행되는 시간, sysdate()는 이 명령어가 호출 된 시간 그래서 다름
select now(), sleep(2), sysdate() from dual;

-- date_format
-- 2023년 8월 30일 11시 37분 57초
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초') as 지금 from dual;
select date_format(now(), Y년) as 지금 from dual;

-- period_diff (difference)
-- formatting: yymm, YYYYmm
-- 예) 근무 개월(2023년 기준)
select first_name,
	hire_date,
    period_diff(date_format(curdate(),'%y%m'),date_format(hire_date,'%y%m')) as month
from employees;

-- date_add(adddate), date_sub(=subdate)

select first_name,
	hire_date,
	date_add(hire_date, interval 5 year) as 휴가날짜
from employees;

select '12345' + 10, cast('12345' as int) + 10 from dual;
select date_format(cast('2023-08-30' as date),'%Y년 %m월 %d일') from dual;
select cast(1-2 as unsigned) from dual;
select cast(cast(1-2 as unsigned) as signed) from dual;