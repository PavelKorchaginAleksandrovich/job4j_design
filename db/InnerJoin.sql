

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


select
    cus.name,
    cus.sex,
    cus.age,
    ip.series,
    ip.number
from insurance_policy as ip join customer as cus on ip.id = cus.insurance_policy_id;

select
    cus.name,
    ip.number,
    ip.series,
    ip.end
from customer as cus join insurance_policy as ip on cus.insurance_policy_id =ip.id
where ip.start >= '2021-01-01';

select
    cus.name,
    cus.sex,
    ip.number,
    ip.serie,
from customer as cus join insurance_policy as ip on cus.insurance_policy_id =ip.id
where ip.start >= '2021-01-01' and ip.end <= '2021-12-31';