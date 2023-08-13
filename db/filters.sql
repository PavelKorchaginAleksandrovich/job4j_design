
create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    price integer,
    expired_date timestamp,
    type_id int references type(id)
    );

insert into type(name) values ('Сыр'), ('Молоко'), ('Бакалея');
insert into product(name, price, expired_date, type_id) values ('Сыр плавленный', 300, '2023-03-20', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр моцарелла', 150, '2023-01-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр колбасный', 200, '2023-02-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр пармезан', 600, '2023-03-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр дорблю', 600, '2023-04-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр шоколадный', 100, '2023-03-20', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр российский', 200, '2023-03-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр эдам', 300, '2023-02-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр фета', 400, '2023-02-01', 1);
insert into product(name, price, expired_date, type_id) values ('Сыр брынза', 200, '2023-02-01', 1);
insert into product(name, price, expired_date, type_id) values ('Молоко 3.2', 100, '2023-04-01', 2);
insert into product(name, price, expired_date, type_id) values ('Мороженое эскимо', 50, '2023-02-01', 2);
insert into product(name, price, expired_date, type_id) values ('Мороженое ленинградское', 60, '2023-02-01', 2);
insert into product(name, price, expired_date, type_id) values ('Сахар', 60, '2026-01-01', 3);




select
    p.name
from type as t
join product as p
on t.id = p.type_id
where t.name = 'Сыр';

select
    p.name
from product as p
where lower(p.name) like '%мороженое%';

select
    p.name
from product as p
where p.expired_date <= CURRENT_DATE;

select               
    p.name
from product as p
where p.price IN (
        select
            max(p.price)
        from product as p);

select
    t.name,
    count(p.type_id) as count
from type as t
join product as p
on t.id = p.type_id
group by t.name;

select
    t.name as type,
    count(p.type_id) as count
from type as t
join product as p
on t.id = p.type_id
group by t.name
having count(p.type_id) < 10;

select
    t.name as type,
    p.name as product
from type as t
join product as p
on t.id = p.type_id;











