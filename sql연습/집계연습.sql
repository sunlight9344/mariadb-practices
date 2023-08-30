select avg(salary),sum(salary) from salaries;

select emp_no,avg(salary)
	from salaries
	where emp_no = 10060;
    
-- group by 에 참여하는 컬럼은 projection 이 가능하다. -> select 절에 올 수 있다.
select emp_no, avg(salary) as avg_salary
	from salaries
    group by emp_no
    having avg_salay < 100000
    order by avg_salary desc;
    
select emp_no, avg(salary)
	from salaries
    group by emp_no
    having avg(salary) >= 60000
    order by avg(salary);

-- 문법적으로는 오류
-- 의미적으로는 맞다(where 때문에)
select avg(salary), sum(salary)
	from salaries
    where emp_no = 10060;

-- 이게 맞는거지 ㅋㅋ    
select emp_no,avg(salary), sum(salary)
	from salaries
    group by emp_no
    having emp_no = 10060;
    