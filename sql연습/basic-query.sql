select version(), current_date, now() from dual;

-- 뿌뿡빵빵뿡이
select sin(pi()/4), 1 + 2 * 3 - 4 / 5 from dual;

-- 대소문자 구분 안한다잉alter
SelEcT VerSion(), Current_date, noW() frOM duAl;

-- row row row row row col ocl ocl ocl col
-- table 생성 : DDL
create table pet(
	name varchar(100),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);

-- schema 확인
show tables;
desc pet;

-- table 삭제 : DDL
drop table pet;
show tables;

-- inser : DML(C)
insert into pet values('성탄이','전예준','사람','m','2019-11-30',null);

-- select : DML(R)
select * from pet;

-- update : DML(U)
update pet set name='성타니' where name='성탄이';

-- delete  
delete from pet where name='성타니';

-- load data
load data local infile 'd:\pet.txt' into table pet;
update pet set death = null where name != 'bowser';

-- select 연습
select owner from pet where name='bowser';
select * from pet where birth >= 1998-01-01;
select * from pet where species='snake' or species='bird';

-- order by
select name, birth from pet order by birth asc;
select name, birth from pet order by birth desc;

select name, birth, death from pet where death is null;

-- like 검색(패턴검색)
select name from pet where name like 'b%';
select name from pet where name like '%fy';
select name from pet where name like '%w%';
select name from pet where name like '____';
select name from pet where name like 'b____';

-- 집계: count, avg, sum, max, min...
select count(*) from pet;
select max(birth) from pet;
select * from pet;