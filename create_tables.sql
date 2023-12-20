use Library_Management_System;
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
	is_translator   bit,
	admin_ID        int  foreign Key REFERENCES  admins(admin_ID)
	);

create table book_categorise
(
	book_ID int  foreign Key REFERENCES  books(book_ID),
	category varchar(30),
	category_index int not null
	
);

create table user_borrow_books
(
	user_ID int  foreign Key REFERENCES  users(user_ID),
	book_ID int  foreign Key REFERENCES  books(book_ID),
	strart_date date not null,
	end_date date not null,
);


--  index
create index 



