#create database vttp_2025;

#use vttp_2025;

/*
drop table tv_shows;

create table tv_shows (
	prog_id int not null auto_increment,
	title char(64) not null,
	lang char(64) not null,
	official_site varchar(255),
    rating enum('G','PG','NC16','M18','R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

select * from information_schema.table_constraints
where table_name = 'tv_shows'
*/
# drop table tutorial;

create table tutorial (
	id int not null auto_increment,
	title varchar(100) not null,
	author varchar(80) not null,
	submission_date date,
	constraint pk_tutorial_id primary key (id)
);

insert into tutorial (title,author,submission_date) values ('CS1001','Chuk','2025-02-01');
insert into tutorial (title,author,submission_date) values ('CS1002','Sam','2025-03-01');
insert into tutorial (title,author,submission_date) values ('CS1003','Tom','2025-05-21');
insert into tutorial (title,author,submission_date) values ('CS1004','Jim','2025-02-01');
insert into tutorial (title,author,submission_date) values ('CS1005','Cass','2025-06-12');
insert into tutorial (title,author,submission_date) values ('CS1006','Yas','2025-09-20');

insert into tutorial (title,author,submission_date) values ('CS2001','Chuk','2025-05-01');
insert into tutorial (title,author,submission_date) values ('CS2002','Sam','2025-05-01');
insert into tutorial (title,author,submission_date) values ('CS2003','Tom','2025-08-21');
insert into tutorial (title,author,submission_date) values ('CS2004','Jim','2025-10-01');
insert into tutorial (title,author,submission_date) values ('CS2005','Cass','2025-12-12');
insert into tutorial (title,author,submission_date) values ('CS2006','Yas','2025-11-20');

# retrieve all the records
# select * from tutorial;
# limit to first 5; offset initial rows
select * from tutorial limit 5 offset 3;

# Reading of specific data

# selecting a field
select author from tutorial;

select * from tutorial where author = "chuk";
select * from tutorial where author like 'C%';
select * from tutorial where author like '%as%';

select * from tutorial where submission_date >= '2025-02-01' and submission_date <= '2025-10-28'
order by id desc, author asc;

select * from tutorial where title in ('cs2001','cs1001','cs2004');

select * from tutorial where submission_date between '2025-02-01' and '2025-02-28'
and title in ('cs2001', 'cs1001')
and author like '%hu%';


insert into tv_shows (title,lang,rating,user_rating,release_date) 
values('AI will win','Chinese','PG', 7.5,'2025-01-25');

insert into tv_shows (title,lang,rating,user_rating,release_date) 
values('James Bond','English','NC16', 8.0,'2025-01-25');

insert into tv_shows (title,lang,rating,user_rating,release_date) 
values('The Trunk','Korean','R21', 9.9,'2024-11-25');

insert into tv_shows (title,lang,rating,user_rating,release_date) 
values('Mad Max Fury','English','M18', 8.8,'2016-05-18');

insert into tv_shows (title,lang,rating,user_rating,release_date) 
values('Up','English','PG', 9.3,'2012-11-25');

select * from tv_shows
where user_rating > 9.0
or
rating in ('R21','M18');

