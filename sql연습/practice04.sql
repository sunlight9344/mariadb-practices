-- q1

select count(*)
from salaries a
where a.salary > (select avg(a.salary)
from salaries a
where a.to_date = '9999-01-01')
and a.to_date = '9999-01-01';

-- q2 생략

select a.emp_no, a.first_name, b.salary
from employees a, salaries b, dept_emp c, departments d,
(select a.dept_no, max(b.salary) as max_salary
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no) e
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and c.dept_no = e.dept_no
and d.dept_no = e.dept_no
and b.salary = e.max_salary
order by b.salary desc;

-- q3
select a.emp_no, a.first_name, d.salary
from employees a, dept_emp b, salaries d,
(select a.dept_no, avg(b.salary) as avg_salary
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no) e
where a.emp_no = b.emp_no
and a.emp_no = d.emp_no
and b.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
and b.dept_no = e.dept_no
and d.salary > e.avg_salary;

-- q4 갱장히 중요함 employee-dept , employee-dept_manager 일 캐 두 개 join 해야함
select 
	a.emp_no,
    CONCAT(a.first_name,' ',a.last_name) as name,
    CONCAT(d.first_name,' ',d.last_name) as manage_name,
    e.dept_name
from 
	employees a,
	dept_emp b,
	dept_manager c,
    employees d,
    departments e
where 
	a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and d.emp_no = d.emp_no
and c.dept_no = e.dept_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01';

-- q5
select a.emp_no, 
CONCAT(a.first_name, ' ',a.last_name) as name,
c.salary,
f.title
from employees a,
dept_emp b, 
salaries c,
titles f,
(select a.dept_no, avg(b.salary) as avg_salary
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no
order by avg_salary desc
limit 0,1) e
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and f.to_date = '9999-01-01'
and b.dept_no = e.dept_no
and f.emp_no = a.emp_no
order by c.salary desc;

-- q6 출력 : 총무팀 20000
select b.dept_name, round(avg(c.salary)) as avg_salary
from dept_emp a, departments b, salaries c
where a.dept_no = b.dept_no
and a.emp_no = c.emp_no
and a.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
group by a.dept_no
order by avg_salary desc
limit 0,1;

-- q7 Engineer 40000
select a.title, round(avg(b.salary)) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
order by avg_salary desc
limit 0,1;

-- q8 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 연봉
-- 순수 쪼인문제
select *
from employees a,
dept_emp b, 
departments c,
salaries d
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01';

select *
from employees a,
dept_manager b,
departments c,
salaries d
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01';