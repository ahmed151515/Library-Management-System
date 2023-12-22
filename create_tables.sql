
-- create tables
create table admins
(
	admin_ID int primary key IDENTITY(1,1),
	password varchar(30) not null,
	email    varchar(50) unique,
);

create table users
(
	user_ID int primary key IDENTITY(1,1),
	password varchar(30) not null,
	email    varchar(50) unique,
);

create table books
(
	book_ID         int primary key,
	book_name       varchar(30) not null unique,
	num_page        int,
	book_descnbtion varchar(150),
	book_author     varchar(30),
	admin_ID        int  foreign Key REFERENCES  admins(admin_ID)
	);

create table book_categorise
(
	book_ID int  foreign Key REFERENCES  books(book_ID) on delete CASCADE,
	category varchar(30),
	category_index int not null
);

create table user_borrow_books
(
	user_ID int  foreign Key REFERENCES  users(user_ID),
	book_ID int  foreign Key REFERENCES  books(book_ID) on delete CASCADE,
	strart_date date not null,
	end_date date not null,
);

--  index
create index idx_borrow
on user_borrow_books(user_id, book_id);

-- view
CREATE VIEW Borro_GUI 
as
select
books.book_ID,
book_name,
user_borrow_books.user_ID,
email,
end_date
from books  inner join user_borrow_books
on books.book_ID = user_borrow_books.book_ID 
inner join users
on  users.user_ID = user_borrow_books.user_ID;
go


insert into admins values ('admin', 'admin@gmail.com');
insert into users values ('12345', 'user@gmail.com');



select * from books;
select * from book_categorise;



