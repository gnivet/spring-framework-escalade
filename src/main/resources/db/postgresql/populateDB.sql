delete from zones; 
insert into zones (name, site_id, id) values ('Zone A', '652', '1');
insert into zones (name, site_id, id) values ('Zone B', '653', '2');
delete from points;
INSERT INTO public.points(id, name, length_id) 	VALUES ('1', 'point A', '1');
INSERT INTO public.points(id, name, length_id) 	VALUES ('2', 'point A', '2');
	
