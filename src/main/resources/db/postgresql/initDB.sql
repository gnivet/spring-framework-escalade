create table areas (id int4 not null, name varchar(255), city varchar(255), country varchar(255), gpscoordinate varchar(255), postalcode varchar(255), street varchar(255), site_id int4, user_id int4, primary key (id))
create table comments (id int4 not null, name varchar(255), comment varchar(255), site_id int4, primary key (id))
create table lengths (id int4 not null, name varchar(255), comment varchar(255), cotation int4 not null, length_status boolean not null, under_cotation varchar(255), way_id int4, primary key (id))
create table points (id int4 not null, name varchar(255), length_id int4, primary key (id))
create table roles (id  serial not null, name varchar(255), primary key (id))
create table sites (id int4 not null, name varchar(255), birth_date date, valid boolean not null, area_id int4, type_id int4, user_id int4, primary key (id))
create table sitetypes (id int4 not null, name varchar(255), primary key (id))
create table topoBkgs (id int4 not null, name varchar(255), accepted boolean, topo_id int4, user_id int4, primary key (id))
create table topos (id int4 not null, name varchar(255), available boolean, comment_date date, description varchar(255), user_id int4, primary key (id))
create table users (id  serial not null, address varchar(255), city varchar(255), email varchar(255), enabled boolean, first_name varchar(255), last_name varchar(255), password varchar(255), password_confirm varchar(255), postal_code varchar(255), telephone varchar(255), username varchar(255), primary key (id))
create table users_roles (user_id int4 not null, role_id int4, users_id  serial not null, roles_id int4 not null, primary key (users_id, roles_id))
create table ways (id int4 not null, name varchar(255), zone_id int4, primary key (id))
create table zones (id int4 not null, name varchar(255), site_id int4 not null, primary key (id))
create sequence base_entity_sequence start 1 increment 50
alter table areas add constraint FKicbc1fwih0igug22pwcp8mcmv foreign key (site_id) references sites
alter table areas add constraint FKg9mr2hiaw7vc7dgj83a47hrnm foreign key (user_id) references users
alter table comments add constraint FK6fx51pur71dqvnw1i05avuw53 foreign key (site_id) references sites
alter table lengths add constraint FKqj6vbt6dwpdnubxyrmpmkoo6g foreign key (way_id) references ways
alter table points add constraint FKo4o7h4xj04c0yjynew9u4b5wh foreign key (length_id) references lengths
alter table sites add constraint FKe13mje5mbo6g06ggkgxigyk9s foreign key (area_id) references areas
alter table sites add constraint FK2o3ithnm0wmkfs1av9ix75hu2 foreign key (type_id) references sitetypes
alter table sites add constraint FKme2b85lrccmkfv4i88bxcyqtm foreign key (user_id) references users
alter table topo_bookings add constraint FK1qb8a4o7pqk9og93nmdqrketi foreign key (topo_id) references topos
alter table topo_bookings add constraint FKl8ofoscxnaa1504lavai7a82a foreign key (user_id) references users
alter table topos add constraint FKi53kinkhxov0fkvs51as7espb foreign key (user_id) references users
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users
alter table ways add constraint FK2fimekn8wljw7b8ia1vu3ksi1 foreign key (zone_id) references zones
alter table zones add constraint FKk35sts60wfh4x2318e37j5fj7 foreign key (site_id) references sites