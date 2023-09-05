
insert category values(null,'소설');
insert category values(null,'수필');
insert category values(null,'시');
select * from category;

insert into book values(null,1,'삼국지',10000);
insert into book values(null,2,'나의인생',5000);
insert into book values(null,3,'그대라는시가',99999);
select * from book;

insert into member values(null,'전예준','010-9609-9344','sunlight9344@gmail.com','9999');
insert into member values(null,'임가영','010-2877-6320','rkdudrhdwn@gmail.com','2222');
select * from member;

insert cart values(null,1,1,2);
insert cart values(null,2,1,2);
insert cart values(null,3,2,1);
select * from cart;

insert orders values(null,1,'2023-01-01',20000,'서울시 이촌동');
insert orders values(null,2,'2023-02-02',40000,'제주도민임');
select * from orders;

-- book 출력
select a.no, b.name, a.title, a.price
from book a, category b
where a.category_no = b.no;

-- cart 출력
select c.no, title, b.name, c.quantity*a.price
from book a, member b, cart c
where a.no = c.book_no
and b.no = c.member_no
order by c.no;

select * from cart;

delete from cart where no=6;

select * from orders_book;