-- Q1
select max(salary) as '최고임금', min(salary) as '최저임금', max(salary)-min(salary) as '최고임금 - 최저임금'
from salaries;

-- Q2
select date_format(max(hire_date),'%Y년 %m월 %d일') as 날짜
from employees;

-- Q3
select date_format(min(hire_date),'%Y년 %m월 %d일') as 날짜
from employees;

-- Q4
select avg(salary) as 평균연봉
from salaries;

-- Q5
select max(salary) as 최고연봉, min(salary) as 최저연봉
from salaries;

-- Q6
select date_format(now(),'%Y')-max(date_format(birth_date,'%Y')) as 최연소,
	date_format(now(),'%Y')-min(date_format(birth_date,'%Y')) as 최연장
from employees