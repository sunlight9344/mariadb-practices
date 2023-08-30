-- inner join

-- ex1
select a.emp_no, a.first_name, a.last_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no 
and b.to_date ='9999-01-01'