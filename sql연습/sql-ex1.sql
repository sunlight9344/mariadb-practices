-- 예제2: 비교연산자

select 
	first_name, gender, hire_date
from
	employees
where
	hire_date <= '1990-01-01'
	and gender = 'f'
order by hire_date desc;

-- 예제3: in 연산자

select emp_no, dept_no
  from dept_emp
 where dept_no in ('d005','d009');
 
 -- 예제4: like 검색
 select first_name, hire_date
   from employees
  where hire_date like '1989%';
  
  select first_name, hire_date
    from employees
   where hire_date between '1989-01-01' and '1989-12-31'
   order by hire_date;
  
  -- order by
  select concat(first_name, ' ', last_name) as 'full name', gender, hire_date
	from employees
order by hire_date;

-- ex2
select emp_no, salary, from_date, to_date
  from salaries
 where to_date like '2001%'
	or from_date like '2001%'
order by salary desc;

-- ex3
  select first_name, gender, hire_date
    from employees
   where gender = 'm'
order by hire_date;

-- ex4
  select emp_no, salary
    from salaries
order by emp_no asc, salary desc;