--Populate the database escalade

 
--alter table users_roles drop constraint FKa62j07k5mhgifpp955h37ponj; 
--alter table users_roles drop constraint FKml90kef4w2jy7oxyqv742tsfc; 

 

--Populate the database escalade

 
--alter table users_roles drop constraint FKa62j07k5mhgifpp955h37ponj; 
--alter table users_roles drop constraint FKml90kef4w2jy7oxyqv742tsfc; 

 

--alter table public.users drop constraint fke4b5c6vtyb9aad0h0xd58xsre;
--delete from public.users;
--INSERT INTO users ("id","address","city","email","enabled","first_name","last_name","password","password_confirm","postal_code","telephone","username","user_name") VALUES (1,null,null,'guillaumenvt@gmail.com',null,'Guillaume','Nivet','$2a$10$tFmQmKgmIAjZcOr1MSRDMe0DYafwpauvnjKSd/YBEpJsx7N6odRku','jdjdjv99',null,'0616720953',null,'guillaume.nivet');
--INSERT INTO users ("id","address","city","email","enabled","first_name","last_name","password","password_confirm","postal_code","telephone","username","user_name") VALUES (2,null,null,'enoranvt@gmail.com',null,'Enora','Nivet','$2a$10$qYq5xpDGyodDwo26LvbbN.xa0vYDnNptVbceSOw1lSw3zUvNXQS.G','enora',null,'0616720954',null,'enora.nivet');

--alter table areas add constraint FKicbc1fwih0igug22pwcp8mcmv foreign key (site_id) references sites

--delete from public.sitetypes;
--INSERT INTO sitetypes ("id","name") VALUES (1,'Falaise');
--INSERT INTO sitetypes ("id","name") VALUES (2,'Rocher');
--select *  from public.sitetypes;

delete from public.site_types;
INSERT INTO site_types ("id","name") VALUES (1,'Falaise');
INSERT INTO site_types ("id","name") VALUES (2,'Rocher');



alter table visits drop constraint fkb5qckmskhgtdyarpu55efqy1t;
delete from public.visits;
INSERT INTO public.visits ("id","visit_date","description","site_id") VALUES (1,{d '2024-01-05'},'Sortie à deux',1);
INSERT INTO public.visits ("id","visit_date","description","site_id") VALUES (2,{d '2024-05-02'},'Sortie club du sport alpin',2);
--select * from public.visits;

alter table areas drop constraint FKicbc1fwih0igug22pwcp8mcmv; 
alter table areas drop constraint FKg9mr2hiaw7vc7dgj83a47hrnm; 
delete from public.areas;
INSERT INTO areas ("id","name","city","country","gpscoordinate","postalcode","street","site_id","user_id") VALUES (1,'Les falaises d''Etretat','Etretat','France','15487|45578','020000','105 Rue de la falaise',1,1);
INSERT INTO areas ("id","name","city","country","gpscoordinate","postalcode","street","site_id","user_id") VALUES (2,'Etretat','Etretat','France','454878|4545454','020000','105 Rue de la falaise',2,1);
select * from public.areas;

alter table sites drop constraint FKe13mje5mbo6g06ggkgxigyk9s;
alter table sites drop constraint FK2o3ithnm0wmkfs1av9ix75hu2; 
alter table sites drop constraint FKme2b85lrccmkfv4i88bxcyqtm; 
delete from public.sites;
INSERT INTO public.sites ("id","name","birth_date","valid","area_id","type_id","user_id") VALUES (1,'Les rochers',{d '2000-04-02'},false,1,2,1);
INSERT INTO public.sites ("id","name","birth_date","valid","area_id","type_id","user_id") VALUES (2,'Les falaises de Pontlabet',{d '1956-11-22'},false,2,1,2);
select *from public.sites;

alter table zones drop constraint FKk35sts60wfh4x2318e37j5fj7; 
delete from public.zones; 
INSERT INTO zones ("id","name","site_id") VALUES (1,'Zone A',1);
INSERT INTO zones ("id","name","site_id") VALUES (2,'Zone B',2);

alter table points drop constraint FKo4o7h4xj04c0yjynew9u4b5wh; 
alter table points drop constraint FK9vn74muwnup3ljkc5lxk5iwtv; 
delete from public.points;
INSERT INTO public.points(id, name, length_id) 	VALUES ('1', 'point A', '1');
INSERT INTO public.points(id, name, length_id) 	VALUES ('2', 'point A', '2');

