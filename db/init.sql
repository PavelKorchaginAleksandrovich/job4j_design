insert into role(name) values ('admin'), ('user'), ('guest');

insert into users(name, role_id) values ('Alex', 1), ('Pavel', 1), ('Petr', 1);
insert into users(name, role_id) values ('Mike', 2), ('Tom', 2), ('John', 2);
insert into users(name, role_id) values ('Bob', 3), ('Brian', 3), ('George', 3);

insert into rules(name) values ('read'), ('write'), ('delete');

insert into role_rules(role_id, rule_id) values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 1);

insert into category (name) values ('service'), ('support'), ('other');

insert into state(name) values ('new'), ('in progress'), ('done');


insert into items(name, user_id, category_id, state_id) values ('access denided', 7, 1, 1);
insert into items(name, user_id, category_id, state_id) values ('laptop does not working', 3, 2, 2);
insert into items(name, user_id, category_id, state_id) values ('purchase of components', 3, 3, 3);

insert into comments(name, item_id) values ('can not read the file', 1);
insert into comments(name, item_id) values ('the monitor is black', 2);
insert into comments(name, item_id) values ('components for the sales department', 3);

insert into attaches(name, item_id) values ('screenshot', 1);
insert into attaches(name, item_id) values ('photo', 2);
insert into attaches(name, item_id) values ('order', 3);
insert into attaches(name, item_id) values ('invoice', 3);

