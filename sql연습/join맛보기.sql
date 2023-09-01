-- inner join

-- ex1
select a.emp_no, a.first_name, a.last_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no 
and b.to_date ='9999-01-01';

-- ex2
select a.emp_no, a.first_name, a.last_name, a.gender, b.title
from employees a, titles b
where a.emp_no = b.emp_no 
and b.to_date ='9999-01-01'
and a.gender='F'
and b.title = 'Engineer';

-- 1) join ~ on *
select a.title, avg(b.salary)
from titles a join salaries b on a.emp_no = b.emp_no
where a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
order by avg(b.salary) desc;

-- 2) Natural Join
-- 조인 대상이 되는 테이블들에 이름이 같은 컬럼이 있을 경우
-- 자동으로 조인됨
select a.first_name, b.title
from employees a natural join titles b
where b.to_date = '9999-01-01'
order by a.first_name asc;

-- 3) join ~ using
-- natural join 의 문제점을 알아보자
select count(*)
from titles a join salaries b on a.emp_no = b.emp_no
where a.to_date = '9999-01-01'
and b.to_date = '9999-01-01';

-- 실습문제1
-- 현재, 직원별 근무 부서를 출력 해보세요.
-- 사번, 직원이름(first_name), 부서명만 출력
select c.emp_no, c.first_name, a.dept_name
from departments a, dept_emp b, employees c
where a.dept_no = b.dept_no and b.emp_no = c.emp_no
and b.to_date = '9999-01-01';
-- 실습문제2
-- 현재, 직책별 평균연봉과 직원수를 구하되 직책별 직원수가 100명 이상인 직책만 출력하세요.
-- 직책, 평균연봉, 직원만 출력

select b.title, avg(a.salary), count(b.title)
from salaries a, titles b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and count(b.title) >= 100
group by b.title;

-- 실습문제3
-- 현재, 부서별로 직책이 Engineer인 지원즐에 대해서만 평균연봉을 구하세요.
-- 부서이름, 평균급여로 출력하고 평균연봉이 높은 순으로 정렬 하세요.
select *
from salareis a, titles b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01';