desc author;
desc book;

insert into author values(null, '스테파니메이어');
insert into author values(null, '조정래');
insert into author values(null, '김동인');
insert into author values(null, '김난도');
insert into author values(null, '천상병');
insert into author values(null, '원수연');

select * from author;

insert into book(title,author_no) values ('트와일라잇',1);
insert into book(title,author_no) values ('뉴문',1);
insert into book(title,author_no) values ('이클립스',1);
insert into book(title,author_no) values ('브레이킹던',1);
insert into book(title,author_no) values ('아리랑',2);
insert into book(title,author_no) values ('젊은그들',3);
insert into book(title,author_no) values ('아프니깐 청춘이다',4);
insert into book(title,author_no) values ('귀천',5);
insert into book(title,author_no) values ('태백산맥',2);
insert into book(title,author_no) values ('풀하우스',6);

select * from book;

update book set rent='Y' where no=3;

update book set no=2 where no=4;
update book set no=3 where no=5;
update book set no=4 where no=6;
update book set no=5 where no=7;
update book set no=6 where no=8;
update book set no=7 where no=9;
update book set no=8 where no=10;
update book set no=9 where no=11;
update book set no=10 where no=12;
