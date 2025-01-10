use vttp_2025;

create table room (
	id int auto_increment,
    room_type varchar(150) not null,
    price float default 150.0,
    constraint pk_room_id primary key (id)
    );

create table customer (
	id int auto_increment not null,
    full_name varchar(255) not null,
    email varchar(255) not null,
    constraint pk_customer_id primary key (id)
    );

create table reservation (
	id int auto_increment not null,
    customer_id int,
    room_id int,
    start_date date,
    end_date date,
    cost float,
    constraint pk_reservation_id PRIMARY KEY (id),
	constraint fk_customer_id FOREIGN KEY(customer_id) REFERENCES customer(id),
    constraint fk_room_id FOREIGN KEY(room_id) REFERENCES room(id)
);

insert into room (room_type,price) values ('standard',150.0);
insert into room (room_type,price) values ('deluxe',200.0);
insert into room (room_type,price) values ('super deluxe',250.0);
insert into room (room_type,price) values ('president',300.0);
insert into room (room_type,price) values ('suite',350.0);
insert into room (room_type,price) values ('villa','500.0');

insert into customer (full_name,email) values ('Emily Quek', 'emilyquek@visa.com.sg');
insert into customer (full_name,email) values ('Zhixuan Kang', 'zhixuan@visa.com.sg');
insert into customer (full_name,email) values ('Aloysius Chen', 'aloychen@visa.com.sg');
insert into customer (full_name,email) values ('Hanyen', 'hanyen@visa.com.sg');
insert into customer (full_name,email) values ('Darryl', 'darryl@nus.com.sg');

select * from room;
select * from customer;
select * from reservation;

# day 22 slide 3
select * from tv_shows;
select distinct lang from tv_shows;
select distinct lang,rating from tv_shows;


# day 22 slide 5
select avg(user_rating) from tv_shows
where lang like '%Eng%';
select sum(user_rating) from tv_shows
where lang like '%Eng%';

select sum(user_rating)/count(*) from tv_shows
where lang like '%Eng%';

select rating, count(rating) from tv_shows
group by rating
order by count(rating) desc;

select rating, count(rating) from tv_shows
group by rating
order by rating asc;

# nested query
select rating,count(rating) as cnt from tv_shows
where lang in (select distinct lang from tv_shows)
group by rating
order by rating asc;

# day 22, slide 7
# cannot use where count(rating) > 5 here
select rating,count(rating) as cnt from tv_shows
where count(rating) > 5
group by rating
order by rating asc;
# Do this instead
select rating,count(rating) as cnt from tv_shows
group by rating
having count(rating)>1
order by rating asc;
# Alternatively use a nested query to sort data from a new table
select * from
(select rating,count(rating) as cnt from tv_shows
group by rating
order by rating asc) as tableA
where tableA.cnt > 1;


#day 22 PM
# over partition by

create table car (
	id int not null auto_increment,
	make varchar(50),
	model varchar(50),
	cartype varchar(50),
	price float default '10000.0',
constraint pk_car_id primary key (id)
);

insert into car(make,model,cartype,price) values ('Hyundai','Avante','sedan','80000.0');
insert into car(make,model,cartype,price) values ('Maserati','Levante','suv','150000.0');
insert into car(make,model,cartype,price) values ('Ford','Mustang','sports','180000.0');
insert into car(make,model,cartype,price) values ('Toyota','Corrola','sedan','60000.0');
insert into car(make,model,cartype,price) values ('Mitsubishi','Lancer','sedan','50000.0');
insert into car(make,model,cartype,price) values ('Volkswagen','Tiguan','suv','100000.0');
insert into car(make,model,cartype,price) values ('Ferrari','Spyder','sports','200000.0');
insert into car(make,model,cartype,price) values ('Rolls-Royce','Ghost','luxury','250000.0');
insert into car(make,model,cartype,price) values ('Bentley','Flying Spur','luxury','250000.0');
insert into car(make,model,cartype,price) values ('Mercedes','G-Wagon','suv','80000.0');
insert into car(make,model,cartype,price) values ('Audi','Q4 E-tron','suv','130000.0');
insert into car(make,model,cartype,price) values ('BYD','Seal','sedan','110000.0');

select * from car;

select make,model,cartype,price
,max(price) over (partition by cartype) as max_cartype
from car;

select make,model,cartype,price
,sum(price) over (partition by cartype) as sum_cartype
from car;

select make,model,cartype,price
,avg(price) over (partition by cartype) as avg_cartype
from car;