-- 1
select first_name,last_name from employees where emp_no=10944;

-- 2
select
first_name as '이름',
gender as '성별',
hire_date as '입사일'
 from employees order by hire_date;
 
 -- 3
 select count(*) from employees where gender = 'm';
 select count(*) from employees where gender = 'f';
 
 -- 4
 select count(*) from salaries where to_date='9999-01-01';
 
 -- 5
 select count(*) from departments;
 
 -- 6
 select count(*) from dept_manager;
 
 -- 7
 select * from departments order by length(dept_name) desc;
 
 -- 8
 select count(*) from salaries where salary >= 120000;
 
 -- 9
 select distinct title from titles order by length(title) desc;
 
 -- 10
 select count(*) from titles where title='Engineer';

-- 11
select * from titles where emp_no='13250' order by from_date; 