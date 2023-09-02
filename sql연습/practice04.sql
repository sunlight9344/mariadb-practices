-- q1

select count(*)
from salaries a
where a.salary > (select avg(a.salary)
from salaries a
where a.to_date = '9999-01-01')
and a.to_date = '9999-01-01';

-- q2 생략

select 
	a.emp_no as '사번', 
	a.first_name as '이름', 
	b.salary as '급여'
from 
	employees a, 
	salaries b, 
	dept_emp c, 
	departments d,
	(select
		a.dept_no, 
        max(b.salary) as max_salary
	from 
		dept_emp a, salaries b
	where 
		a.emp_no = b.emp_no
		and a.to_date = '9999-01-01'
		and b.to_date = '9999-01-01'
	group by 
		a.dept_no) e
where 
	a.emp_no = b.emp_no
	and b.emp_no = c.emp_no
	and b.to_date = '9999-01-01'
	and c.to_date = '9999-01-01'
	and c.dept_no = e.dept_no
	and d.dept_no = e.dept_no
	and b.salary = e.max_salary
order by 
	b.salary desc;

-- q3
select 
	a.emp_no as '사번',
	a.first_name as '이름',
	d.salary as '급여'
from 
	employees a, 
	dept_emp b, 
	salaries d,
	(select 
		a.dept_no, 
		avg(b.salary) as avg_salary
	from 
		dept_emp a, 
		salaries b
	where 
		a.emp_no = b.emp_no
		and a.to_date = '9999-01-01'
		and b.to_date = '9999-01-01'
	group by 
		a.dept_no) e
where 
	a.emp_no = b.emp_no
	and a.emp_no = d.emp_no
	and b.emp_no = d.emp_no
	and b.to_date = '9999-01-01'
	and d.to_date = '9999-01-01'
	and b.dept_no = e.dept_no
	and d.salary > e.avg_salary;

-- q4 갱장히 중요함 employee-dept , employee-dept_manager 일 캐 두 개 join 해야함
select 
	a.emp_no as '사번',
    CONCAT(a.first_name,' ',a.last_name) as '이름',
    CONCAT(d.first_name,' ',d.last_name) as '매니저 이름',
    e.dept_name as '부서 이름'
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
select 
	a.emp_no as '사번',
	CONCAT(a.first_name, ' ',a.last_name) as 이름,
	f.title as '직책',
	c.salary as '급여'
from 
	employees a,
	dept_emp b, 
	salaries c,
	titles f,
	(select 
		a.dept_no, 
        avg(b.salary) as avg_salary
	from 
		dept_emp a, 
        salaries b
	where 
		a.emp_no = b.emp_no
		and a.to_date = '9999-01-01'
		and b.to_date = '9999-01-01'
	group by 
		a.dept_no
	order by 
		avg_salary desc
	limit 0,1) e
where 
	a.emp_no = b.emp_no
	and b.emp_no = c.emp_no
	and b.to_date = '9999-01-01'
	and c.to_date = '9999-01-01'
	and f.to_date = '9999-01-01'
	and b.dept_no = e.dept_no
	and f.emp_no = a.emp_no
order by 
	c.salary desc;

-- q6 출력 : 총무팀 20000
select 
	b.dept_name as '부서이름', 
    round(avg(c.salary)) as '평균급여'
from 
	dept_emp a, 
    departments b, 
    salaries c
where 
	a.dept_no = b.dept_no
	and a.emp_no = c.emp_no
	and a.to_date = '9999-01-01'
	and c.to_date = '9999-01-01'
group by 
	a.dept_no
order by 
	'평균급여' desc
limit 0,1;

-- q7 Engineer 40000
select 
	a.title as '직책', 
	round(avg(b.salary)) as '평균급여'
from 
	titles a, salaries b
where 
	a.emp_no = b.emp_no
	and a.to_date = '9999-01-01'
	and b.to_date = '9999-01-01'
group by 
	a.title
order by 
	'평균급여' desc
limit 0,1;

-- q8 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 연봉
-- 순수 쪼인문제
select 
	c.dept_name as '부서이름',
    concat(a.first_name, ' ', a.last_name) as '사원이름',
    d.salary as '연봉',
    concat(e.first_name, ' ', e.last_name) as '매니저 이름',
    g.salary as '매니저 연봉'
from 
	employees a,
	dept_emp b,
	departments c,
	salaries d,
	employees e,
	dept_manager f,
	salaries g
where 
	a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
and e.emp_no = f.emp_no
and e.emp_no = g.emp_no
and f.to_date = '9999-01-01'
and g.to_date = '9999-01-01'
and b.dept_no = f.dept_no
and d.salary > g.salary;