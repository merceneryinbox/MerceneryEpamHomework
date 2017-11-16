create schema chat;

set search_path to chat;

create table Roles(
  role_id serial,
  role_name varchar(25) not null,
  can_read boolean not null default false,
  can_write boolean not null default false,
  can_update boolean not null default false,
  can_revoke boolean not null default false,
  misc text,

  primary key (role_name),
  constraint uk_roles unique (role_id)
);

insert into roles (role_name, can_read, can_revoke, can_update, can_write)
values ('admin', true, true, true, true),
  ('updaters', true, true, true, true),
  ('moderators', true, true, true, false);

select * from roles;

create table Users(
  user_id serial,
  login varchar(25) not null,
  password varchar(50) not null,
  role_id int not null,

  primary key(login),
  constraint uk_users unique (user_id)
);

insert into users(login,password,role_id)
values ('admin','', (select role_id from roles where role_name ='admin'));
insert into users(login,password,role_id)
values ('daniel','',3);

select * from users;

DROP TABLE messages;
create table Messages(
  msg_id INT,
  user_id int not null,
  msg_time timestamp not null,
  msg_content varchar(300) not null,

  primary key(msg_id),
  constraint uk_messages unique (user_id, msg_time, msg_content)
);

alter table users
  add constraint fk_users_roles_id foreign key (role_id)
references Roles (role_id)
on delete cascade;

alter table Messages
  add constraint fk_messages_users_id
foreign key (user_id)
references Users (user_id)
on delete cascade;