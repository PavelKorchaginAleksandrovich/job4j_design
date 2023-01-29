

create table insurance_policy(
    id serial primary key,
    series varchar(6),
    number varchar(20),
    start timestamp,
    end timestamp
    );

create table customer(
    id serial primary key,
    name varchar(255),
    sex boolean,
    age integer,
    insurance_policy_id int references insurance_policy(id)
);


insert into insurance_policy(series, number, start, end) values ('2312', '123456', '2023-01-01 00:00:00', '2023-12-31 23:59:59');
insert into insurance_policy(series, number, start, end) values ('2312', '134567', '2023-01-01 00:00:00', '2023-12-31 23:59:59');
insert into insurance_policy(series, number, start, end) values ('1234', '654321', '2024-01-01 00:00:00', '2024-12-31 23:59:59');
insert into customer(name, sex, age, insurance_policy_id) values ('Ivan', true, 30, 1);
insert into customer(name, sex, age, insurance_policy_id) values ('Olga', false, 25, 2);
insert into customer(name, sex, age, insurance_policy_id) values ('Anna', false, 24, 3);

select
    cus.name,
    cus.sex,
    cus.age,
    ip.series,
    ip.number
from insurance_policy as ip
join customer as cus
on ip.id = cus.insurance_policy_id;

select
    cus.name,
    ip.number,
    ip.series,
    ip.end
from customer as cus
join insurance_policy as ip
on cus.insurance_policy_id =ip.id
where ip.start >= '2023-01-01';

select
    cus.name,
    cus.sex,
    ip.number,
    ip.series
from customer as cus
join insurance_policy as ip
on cus.insurance_policy_id =ip.id
where ip.start <= '2023-01-01' and ip.end >= '2023-12-31';