-- q1
select avg(a.salary)
from salaries a
where a.to_date = '9999-01-01';

select count(*)
from salaries a
where a.salary > (select avg(a.salary)
from salaries a
where a.to_date = '9999-01-01')
and a.to_date = '9999-01-01';

-- q2 생략

-- q3
select a.dept_no, avg(b.salary) as avg_salary
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no;

select *
from employees a, dept_emp b, salaries c
where 

-- q4 갱장히 중요함 employee-dept , employee-dept_manager 일 캐 두 개 join 해야함


-- q5
select a.dept_no,avg(b.salary)
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no;

select a.emp_no, a.first_name, c.title, b.salary
from employees a, salaries b, titles c, dept_emp d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and d.to_date = '9999-01-01';

-- q6 출력 : 총무팀 20000
select avg(b.salary)
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no;

select max(avg_salary)
from (select avg(b.salary) as avg_salary
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no) a;

-- q7 Engineer 40000

-- q8 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 연봉
-- 순수 쪼인문제