alter table comments drop constraint FK6fx51pur71dqvnw1i05avuw53; 
alter table comments drop constraint fk8omq0tc18jd43bu5tjh6jvraq;
delete from public.comments; 
INSERT INTO comments ("id","name","comment","site_id","visit_date","user_id") VALUES (1,'Les Oiseaux','comme elle est belle',1,{d '2000-04-02'},1);
INSERT INTO comments ("id","name","comment","site_id","visit_date","user_id") VALUES (2,'Les Hiboux','Très abrupte mais belle',2,{d '2001-04-25'},1);

alter table ways drop constraint FK9vn74muwnup3ljkc5lxk5iwtv;
alter table ways drop constraint FK2fimekn8wljw7b8ia1vu3ksi1; 
delete from public.ways;
INSERT INTO ways ("id","name","zone_id") VALUES (1,'Voie principale',1);
INSERT INTO ways ("id","name","zone_id") VALUES (2,'Le regard',2);

--alter table lengths drop constraint FKqj6vbt6dwpdnubxyrmpmkoo6g; 
alter table lengths drop constraint fkt7ok7un8otu4g6ylulprf582s;
delete from public.lengths;
INSERT INTO lengths ("id","name","comment","cotation","length_status","under_cotation","way_id") VALUES (1,'L''échappée','Facile',9,true,'facile',1);
INSERT INTO lengths ("id","name","comment","cotation","length_status","under_cotation","way_id") VALUES (2,'Ouverture','facile',9,true,'facile',2);


alter table topos drop constraint FKi53kinkhxov0fkvs51as7espb;
alter table topo_bkgs drop constraint fkk0nkwck8stanhqvhre7omb8y7;
delete from public.topos;
INSERT INTO topos ("id","name","available","comment_date","description","user_id") VALUES (1,'Les roches de Cognac',false,{d '2024-01-05'},'Falaises',2);
INSERT INTO topos ("id","name","available","comment_date","description","user_id") VALUES (2,'Les falaises d''Etretat',false,{d '2024-01-05'},'Falaises',1);



delete from public.visits;
INSERT INTO public.visits ("id","visit_date","description","site_id") VALUES (1,{d '2024-01-05'},'Sortie à deux',1);
INSERT INTO public.visits ("id","visit_date","description","site_id") VALUES (2,{d '2024-05-02'},'Sortie club du sport alpin',2);

alter table topo_bkgs drop constraint FK1qb8a4o7pqk9og93nmdqrketi; 
alter table topo_bkgs drop constraint FKl8ofoscxnaa1504lavai7a82a; 
delete from public.topo_bkgs;				
INSERT INTO topo_bkgs ("id","accepted","borrow_date","borrow_end_date","in_progress","topo_id","user_id") VALUES (1,true,{ts '2024-01-05 00:00:00.0'},{ts '2024-01-05 00:00:00.0'},false,352,2);
INSERT INTO topo_bkgs ("id","accepted","borrow_date","borrow_end_date","in_progress","topo_id","user_id") VALUES (2,true,{ts '2024-01-05 00:00:00.0'},{ts '2024-01-05 00:00:00.0'},false,352,1);



alter table areas add constraint FKicbc1fwih0igug22pwcp8mcmv foreign key (site_id) references sites;
alter table areas add constraint FKg9mr2hiaw7vc7dgj83a47hrnm foreign key (user_id) references users;
alter table public.comments add constraint FK6fx51pur71dqvnw1i05avuw53 foreign key (site_id) references sites;
alter table lengths add constraint FKqj6vbt6dwpdnubxyrmpmkoo6g foreign key (way_id) references ways;
alter table points add constraint FKo4o7h4xj04c0yjynew9u4b5wh foreign key (length_id) references lengths;
alter table sites add constraint FKe13mje5mbo6g06ggkgxigyk9s foreign key (area_id) references areas;
alter table sites add constraint FK2o3ithnm0wmkfs1av9ix75hu2 foreign key (type_id) references sitetypes;
alter table sites add constraint FKme2b85lrccmkfv4i88bxcyqtm foreign key (user_id) references users;
alter table topo_bkgs add constraint FK1qb8a4o7pqk9og93nmdqrketi foreign key (topo_id) references topos;
alter table topo_bkgs add constraint FKl8ofoscxnaa1504lavai7a82a foreign key (user_id) references users;
alter table topos add constraint FKi53kinkhxov0fkvs51as7espb foreign key (user_id) references users;
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles;
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users;
alter table ways add constraint FK2fimekn8wljw7b8ia1vu3ksi1 foreign key (zone_id) references zones;
alter table zones add constraint FKk35sts60wfh4x2318e37j5fj7 foreign key (site_id) references sites;
alter table ways add constraint FK9vn74muwnup3ljkc5lxk5iwtv foreign key (zone_id) references points;




	
	