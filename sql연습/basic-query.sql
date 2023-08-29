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

