create table insurance_planes(
    id serial primary key,
    name varchar(255)
);

create table insurance_poliсies(
    id serial primary key,
    number varchar(30),
    insurance_plan_id int references insurance_planes(id)
    );

create table customers(
    id serial primary key,
    number varchar(255),
    insurance_policy_id int references insurance_poliсies(id) unique
);

create table doctors(
    id serial primary key,
    name varchar(255),
);

create table specialties(
    id serial primary key,
    name varchar(255),
);

create table doctors_specialties(
    doctor_id int references doctors(id),
    specialty_id int references specialties(id)
);
