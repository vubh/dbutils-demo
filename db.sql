create table t_user(
id int primary key auto_increment,
name varchar(20),
age int(2),
description varchar(100)
);
insert into t_user(name, age, description) values ('马云', 20, '阿里巴巴创始人');
insert into t_user(name, age, description) values ('马化腾', 21, '腾讯创始人');
insert into t_user(name, age, description) values ('雷军', 22, '小米创始人');

