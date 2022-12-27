create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('Phone', 11000), ('Laptop', 8000), ('Watch', 1000);
insert into people(name) values ('Ваня'), ('Гена'), ('Александр');
insert into devices_people(device_id, people_id) values (1, 1), (2, 1);
insert into devices_people(device_id, people_id) values (1, 2), (2, 2), (3, 2);
insert into devices_people(device_id, people_id) values (2, 3), (3, 3);

select
    avg(dev.price)
from devices as dev;

select
    p.name,
    avg(dev.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices dev on dp.device_id = dev.id
group by p.name;

select
    p.name,
    avg(dev.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices dev on dp.device_id = dev.id
group by p.name
having avg(dev.price) > 5000;