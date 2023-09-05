select * from emaillist;

insert into emaillist values(null,'전','예준','sunlight9344@gmail.com');

select no,first_name,last_name,email from emaillist order by no desc;

delete from emaillist where email='dooli';