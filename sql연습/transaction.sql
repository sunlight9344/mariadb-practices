insert
into member(no, email, password, name, dept, self_intro)
values (null, 'kickscar2@gmail.com',password('1234'), '전예준', '개발팀2', null);
select * from member;

insert
into member(no, email, password, name, dept, self_intro)
values (null, 'sunlight3@gmail.com',password('1234'), '전예준3', '개발팀3', null);

-- update
update member
 set email='sunlight@gmail.com', name='뿡빵이'
 where no = 1;
 select * from member;
 
 -- delete
 delete 
 from member 
 where no = 2;
 select * from member;
 
 select no, email, dept from member;
 
 -- transaction begin
 set autocommit = 0;
 select @@autocommit from dual;
 
insert
into member(no, email, password, name, dept, self_intro)
values (null, 'sunlight4@gmail.com',password('1234'), '전예준4', '개발팀4', null);
 
select no, email, dept from member;
commit;
select no, email, dept from member;