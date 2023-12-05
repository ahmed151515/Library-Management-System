use Library_Management_System;

create table admins
(
	admin_ID int primary key,
	password varchar(30) not null,
	email    varchar(50) unique,
);

create table users
(
	user_ID int primary key,
	password varchar(30) not null,
	email    varchar(50) unique,
);

create table books
(
	book_ID         int primary key,
	book_name       varchar(30) not null,
	num_page        int,
	book_descnbtion varchar(150),
	book_author     varchar(30),
	is_translator   bit,
	cover_page      varbinary(max),
	admin_ID        int  foreign Key REFERENCES  admins(admin_ID)
	);

create table book_categorise
(
	book_ID int  foreign Key REFERENCES  books(book_ID),
	category varchar(30)
);

create table user_borrow_books
(
	user_ID int  foreign Key REFERENCES  users(user_ID),
	admin_ID int  foreign Key REFERENCES  admins(admin_ID),
	book_ID int  foreign Key REFERENCES  books(book_ID),
	strart_date date not null,
	end_date date not null,
);